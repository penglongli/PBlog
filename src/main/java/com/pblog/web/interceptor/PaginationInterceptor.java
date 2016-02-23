package com.pblog.web.interceptor;

import com.pblog.core.orm.Pagination;
import com.pblog.core.utils.ReflectUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PaginationInterceptor implements Interceptor {
    private static final Log logger = LogFactory.getLog(PaginationInterceptor.class);

    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler target = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = target.getBoundSql();
        String sql = boundSql.getSql();
        Object obj = boundSql.getParameterObject();
        if(obj instanceof Pagination<?>){
            Pagination<?> pagination = (Pagination<?>) obj;

            Object delegate = ReflectUtils.getFieldValue(target, "delegate");
            MappedStatement mappedStatement = (MappedStatement) ReflectUtils.getFieldValue(delegate, "mappedStatement");
            RowBounds rowBounds = (RowBounds) ReflectUtils.getFieldValue(delegate, "rowBounds");

            if(null != rowBounds && rowBounds.getOffset() != RowBounds.NO_ROW_LIMIT){
                //重构sql语句
                ReflectUtils.setFieldValue(boundSql, "sql", buildSql(sql, rowBounds));
                Connection connection = (Connection) invocation.getArgs()[0];
                //设置总页数
                setPageParameter(sql, connection, pagination);
            }
        }
        // 将执行权交给下一个拦截器
        return invocation.proceed();
    }

    private String buildSql(String oldSql, RowBounds rowBounds){
        String sql = oldSql + " limit " + rowBounds.getOffset() + "," + rowBounds.getLimit();
        ReflectUtils.setFieldValue(rowBounds, "offset", RowBounds.NO_ROW_OFFSET);
        ReflectUtils.setFieldValue(rowBounds, "limit", RowBounds.NO_ROW_LIMIT);
        return sql;
    }

    private void setPageParameter(String sql, Connection connection, Pagination<?> pagination) {
        // 记录总记录数
        String countSql = "select count(1) from (" + sql + ") as total";
        PreparedStatement countStmt = null;
        ResultSet rs = null;
        try {
            countStmt = connection.prepareStatement(countSql);
            rs = countStmt.executeQuery();
            int totalCount = 0;
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
            pagination.setTotalCount(totalCount);
            int totalPage = totalCount / pagination.getPageSize() + ((totalCount % pagination.getPageSize() == 0) ? 0 : 1);
            pagination.setTotalPage(totalPage);
        } catch (SQLException e) {
            logger.error("Ignore this exception", e);
        } finally {
            try {
                rs.close();
                countStmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (NullPointerException e){
                e.printStackTrace();
            }
        }

    }

    public Object plugin(Object target) {
        // 当目标类是StatementHandler类型时，才包装目标类，否者直接返回目标本身,减少目标被代理的次数
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    public void setProperties(Properties properties) {
    }

}

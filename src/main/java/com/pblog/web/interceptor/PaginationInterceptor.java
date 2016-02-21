package com.pblog.web.interceptor;

import com.pblog.core.orm.PageRequest;
import com.pblog.core.utils.ReflectUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.Properties;

@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})})
public class PaginationInterceptor implements Interceptor{

    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler target = (StatementHandler) invocation.getTarget();
        BoundSql boundSql = target.getBoundSql();
        String sql = boundSql.getSql();
        Object obj = boundSql.getParameterObject();
        if(obj instanceof PageRequest){
            Object delegate = ReflectUtils.getFieldValue(target, "delegate");
            RowBounds rowBounds = (RowBounds) ReflectUtils.getFieldValue(delegate, "rowBounds");
            if(null != rowBounds && rowBounds.getOffset() != RowBounds.NO_ROW_LIMIT){
                ReflectUtils.setFieldValue(boundSql, "sql", buildSql(sql, rowBounds));
            }
        }
        return invocation.proceed();
    }

    private String buildSql(String oldSql, RowBounds rowBounds){
        String sql = oldSql + " limit " + rowBounds.getOffset() + "," + rowBounds.getLimit();
        ReflectUtils.setFieldValue(rowBounds, "offset", RowBounds.NO_ROW_OFFSET);
        ReflectUtils.setFieldValue(rowBounds, "limit", RowBounds.NO_ROW_LIMIT);
        return sql;
    }

    public Object plugin(Object o) {
        return null;
    }

    public void setProperties(Properties properties) {

    }
}

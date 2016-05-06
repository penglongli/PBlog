package com.pblog.service.book;

import com.pblog.dao.BookTableMapper;
import com.pblog.domain.BookTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "manageBookTableService")
public class ManageBookTableServiceImpl implements ManageBookTableService{

    @Autowired
    private BookTableMapper bookTableMapper;

    public int insert(BookTable bookTable) {
        if(null == bookTable.getBookBanner() || null == bookTable.getBookUrl()) {
            throw new NullPointerException("in insert(), bookTable's banner or url cannot be null !");
        }

        return bookTableMapper.insert(bookTable);
    }

    public int update(BookTable bookTable) {
        if(null == bookTable.getId()) {
            throw new NullPointerException("in update(), bookTable's id cannot be null !");
        }
        if(null == bookTable.getBookBanner() || null == bookTable.getBookUrl()) {
            throw new NullPointerException("in update(), bookTable's banner or url cannot be null !");
        }

        return bookTableMapper.updateByPrimaryKey(bookTable);
    }

    public int delete(Integer id) {
        if(null == id) {
            throw new NullPointerException("in delete(), id cannot be null !");
        }

        return bookTableMapper.deleteByPrimaryKey(id);
    }

    public List<BookTable> findAll() {

        return bookTableMapper.selectAll();
    }
}

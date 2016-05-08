package com.pblog.service.book;

import com.google.common.collect.Lists;
import com.pblog.dao.BookTableMapper;
import com.pblog.domain.BookTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "bookTableService")
@Transactional
public class BookTableServiceImpl implements BookTableService{

    @Autowired
    private BookTableMapper bookTableMapper;

    public List<BookTableVO> findList() {
        List<BookTableVO> bookTableVOList = Lists.newArrayList();

        List<BookTable> bookTableList = bookTableMapper.selectAll();
        for(BookTable bookTable : bookTableList) {
            BookTableVO bookTableVO = transToBookTableVO(bookTable);

            bookTableVOList.add(bookTableVO);
        }
        return bookTableVOList;
    }

    private BookTableVO transToBookTableVO(BookTable bookTable) {
        BookTableVO bookTableVO = new BookTableVO();

        bookTableVO.setBookBanner(bookTable.getBookBanner());
        bookTableVO.setBookName(bookTable.getBookName());
        bookTableVO.setBookUrl(bookTable.getBookUrl());

        return bookTableVO;
    }
}

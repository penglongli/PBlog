package com.pblog.service.book;


import java.util.List;

public interface BookInfoService {

    List<BookInfoVO> findList();

    BookInfoVO findBySlug(Long slug);
}

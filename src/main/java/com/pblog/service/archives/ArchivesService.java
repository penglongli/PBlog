package com.pblog.service.archives;

import com.pblog.service.article.ArticleInfoVO;

import java.text.ParseException;
import java.util.List;

public interface ArchivesService {

    List<ArchivesVO> findArchivesList() throws ParseException;

    List<ArticleInfoVO> findArticleByMonth(String timeStamp) throws ParseException;
}

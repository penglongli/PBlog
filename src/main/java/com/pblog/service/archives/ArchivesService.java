package com.pblog.service.archives;

import java.text.ParseException;
import java.util.List;

public interface ArchivesService {

    List<ArchivesVO> findArchivesList() throws ParseException;
}

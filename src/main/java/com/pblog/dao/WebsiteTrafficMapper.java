package com.pblog.dao;

import com.pblog.domain.WebsiteTraffic;

import java.util.List;

public interface WebsiteTrafficMapper {

    int insert(WebsiteTraffic record);

    List<WebsiteTraffic> queryByIpAddress(String ipAddress);
}
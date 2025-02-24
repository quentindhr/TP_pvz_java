package com.epf.service;

import java.util.List;

import com.epf.Map;

public interface MapService {
    void addMap(Map map);
    List<Map> getAllMaps();
    Map getMapById(int id);
    void updateMap(Map map);
    void removeMap(int id);
}

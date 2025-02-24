package com.epf.dao;

import java.util.List;

import com.epf.Map;

public interface MapDAO {
    void createMap(Map map);
    List<Map> getAllMaps();
    Map getMapById(int id);
    void updateMap(Map map);
    void deleteMap(int id);
}

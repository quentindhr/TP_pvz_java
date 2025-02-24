package com.epf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.Map;
import com.epf.dao.MapDAO;
import com.epf.service.MapService;

@Service
public class MapServiceImpl implements MapService {

    private final MapDAO mapDao;

    @Autowired
    public MapServiceImpl(MapDAO mapDao) {
        this.mapDao = mapDao;
    }

    @Override
    public void addMap(Map map) {
        mapDao.createMap(map);
    }

    @Override
    public List<Map> getAllMaps() {
        return mapDao.getAllMaps();
    }

    @Override
    public Map getMapById(int id) {
        return mapDao.getMapById(id);
    }

    @Override
    public void updateMap(Map map) {
        mapDao.updateMap(map);
    }

    @Override
    public void removeMap(int id) {
        mapDao.deleteMap(id);
    }
}


package com.epf.ImplService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.Map;
import com.epf.dao.MapDAO;
import com.epf.service.MapService;

@Service
public class ImplMap implements MapService {

    private final MapDAO mapDAO;

    @Autowired
    public ImplMap(MapDAO mapDAO) {
        this.mapDAO = mapDAO;
    }

    @Override
    public void addMap(Map map) {
        // Appliquer la logique métier si nécessaire avant d'ajouter la carte
        mapDAO.createMap(map);
    }

    @Override
    public List<Map> getAllMaps() {
        // Appliquer des filtres ou des règles métier si nécessaire
        return mapDAO.getAllMaps();
    }

    @Override
    public Map getMapById(int id) {
        // Appliquer des règles métier si nécessaire
        return mapDAO.getMapById(id);
    }

    @Override
    public void updateMap(Map map) {
        // Appliquer la logique métier si nécessaire avant de mettre à jour la carte
        mapDAO.updateMap(map);
    }

    @Override
    public void removeMap(int id) {
        // Appliquer la logique métier si nécessaire avant de supprimer la carte
        mapDAO.deleteMap(id);
    }
}

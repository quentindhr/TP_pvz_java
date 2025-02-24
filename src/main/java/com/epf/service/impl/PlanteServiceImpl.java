package com.epf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.Plante;
import com.epf.dao.PlanteDAO;
import com.epf.service.PlanteService;

@Service
public class PlanteServiceImpl implements PlanteService {

    private final PlanteDAO planteDao;

    @Autowired
    public PlanteServiceImpl(PlanteDAO planteDao) {
        this.planteDao = planteDao;
    }

    @Override
    public void addPlante(Plante plante) {
        planteDao.createPlante(plante);
    }

    @Override
    public List<Plante> getAllPlantes() {
        return planteDao.getAllPlantes();
    }

    @Override
    public Plante getPlanteById(String id) {
        return planteDao.getPlanteById(id);
    }

    @Override
    public void updatePlante(Plante plante) {
        planteDao.updatePlante(plante);
    }

    @Override
    public void removePlante(String id) {
        planteDao.deletePlante(id);
    }
}


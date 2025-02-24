package com.epf.dao;

import java.util.List;

import com.epf.Plante;

public interface PlanteDAO {
    void createPlante(Plante plante);
    List<Plante> getAllPlantes();
    Plante getPlanteById(String id);
    void updatePlante(Plante plante);
    void deletePlante(String id);
}


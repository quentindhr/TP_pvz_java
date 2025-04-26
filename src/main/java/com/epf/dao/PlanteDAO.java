package com.epf.dao;

import java.util.List;

import com.epf.Plante;

public interface PlanteDAO {
    void createPlante(Plante plante);
    List<Plante> getAllPlantes();
    Plante getPlanteById(int id);
    void updatePlante(Plante plante);
    void deletePlante(int id);
}


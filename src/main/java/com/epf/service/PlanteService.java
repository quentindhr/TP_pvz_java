package com.epf.service;

import java.util.List;

import com.epf.Plante;

public interface PlanteService {
    void addPlante(Plante plante);
    List<Plante> getAllPlantes();
    Plante getPlanteById(String id);
    void updatePlante(Plante plante);
    void removePlante(String id);
}


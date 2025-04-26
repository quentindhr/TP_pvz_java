package com.epf.ImplService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.Plante;
import com.epf.dao.PlanteDAO;
import com.epf.service.PlanteService;

@Service
public class ImplPlante implements PlanteService {

    private final PlanteDAO planteDAO;

    @Autowired
    public ImplPlante(PlanteDAO planteDAO) {
        this.planteDAO = planteDAO;
    }

    @Override
    public void addPlante(Plante plante) {
        // Appliquer la logique métier si nécessaire avant d'ajouter la plante
        planteDAO.createPlante(plante);
    }

    @Override
    public List<Plante> getAllPlantes() {
        // Appliquer des filtres ou des règles métier si nécessaire
        return planteDAO.getAllPlantes();
    }

    @Override
    public Plante getPlanteById(int id) {
        // Appliquer des règles métier si nécessaire
        return planteDAO.getPlanteById(id);
    }

    @Override
    public void updatePlante(Plante plante) {
        // Appliquer la logique métier si nécessaire avant de mettre à jour la plante
        planteDAO.updatePlante(plante);
    }

    @Override
    public void removePlante(int id) {
        // Appliquer la logique métier si nécessaire avant de supprimer la plante
        planteDAO.deletePlante(id);
    }
}

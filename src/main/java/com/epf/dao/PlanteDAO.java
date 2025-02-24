package com.epf.dao;

import scala.collection.immutable.List;

public interface PlanteDAO {

    void createPlante(int id, String name);
    String gePlante(int id);
    void updatePlante(int id, String newName);
    void deletePlante(int id);
    List<String> getAllPlantes();
    
    
}

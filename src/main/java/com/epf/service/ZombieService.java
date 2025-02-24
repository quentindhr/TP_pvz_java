package com.epf.service;

import java.util.List;

import com.epf.Zombie;

public interface ZombieService {
    void addZombie(Zombie zombie);
    List<Zombie> getAllZombies();
    Zombie getZombieById(String id);
    void updateZombie(Zombie zombie);
    void removeZombie(String id);
    List<Zombie> getZombiesByMapId(String mapId);
}


package com.epf.service;

import java.util.List;

import com.epf.Zombie;

public interface ZombieService {
    void addZombie(Zombie zombie);
    List<Zombie> getAllZombies();
    Zombie getZombieById(int id);
    void updateZombie(Zombie zombie);
    void deleteZombie(int id);
    List<Zombie> getZombiesByMapId(int mapId);
}


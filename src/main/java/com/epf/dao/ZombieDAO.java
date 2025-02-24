package com.epf.dao;

import java.util.List;

import com.epf.Zombie;

public interface ZombieDAO {
    void createZombie(Zombie zombie);
    List<Zombie> getAllZombies();
    Zombie getZombieById(String id);
    void updateZombie(Zombie zombie);
    void deleteZombie(String id);
    List<Zombie> getZombiesByMapId(String mapId);
}

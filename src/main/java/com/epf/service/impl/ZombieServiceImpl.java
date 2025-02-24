package com.epf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.Zombie;
import com.epf.dao.ZombieDAO;
import com.epf.service.ZombieService;

@Service
public class ZombieServiceImpl implements ZombieService {

    private final ZombieDAO zombieDao;

    @Autowired
    public ZombieServiceImpl(ZombieDAO zombieDao) {
        this.zombieDao = zombieDao;
    }

    @Override
    public void addZombie(Zombie zombie) {
        zombieDao.createZombie(zombie);
    }

    @Override
    public List<Zombie> getAllZombies() {
        return zombieDao.getAllZombies();
    }

    @Override
    public Zombie getZombieById(String id) {
        return zombieDao.getZombieById(id);
    }

    @Override
    public void updateZombie(Zombie zombie) {
        zombieDao.updateZombie(zombie);
    }

    @Override
    public void removeZombie(String id) {
        zombieDao.deleteZombie(id);
    }

    @Override
    public List<Zombie> getZombiesByMapId(String mapId) {
        return zombieDao.getZombiesByMapId(mapId);
    }
}


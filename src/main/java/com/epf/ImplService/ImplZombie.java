package com.epf.ImplService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epf.Zombie;
import com.epf.dao.ZombieDAO;
import com.epf.service.ZombieService;

@Service
public class ImplZombie implements ZombieService {

    private final ZombieDAO zombieDAO;

    @Autowired
    public ImplZombie(ZombieDAO zombieDAO) {
        this.zombieDAO = zombieDAO;
    }

    @Override
    public void addZombie(Zombie zombie) {
        // Appliquer la logique métier si nécessaire avant d'ajouter le zombie
        zombieDAO.createZombie(zombie);
    }

    @Override
    public List<Zombie> getAllZombies() {
        // Appliquer des filtres ou des règles métier si nécessaire
        return zombieDAO.getAllZombies();
    }

    @Override
    public Zombie getZombieById(String id) {
        // Appliquer des règles métier si nécessaire
        return zombieDAO.getZombieById(id);
    }

    @Override
    public void updateZombie(Zombie zombie) {
        // Appliquer la logique métier si nécessaire avant de mettre à jour le zombie
        zombieDAO.updateZombie(zombie);
    }

    @Override
    public void removeZombie(String id) {
        // Appliquer la logique métier si nécessaire avant de supprimer le zombie
        zombieDAO.deleteZombie(id);
    }

    @Override
        public List<Zombie> getZombiesByMapId(String mapId) {
        return zombieDAO.getZombiesByMapId(mapId);
    }

}

package com.epf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.Zombie;
import com.epf.service.ZombieService;

@RequestMapping("/zombies")
@RestController
public class ZombieController {
    
    private final ZombieService zombieService;

    @Autowired
    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    @PostMapping("/add")
    public void addZombie(@RequestBody Zombie zombie) {
        zombieService.addZombie(zombie);
    }
}

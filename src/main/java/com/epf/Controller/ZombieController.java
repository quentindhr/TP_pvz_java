package com.epf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.Zombie;
import com.epf.service.ZombieService;


@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/zombies")
@RestController
public class ZombieController {
    
    private final ZombieService zombieService;

    @Autowired
    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    @PostMapping("")
    public void addZombie(@RequestBody Zombie zombie) {
        zombieService.addZombie(zombie);
    }

    @GetMapping("")
    public java.util.List<Zombie> getAllZombies() {
        return zombieService.getAllZombies();
    }

    @PutMapping("/{id}")
    public void updateZombie(@PathVariable("id") int id, @RequestBody Zombie zombie) {
        zombie.setId_zombie(id); 
        zombieService.updateZombie(zombie);
    }


    @DeleteMapping("/{id}")
    public void deleteZombie(@PathVariable("id") int id) {
        zombieService.deleteZombie(id);
    }
    

    
}

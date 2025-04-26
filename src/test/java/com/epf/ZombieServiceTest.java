package com.epf;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;

import com.epf.ImplService.ImplZombie;
import com.epf.service.ZombieService;

public class ZombieServiceTest {
    
    @Mock
    private ZombieService zombieService;
    
    @InjectMocks
    private ImplZombie implZombie;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddZombie() {
        Zombie zombie = new Zombie(123, "Zombie1", 10, 10.0f, 5, 2, "chemin1", 1);
        
        Mockito.doNothing().when(zombieService).addZombie(zombie);

        zombieService.addZombie(zombie);

        Mockito.verify(zombieService, Mockito.times(1)).addZombie(zombie);
    }

    @Test
    void testGetAllZombies() {
        Zombie z1 = new Zombie(123, "Zombie1", 10, 10.0f, 5, 2, "chemin1", 1);
        Zombie z2 = new Zombie(456, "Zombie2", 20, 15.0f, 7, 3, "chemin2", 2);

        List<Zombie> expectedZombies = java.util.Arrays.asList(z1, z2);

        Mockito.when(zombieService.getAllZombies()).thenReturn(expectedZombies);

        List<Zombie> result = zombieService.getAllZombies();

        verify(zombieService, Mockito.times(1)).getAllZombies();
        assert(result.size() == 2);
        assert(result.contains(z1) && result.contains(z2));
    }

    @Test
    void testGetZombieByMapId() {
        Zombie z1 = new Zombie(123, "Zombie1", 10, 10.0f, 5, 2, "chemin1", 1);
        Zombie z2 = new Zombie(456, "Zombie2", 20, 15.0f, 7, 3, "chemin2", 1);

        List<Zombie> expectedZombies = java.util.Arrays.asList(z1, z2);

        Mockito.when(zombieService.getZombiesByMapId(1)).thenReturn(expectedZombies);

        List<Zombie> result = zombieService.getZombiesByMapId(1);

        verify(zombieService, Mockito.times(1)).getZombiesByMapId(1);
        assert(result.size() == 2);
        assert(result.contains(z1) && result.contains(z2));
    }

    @Test
    void testDeleteZombie() {
        Zombie zombie = new Zombie(123, "Zombie1", 10, 10.0f, 5, 2, "chemin1", 1);
        
        Mockito.doNothing().when(zombieService).deleteZombie(123);

        zombieService.deleteZombie(123);

        Mockito.verify(zombieService, Mockito.times(1)).deleteZombie(123);
    }

    @Test
    void testGetZombieById() {
        Zombie zombie = new Zombie(123, "Zombie1", 10, 10.0f, 5, 2, "chemin1", 1);
        
        Mockito.when(zombieService.getZombieById(123)).thenReturn(zombie);

        Zombie result = zombieService.getZombieById(123);

        verify(zombieService, Mockito.times(1)).getZombieById(123);
        assert(result.equals(zombie));
    }

    @Test
    void testUpdateZombie() {
        Zombie zombie = new Zombie(123, "Zombie1", 10, 10.0f, 5, 2, "chemin1", 1);
        
        Mockito.doNothing().when(zombieService).updateZombie(zombie);

        zombieService.updateZombie(zombie);

        Mockito.verify(zombieService, Mockito.times(1)).updateZombie(zombie);

    }



}

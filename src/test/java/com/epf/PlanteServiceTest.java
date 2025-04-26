package com.epf;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.epf.ImplService.ImplPlante;

class PlanteServiceTest {

    @Mock
    private PlanteRepository planteRepository; 

    @InjectMocks
    private ImplPlante planteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddPlante() {
        Plante serge = new Plante(123, "Serge", 17, 13.0f, 12, 1, 1, Plante.effet.NORMAL, "chemin/image");
        
        doNothing().when(planteRepository).createPlante(serge);

        planteService.addPlante(serge);

        verify(planteRepository, times(1)).createPlante(serge);
    }

    @Test
    void testGetAllPlantes() {
        Plante p1 = new Plante(123, "Plante1", 10, 10.0f, 5, 2, 3, Plante.effet.NORMAL, "chemin1");
        Plante p2 = new Plante(456, "Plante2", 20, 15.0f, 7, 3, 2, Plante.effet.NORMAL, "chemin2");

        List<Plante> expectedPlantes = Arrays.asList(p1, p2);

        when(planteRepository.getAllPlantes()).thenReturn(expectedPlantes);

        List<Plante> result = planteService.getAllPlantes();

        verify(planteRepository, times(1)).getAllPlantes();
        assert(result.size() == 2);
        assert(result.contains(p1) && result.contains(p2));
    }

    @Test
    void testGetPlanteById() {
        Plante p = new Plante(123, "Plante1", 10, 10.0f, 5, 2, 3, Plante.effet.NORMAL, "chemin1");

        when(planteRepository.getPlanteById(123)).thenReturn(p);

        Plante result = planteService.getPlanteById(123);

        verify(planteRepository, times(1)).getPlanteById(123);
        assert(result.getNom().equals("Plante1"));
    }

    @Test
    void testUpdatePlante() {
        Plante p = new Plante(123, "Plante1", 10, 10.0f, 5, 2, 3, Plante.effet.NORMAL, "chemin1");

        doNothing().when(planteRepository).updatePlante(p);

        planteService.updatePlante(p);

        verify(planteRepository, times(1)).updatePlante(p);
    }

    @Test
    void testRemovePlante() {
        int id =123;

        doNothing().when(planteRepository).deletePlante(id);

        planteService.removePlante(id);

        verify(planteRepository, times(1)).deletePlante(id);
    }
}

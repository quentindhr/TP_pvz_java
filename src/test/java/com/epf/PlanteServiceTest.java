package com.epf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
        // Création d'une plante fictive
        Plante serge = new Plante(
            "123",
            "Serge",
            17,
            13.0f,
            12,
            1,
            1,
            Plante.effet.NORMAL,
            "chemin/image"
        );

        // Simulation du comportement du repository
        doNothing().when(planteRepository).createPlante(serge);

        // Exécution de la méthode testée
        planteService.addPlante(serge);

        // Vérification que la méthode save a bien été appelée une fois avec l'objet attendu
        verify(planteRepository, times(1)).createPlante(serge);
    }
}

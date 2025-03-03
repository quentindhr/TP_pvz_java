package com.epf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.config.AppConfig;
import com.epf.service.PlanteService;

public class Main {
    public static void main(String[] args) {
        // Charger le contexte Spring
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Obtenir le service PlanteService à partir du contexte
        PlanteService planteService = context.getBean(PlanteService.class);

        // Créer une nouvelle instance de Plante
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

        // Ajouter la plante à la base de données
        planteService.addPlante(serge);

        System.out.println("Plante ajoutée avec succès!");
    }
}

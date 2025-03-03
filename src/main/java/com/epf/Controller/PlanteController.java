package com.epf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.Plante;
import com.epf.service.PlanteService;

@RestController
@RequestMapping("/plantes")
public class PlanteController {

    private final PlanteService planteService;

    @Autowired
    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    @PostMapping("/add")
    public void addPlante(@RequestBody Plante plante) {
        planteService.addPlante(plante);
    }
}

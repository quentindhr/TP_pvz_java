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

import com.epf.Plante;
import com.epf.service.PlanteService;

@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/plantes")
@RestController
public class PlanteController {

    private final PlanteService planteService;

    @Autowired
    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    @PostMapping("")
    public void addPlante(@RequestBody Plante plante) {
        planteService.addPlante(plante);
    }

    @GetMapping("")
    public java.util.List<Plante> getAllPlantes() {
        return planteService.getAllPlantes();
    }

    @PutMapping("/{id}")
    public void updatePlante(@PathVariable("id") int id, @RequestBody Plante plante) {
        plante.setId_plante(id); 
        planteService.updatePlante(plante);
    }

    @DeleteMapping("/{id}")
    public void deletePlante(@PathVariable("id") int id) {
        planteService.removePlante(id);
    }
    
}

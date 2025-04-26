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

import com.epf.Map;
import com.epf.service.MapService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/maps")
public class MapController {
    
    private final MapService mapService;

    @Autowired  
    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @PostMapping("")
    public void addMap(@RequestBody Map map) {
        mapService.addMap(map);
    }

    @GetMapping("")
    public java.util.List<Map> getAllMaps() {
        return mapService.getAllMaps();
    }

    @PutMapping("/{id}")
    public void updateMap(@PathVariable("id") int id, @RequestBody Map map) {
        map.setId_map(id); 
        mapService.updateMap(map);
    }
   

    @DeleteMapping("/{id}")
    public void deleteMap(@PathVariable("id") int id) {
        mapService.deleteMap(id);
    }

}

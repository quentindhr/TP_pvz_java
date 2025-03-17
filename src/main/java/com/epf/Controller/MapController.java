package com.epf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epf.Map;
import com.epf.service.MapService;

@RestController
@RequestMapping("/map")
public class MapController {
    
    private final MapService mapService;

    @Autowired  
    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @PostMapping("/add")
    public void addMap(@RequestBody Map map) {
        mapService.addMap(map);
    }
}

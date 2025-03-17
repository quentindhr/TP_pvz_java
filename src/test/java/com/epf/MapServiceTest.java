package com.epf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epf.ImplService.ImplMap;
import com.epf.service.MapService;

public class MapServiceTest {
    @Mock
    private MapService mapService;

    @InjectMocks
    private ImplMap implMap;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddMap() {
        Map map = new Map(1, 2, 3, "/map");

        Mockito.doNothing().when(mapService).addMap(map);

        mapService.addMap(map);

        Mockito.verify(mapService, Mockito.times(1)).addMap(map);
    }

    @Test
    void testGetAllMaps() {
        Map m1 = new Map(1, 2, 3, "/map1");
        Map m2 = new Map(4, 5, 6, "/map2");

        java.util.List<Map> expectedMaps = java.util.Arrays.asList(m1, m2);

        Mockito.when(mapService.getAllMaps()).thenReturn(expectedMaps);

        java.util.List<Map> result = mapService.getAllMaps();

        Mockito.verify(mapService, Mockito.times(1)).getAllMaps();
        assert(result.size() == 2);
        assert(result.contains(m1) && result.contains(m2));
    }

    @Test
    void testGetMapById() {
        Map m = new Map(1, 2, 3, "/map1");

        Mockito.when(mapService.getMapById(1)).thenReturn(m);

        Map result = mapService.getMapById(1);

        Mockito.verify(mapService, Mockito.times(1)).getMapById(1);
        assert(result.equals(m));
    }

    @Test
    void testUpdateMap() {
        Map map = new Map(1, 2, 3, "/map");

        Mockito.doNothing().when(mapService).updateMap(map);

        mapService.updateMap(map);

        Mockito.verify(mapService, Mockito.times(1)).updateMap(map);
    }
    
    @Test
    void testDeleteMap() {
        Map map = new Map(1, 2, 3, "/map");

        Mockito.doNothing().when(mapService).deleteMap(1);

        mapService.deleteMap(1);

        Mockito.verify(mapService, Mockito.times(1)).deleteMap(1);
    }
}

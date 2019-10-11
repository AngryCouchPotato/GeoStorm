package com.kaa.geostorm.controller;

import com.kaa.geostorm.dto.CityDto;
import com.kaa.geostorm.service.GeoNamesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class GeoNamesController {

    private GeoNamesService geoNamesService;

    @GetMapping("/{name}")
    public List<CityDto> find(@PathVariable String name, @RequestParam int maxRows, @RequestParam int startRow) {
        return geoNamesService.find(name, maxRows, startRow);
    }

}

package com.kaa.geostorm.controller;

import com.kaa.geostorm.dto.GeoNameDto;
import com.kaa.geostorm.service.GeoNamesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/geonames")
@AllArgsConstructor
public class GeoNamesController {

    private GeoNamesService geoNamesService;

    @GetMapping
    public List<GeoNameDto> find(@RequestParam String name) {
        return geoNamesService.find(name);
    }

}

package com.kaa.geostorm.service;

import com.kaa.geostorm.dto.CityDto;

import java.util.List;

public interface GeoNamesService {

    List<CityDto> find(String name, int maxRows, int startRow);

}
package com.kaa.geostorm.service;

import com.kaa.geostorm.dto.GeoNameDto;

import java.util.List;

public interface GeoNamesService {

    List<GeoNameDto> find(String name);

}
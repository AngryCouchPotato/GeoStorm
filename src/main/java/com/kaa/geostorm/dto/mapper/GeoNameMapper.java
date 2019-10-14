package com.kaa.geostorm.dto.mapper;

import com.kaa.geostorm.domain.GeoName;
import com.kaa.geostorm.dto.GeoNameDto;
import org.springframework.stereotype.Component;

@Component
public class GeoNameMapper implements Mapper<GeoName, GeoNameDto>{
    @Override
    public GeoNameDto map(GeoName geoName) {
        GeoNameDto geoNameDto = new GeoNameDto();
        geoNameDto.setAdminName1(geoName.getAdminName1());
        geoNameDto.setCountryId(geoName.getCountryId());
        geoNameDto.setCountryCode(geoName.getCountryCode());
        geoNameDto.setCountryName(geoName.getCountryName());
        geoNameDto.setFcodeName(geoName.getFcodeName());
        geoNameDto.setGeonameId(geoName.getGeonameId());
        geoNameDto.setName(geoName.getName());
        geoNameDto.setPopulation(geoName.getPopulation());
        geoNameDto.setToponymName(geoName.getToponymName());
        geoNameDto.setLat(geoName.getLat());
        geoNameDto.setLng(geoName.getLng());
        return geoNameDto;
    }
}

package com.kaa.geostorm.dto.mapper;

import com.kaa.geostorm.domain.GeoName;
import com.kaa.geostorm.dto.CityDto;
import org.springframework.stereotype.Component;

@Component
public class CityMapper implements Mapper<GeoName, CityDto>{
    @Override
    public CityDto map(GeoName geoName) {
        CityDto city = new CityDto();
        city.setAdminName1(geoName.getAdminName1());
        city.setCountryId(geoName.getCountryId());
        city.setCountryCode(geoName.getCountryCode());
        city.setCountryName(geoName.getCountryName());
        city.setFcodeName(geoName.getFcodeName());
        city.setGeonameId(geoName.getGeonameId());
        city.setName(geoName.getName());
        city.setPopulation(geoName.getPopulation());
        city.setToponymName(geoName.getToponymName());
        return city;
    }
}

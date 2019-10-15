package com.kaa.geostorm.dto.mapper;

import com.kaa.geostorm.Utils;
import com.kaa.geostorm.domain.GeoName;
import com.kaa.geostorm.dto.GeoNameDto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeoNameMapperTest {

    @Test
    public void map() {
        // Given
        GeoNameMapper mapper = new GeoNameMapper();
        GeoName geoName = Utils.createGeoName();

        // When
        GeoNameDto geoNameDto = mapper.map(geoName);

        // Then
        Utils.assertGeoName(geoName, geoNameDto);
    }

    @Test
    public void mapList() {
        // Given
        GeoNameMapper mapper = new GeoNameMapper();
        List<GeoName> geoNames = Utils.createGeoNames();

        // When
        List<GeoNameDto> geoNameDtos = mapper.map(geoNames);

        // Then
        assertEquals(geoNameDtos.size(), geoNameDtos.size());
        for(int i = 0; i < 10; i++) {
            Utils.assertGeoName(geoNames.get(i), geoNameDtos.get(i));
        }
    }





}
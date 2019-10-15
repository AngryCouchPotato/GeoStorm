package com.kaa.geostorm;

import com.kaa.geostorm.domain.GeoName;
import com.kaa.geostorm.dto.GeoNameDto;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Utils {

    public static List<GeoName> createGeoNames() {
        List<GeoName> geoNames = new ArrayList<>(10);
        GeoName geoName = createGeoName();
        GeoName current;
        for(int i = 1; i <= 10; i++){
            current = new GeoName();
            current.setAdminName1(geoName.getAdminName1() + i);
            current.setCountryId(geoName.getCountryId() + i);
            current.setCountryCode(geoName.getCountryCode() + i);
            current.setCountryName(geoName.getCountryCode() + i);
            current.setFcodeName(geoName.getFcodeName() + i);
            current.setGeonameId(geoName.getGeonameId() + i);
            current.setName(geoName.getName() + i);
            current.setPopulation(geoName.getPopulation() + i);
            current.setToponymName(geoName.getToponymName() + 1);
            current.setLat(geoName.getLat() + i);
            current.setLng(geoName.getLng() + i);
            geoNames.add(current);
        }
        return geoNames;
    }

    public static GeoName createGeoName() {
        GeoName geoName = new GeoName();
        geoName.setAdminName1("adminName");
        geoName.setCountryId(1);
        geoName.setCountryCode("CountryCode");
        geoName.setCountryName("CountryName");
        geoName.setFcodeName("FcodeName");
        geoName.setGeonameId(1);
        geoName.setName("Name");
        geoName.setPopulation(1111);
        geoName.setToponymName("ToponymName");
        geoName.setLat(111);
        geoName.setLng(222);
        return geoName;
    }

    public static void assertGeoName(GeoName geoName, GeoNameDto geoNameDto){
        assertEquals(geoName.getAdminName1(), geoNameDto.getAdminName1());
        assertEquals(geoName.getCountryId(), geoNameDto.getCountryId());
        assertEquals(geoName.getCountryCode(), geoNameDto.getCountryCode());
        assertEquals(geoName.getCountryName(), geoNameDto.getCountryName());
        assertEquals(geoName.getFcodeName(), geoNameDto.getFcodeName());
        assertEquals(geoName.getGeonameId(), geoNameDto.getGeonameId());
        assertEquals(geoName.getName(), geoNameDto.getName());
        assertEquals(geoName.getPopulation(), geoNameDto.getPopulation());
        assertEquals(geoName.getToponymName(), geoNameDto.getToponymName());
        assertEquals(geoName.getLat(), geoNameDto.getLat(), 0.000000001);
        assertEquals(geoName.getLng(), geoNameDto.getLng(), 0.000000001);
    }
}

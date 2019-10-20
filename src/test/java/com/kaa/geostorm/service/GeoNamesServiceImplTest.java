package com.kaa.geostorm.service;

import com.kaa.geostorm.Utils;
import com.kaa.geostorm.domain.GeoName;
import com.kaa.geostorm.domain.GeoNames;
import com.kaa.geostorm.dto.GeoNameDto;
import com.kaa.geostorm.dto.mapper.GeoNameMapper;
import com.kaa.geostorm.dto.mapper.Mapper;
import com.kaa.geostorm.exception.CanNotGetDataException;
import com.kaa.geostorm.properties.GeoNamesProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class GeoNamesServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Spy
    private Mapper<GeoName, GeoNameDto> mapper = new GeoNameMapper();

    @Spy
    private GeoNamesProperties properties = new GeoNamesProperties("testUser", "http://api.geonames.org/search");

    @InjectMocks
    private GeoNamesServiceImpl geoNamesService;

    @Test
    public void find() {
        // Given
        List<GeoName> geoNames = Utils.createGeoNames();
        GeoNames geoNamesBean = new GeoNames();
        geoNamesBean.setGeonames(geoNames);
        String name = "test";

        Mockito
                .when(restTemplate.exchange(
                        ArgumentMatchers.any(),
                        ArgumentMatchers.eq(HttpMethod.GET),
                        ArgumentMatchers.nullable(ResponseEntity.class),
                        ArgumentMatchers.<ParameterizedTypeReference<GeoNames>>any()))
                .thenReturn(new ResponseEntity<>(geoNamesBean, HttpStatus.OK));

        // When
        List<GeoNameDto> geoNameDtos = geoNamesService.find(name);

        // Then
        assertNotNull(geoNameDtos);
        assertEquals(geoNames.size(), geoNameDtos.size());
        for(int i = 0; i < 10; i++) {
            Utils.assertGeoName(geoNames.get(i), geoNameDtos.get(i));
        }
    }

    @Test(expected = CanNotGetDataException.class)
    public void findExceptional() {
        // Given
        GeoNames geoNamesBean = new GeoNames();
        geoNamesBean.setGeonames(Utils.createGeoNames());
        String name = "test";

        Mockito
                .when(restTemplate.exchange(
                        ArgumentMatchers.any(),
                        ArgumentMatchers.eq(HttpMethod.GET),
                        ArgumentMatchers.nullable(ResponseEntity.class),
                        ArgumentMatchers.<ParameterizedTypeReference<GeoNames>>any()))
                .thenThrow(new RestClientException("Test Exception"));

        // When
        geoNamesService.find(name);
    }

    @Test
    public void buildUri() {
        // Given
        String expected = "http://api.geonames.org/search?name=test&userName=testUser&type=json";
        String name = "test";

        // When
        URI uri = geoNamesService.buildUri(name);

        // Then
        assertNotNull(uri);
        assertEquals(expected, uri.toString());
    }

}
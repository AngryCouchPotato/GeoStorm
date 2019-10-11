package com.kaa.geostorm.service;

import com.kaa.geostorm.domain.GeoName;
import com.kaa.geostorm.domain.GeoNames;
import com.kaa.geostorm.dto.CityDto;
import com.kaa.geostorm.dto.mapper.Mapper;
import com.kaa.geostorm.properties.GeoNamesProperties;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
@AllArgsConstructor
public class GeoNamesServiceImpl implements GeoNamesService {

    private static final Logger logger = LoggerFactory.getLogger(GeoNamesServiceImpl.class);

    private GeoNamesProperties geoNamesProperties;

    private RestTemplate restTemplate;

    private Mapper<GeoName, CityDto> mapper;

    @Override
    public List<CityDto> find(String name, int maxRows, int startRow) {
        List<CityDto> cities = mapper.map(
                restTemplate.exchange(//todo add catch clause
                        buildUri(name, maxRows, startRow),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<GeoNames>() {
                        })
                        .getBody().getGeonames()
        );
        logger.debug(String.format("For name = %s was founded %d cities", name, cities.size()));
        return cities;
    }

    private URI buildUri(String name, int maxRows, int startRow) {
        UriComponentsBuilder uriComponentBuilder = UriComponentsBuilder
                .fromUriString(geoNamesProperties.getSearchUrl());
        if (!StringUtils.isEmpty(name)) {
            uriComponentBuilder.queryParam("name", name);
        }
        if (maxRows > 0) {
            uriComponentBuilder.queryParam("maxRows", Integer.toString(maxRows));
        }
        if (startRow > 0) {
            uriComponentBuilder.queryParam("startRow", Integer.toString(startRow));
        }
        uriComponentBuilder.queryParam("userName", geoNamesProperties.getUserName());
        uriComponentBuilder.queryParam("type", "json");

        URI uri = uriComponentBuilder.build().toUri();
        logger.debug(String.format("URI = %s", uri.toString()));
        return uri;
    }
}

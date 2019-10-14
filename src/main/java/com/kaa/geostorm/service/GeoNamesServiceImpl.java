package com.kaa.geostorm.service;

import com.kaa.geostorm.domain.GeoName;
import com.kaa.geostorm.domain.GeoNames;
import com.kaa.geostorm.dto.GeoNameDto;
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

    private Mapper<GeoName, GeoNameDto> mapper;

    @Override
    public List<GeoNameDto> find(String name) {
        List<GeoNameDto> geonames = mapper.map(
                restTemplate.exchange(//todo add catch clause
                        buildUri(name),
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<GeoNames>() {
                        })
                        .getBody().getGeonames()
        );
        logger.debug(String.format("For name = %s were founded %d geonames", name, geonames.size()));
        return geonames;
    }

    private URI buildUri(String name) {
        UriComponentsBuilder uriComponentBuilder = UriComponentsBuilder
                .fromUriString(geoNamesProperties.getSearchUrl());
        if (!StringUtils.isEmpty(name)) {
            uriComponentBuilder.queryParam("name", name);
        }
        uriComponentBuilder.queryParam("userName", geoNamesProperties.getUserName());
        uriComponentBuilder.queryParam("type", "json");

        URI uri = uriComponentBuilder.build().toUri();
        logger.debug(String.format("URI = %s", uri.toString()));
        return uri;
    }
}

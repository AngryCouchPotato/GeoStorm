package com.kaa.geostorm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GeoNameDto {
    private int geonameId;
    private String name;
    private String toponymName;
    private long countryId;
    private String countryCode;
    private String countryName;
    private long population;
    private String fcodeName;
    private String adminName1;
    private double lng;
    private double lat;
}
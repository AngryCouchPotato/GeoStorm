package com.kaa.geostorm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CityDto {
    private int geonameId;
    private String toponymName;
    private String name;
    private long countryId;
    private String countryCode;
    private String countryName;
    private long population;
    private String fcodeName;
    private String adminName1;
}
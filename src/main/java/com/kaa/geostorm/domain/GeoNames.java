package com.kaa.geostorm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class GeoNames implements Serializable {
    private int totalResultsCount;
    private List<GeoName> geonames;
}

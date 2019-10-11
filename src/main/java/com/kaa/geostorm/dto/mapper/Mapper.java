package com.kaa.geostorm.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<T, R> {

    R map(T value);

    default List<R> map(List<T> values) {
        return values
                .stream()
                .map((r) -> map(r))
                .collect(Collectors.toList());
    }


}

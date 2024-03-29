package com.msprices.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Brand {
    private Long brandId;

    private String name;
}

package com.msprices.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class PriceDto {
    private Long productId;
    private Long brandId;
    private Long fee;
    private String dateApp;
    private BigDecimal price;
}

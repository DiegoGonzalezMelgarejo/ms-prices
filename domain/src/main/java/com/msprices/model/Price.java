package com.msprices.model;

import com.msprices.util.Currency;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Builder
public class Price {

    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Brand brand;

    private Long priceList;

    private Long productId;

    private Integer priority;

    private BigDecimal value;

    private Currency curr;
}

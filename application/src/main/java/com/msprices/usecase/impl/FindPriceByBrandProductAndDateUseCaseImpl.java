package com.msprices.usecase.impl;


import com.msprices.model.Price;
import com.msprices.model.dto.PriceDto;
import com.msprices.port.PricesPersistencePort;
import com.msprices.usecase.FindPriceByBrandProductAndDateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Component
public class FindPriceByBrandProductAndDateUseCaseImpl implements FindPriceByBrandProductAndDateUseCase {
    private PricesPersistencePort pricePersistencePort;
    @Override
    public PriceDto findPriceByBrandProductAndDate(Long brandId, Long productId, LocalDateTime productDate) {
        return Optional.of(pricePersistencePort.findByBrandProductAndDate(brandId,productId,productDate))
                .map(price -> buildPriceDto(price,productDate))
                .orElseThrow();
    }
    private PriceDto buildPriceDto(Price price, LocalDateTime productDate){
        return PriceDto.builder()
                .brandId(price.getBrand().getBrandId())
                .dateApp(productDate.toString())
                .fee(price.getPriceList())
                .productId(price.getId())
                .price(price.getPrice())
                .build();
    }
}

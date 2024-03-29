package com.msprices.adapter.out.persistence;


import com.msprices.adapter.out.persistence.entity.BrandEntity;
import com.msprices.adapter.out.persistence.entity.PriceEntity;
import com.msprices.adapter.out.persistence.repository.PriceRepository;
import com.msprices.exception.PricesNotAvailableException;
import com.msprices.model.Brand;
import com.msprices.model.Price;
import com.msprices.port.PricesPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class PriceJpaAdapter implements PricesPersistencePort {

    private final PriceRepository priceRepository;
    private static final String PRICES_AVAILABLE_ON_THAT_DATE ="No prices available on that date";
    @Override
    public Price findByBrandProductAndDate(Long brandId, Long productId, LocalDateTime productDate) {
        return priceRepository.findByBrandProductAndDate(brandId,productId,productDate)
                .map(this::buildPrice)
                .orElseThrow(() ->new PricesNotAvailableException(PRICES_AVAILABLE_ON_THAT_DATE));

    }

    private Price buildPrice(PriceEntity priceEntity){
        return Price.builder()
                .id(priceEntity.getId())
                .price(priceEntity.getPrice())
                .priceList(priceEntity.getPriceList())
                .curr(priceEntity.getCurr())
                .endDate(priceEntity.getEndDate())
                .startDate(priceEntity.getStartDate())
                .productId(priceEntity.getProductId())
                .priority(priceEntity.getPriority())
                .brand(buildBrand(priceEntity.getBrand()))
                .build();
    }
    private Brand buildBrand(BrandEntity brandEntity){
        return Brand.builder()
                .name(brandEntity.getName())
                .brandId(brandEntity.getBrandId())
                .build();
    }
}

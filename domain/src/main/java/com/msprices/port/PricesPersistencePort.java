package com.msprices.port;


import com.msprices.model.Price;
import java.time.LocalDateTime;


public interface PricesPersistencePort {
    Price findByBrandProductAndDate(Long brandId, Long productId, LocalDateTime productDate);
}

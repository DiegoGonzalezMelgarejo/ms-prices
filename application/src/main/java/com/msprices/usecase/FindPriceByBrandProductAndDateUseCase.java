package com.msprices.usecase;



import com.msprices.model.dto.PriceDto;

import java.time.LocalDateTime;

public interface FindPriceByBrandProductAndDateUseCase {
    PriceDto findPriceByBrandProductAndDate(Long brandId, Long productId, LocalDateTime productDate);
}

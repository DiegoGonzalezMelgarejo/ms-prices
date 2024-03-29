package com.msprices.service;


import com.msprices.model.dto.PriceDto;
import com.msprices.model.dto.request.GetPriceByDateRequest;
import com.msprices.usecase.FindPriceByBrandProductAndDateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PriceManagementService {

    private FindPriceByBrandProductAndDateUseCase findPriceByBrandProductAndDateUseCase;

    public PriceDto findPriceByBrandProductAndDate(GetPriceByDateRequest request) {
        return findPriceByBrandProductAndDateUseCase.findPriceByBrandProductAndDate(request.getIdBrand(), request.getIdProduct(),
                request.getDate());
    }
}

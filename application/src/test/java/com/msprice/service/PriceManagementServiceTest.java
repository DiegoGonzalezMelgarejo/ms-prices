package com.msprice.service;


import com.msprices.model.dto.PriceDto;
import com.msprices.model.dto.request.GetPriceByDateRequest;

import com.msprices.service.PriceManagementService;
import com.msprices.usecase.FindPriceByBrandProductAndDateUseCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.msprices.util.Currency.EUR;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PriceManagementServiceTest {

    private PriceManagementService priceManagementService;
    private FindPriceByBrandProductAndDateUseCase findPriceByBrandProductAndDateUseCase;

    @BeforeEach
    public void initEach() {
        findPriceByBrandProductAndDateUseCase = mock(FindPriceByBrandProductAndDateUseCase.class);
        priceManagementService = new PriceManagementService(findPriceByBrandProductAndDateUseCase);
    }

    @Test
    void shouldBeOk() throws ParseException {
        when(findPriceByBrandProductAndDateUseCase.findPriceByBrandProductAndDate(any(), any(), any())).thenReturn(buildPriceDto());
        PriceDto price = priceManagementService.findPriceByBrandProductAndDate(getPriceByDateRequest());
        Assertions.assertNotNull(price);
        Assertions.assertEquals(new BigDecimal("35.50"), price.getPrice());
    }
    private PriceDto buildPriceDto() throws ParseException {
        return PriceDto.builder()
                .price(new BigDecimal("35.50"))
                .productId(35455L)
                .brandId(1L)
                .build();
    }
    private GetPriceByDateRequest getPriceByDateRequest(){
        return GetPriceByDateRequest.builder()
                .idBrand(1L)
                .idProduct(35455L)
                .date(LocalDateTime.parse("2020-06-14-16.00.00", DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")))
                .build();
    }
}

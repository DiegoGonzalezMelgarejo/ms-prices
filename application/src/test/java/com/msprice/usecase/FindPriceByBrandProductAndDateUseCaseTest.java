package com.msprice.usecase;

import com.msprices.model.Brand;
import com.msprices.model.Price;
import com.msprices.model.dto.PriceDto;
import com.msprices.port.PricesPersistencePort;
import com.msprices.usecase.impl.FindPriceByBrandProductAndDateUseCaseImpl;
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

class FindPriceByBrandProductAndDateUseCaseTest {
    private PricesPersistencePort pricesPersistencePort;

    private FindPriceByBrandProductAndDateUseCaseImpl findPriceUseCase;
    @BeforeEach
    public void initEach() {
        pricesPersistencePort = mock(PricesPersistencePort.class);
        findPriceUseCase = new FindPriceByBrandProductAndDateUseCaseImpl(pricesPersistencePort);
    }
    @Test
    void shouldOk() throws ParseException {
        when(pricesPersistencePort.findByBrandProductAndDate(any(), any(), any())).thenReturn(buildPriceDomain());
        PriceDto price = findPriceUseCase.findPriceByBrandProductAndDate(1L, 1L, LocalDateTime.now());
        Assertions.assertNotNull(price);
        Assertions.assertEquals(new BigDecimal("35.50"), price.getPrice());
    }

    private  Price buildPriceDomain() throws ParseException {
        return Price.builder().id(1L)
                .curr(EUR)
                .priceList(1L)
                .value(new BigDecimal("35.50"))
                .priority(0)
                .startDate(converterDate("2020-06-14-00.00.00"))
                .productId(35455L)
                .endDate(converterDate("2020-12-31-23.59.59"))
                .brand(Brand.builder().name("ZARA").brandId(1L).build())
                .build();
    }
    private   LocalDateTime converterDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
        return LocalDateTime.parse(date, formatter);
    }

}

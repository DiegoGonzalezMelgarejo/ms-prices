package com.msprices.adapter.out;


import com.msprices.adapter.out.persistence.PriceJpaAdapter;
import com.msprices.adapter.out.persistence.entity.PriceEntity;
import com.msprices.adapter.out.persistence.repository.PriceRepository;
import com.msprices.exception.PricesNotAvailableException;
import com.msprices.util.Utilities;
import com.msprices.model.Price;
import com.msprices.model.dto.request.GetPriceByDateRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PriceRepositoryAdapterTest {
    private PriceRepository priceJPARepository;

    private PriceJpaAdapter priceRepositoryAdapter;
    private static final String PRICES_AVAILABLE_ON_THAT_DATE ="No prices available on that date";
    @BeforeEach
    public void initEach() {
        priceJPARepository = mock(PriceRepository.class);
        priceRepositoryAdapter = new PriceJpaAdapter(priceJPARepository);
    }

    @Test
    void shouldBeOkCase1() throws ParseException {
        GetPriceByDateRequest getPriceByDateRequest = Utilities.getPriceByDateRequest1();
        Optional<PriceEntity> priceEntity = Utilities.simulatedDatabaseQuery(getPriceByDateRequest.getDate(),
                getPriceByDateRequest.getIdProduct(), getPriceByDateRequest.getIdBrand());

        when(priceJPARepository.findByBrandProductAndDate(any(), any(), any())).thenReturn(priceEntity);
        Price price = priceRepositoryAdapter.findByBrandProductAndDate(any(), any(), any());
        Assertions.assertEquals(new BigDecimal("35.50"), price.getValue());

    }
    @Test
    void shouldBeOkCaseException() throws ParseException {

        when(priceJPARepository.findByBrandProductAndDate(any(), any(), any())).thenReturn(Optional.empty());
        try {
            priceRepositoryAdapter.findByBrandProductAndDate(any(), any(), any());

        } catch (PricesNotAvailableException exception) {
            assertEquals(PRICES_AVAILABLE_ON_THAT_DATE, exception.getMessage());
            verify(priceJPARepository, times(1)).findByBrandProductAndDate(any(), any(), any());
        }
    }
    @Test
    void shouldBeOkCase2() throws ParseException {
        GetPriceByDateRequest getPriceByDateRequest = Utilities.getPriceByDateRequest2();
        Optional<PriceEntity> priceEntity = Utilities.simulatedDatabaseQuery(getPriceByDateRequest.getDate(),
                getPriceByDateRequest.getIdProduct(), getPriceByDateRequest.getIdBrand());

        when(priceJPARepository.findByBrandProductAndDate(any(), any(), any())).thenReturn(priceEntity);
        Price price = priceRepositoryAdapter.findByBrandProductAndDate(any(), any(), any());
        Assertions.assertEquals(new BigDecimal("25.45"), price.getValue());

    }
    @Test
    void shouldBeOkCase3() throws ParseException {
        GetPriceByDateRequest getPriceByDateRequest = Utilities.getPriceByDateRequest3();
        Optional<PriceEntity> priceEntity = Utilities.simulatedDatabaseQuery(getPriceByDateRequest.getDate(),
                getPriceByDateRequest.getIdProduct(), getPriceByDateRequest.getIdBrand());

        when(priceJPARepository.findByBrandProductAndDate(any(), any(), any())).thenReturn(priceEntity);
        Price price = priceRepositoryAdapter.findByBrandProductAndDate(any(), any(), any());
        Assertions.assertEquals(new BigDecimal("35.50"), price.getValue());
    }
    @Test
    void shouldBeOkCase4() throws ParseException {
        GetPriceByDateRequest getPriceByDateRequest = Utilities.getPriceByDateRequest4();
        Optional<PriceEntity> priceEntity  = Utilities.simulatedDatabaseQuery(getPriceByDateRequest.getDate(),
                getPriceByDateRequest.getIdProduct(), getPriceByDateRequest.getIdBrand());

        when(priceJPARepository.findByBrandProductAndDate(any(), any(), any())).thenReturn(priceEntity);
        Price price = priceRepositoryAdapter.findByBrandProductAndDate(any(), any(), any());
        Assertions.assertEquals(new BigDecimal("30.50"), price.getValue());

    }
    @Test
    void shouldBeOkCase5() throws ParseException {
        GetPriceByDateRequest getPriceByDateRequest = Utilities.getPriceByDateRequest5();
        Optional<PriceEntity> priceEntity = Utilities.simulatedDatabaseQuery(getPriceByDateRequest.getDate(),
                getPriceByDateRequest.getIdProduct(), getPriceByDateRequest.getIdBrand());
        when(priceJPARepository.findByBrandProductAndDate(any(), any(), any())).thenReturn(priceEntity);
        Price price = priceRepositoryAdapter.findByBrandProductAndDate(any(), any(), any());
        Assertions.assertEquals(new BigDecimal("38.95"), price.getValue());
    }

}

package com.msprices.adapter.in.rest;

import com.msprices.adapter.in.rest.controller.PriceController;
import com.msprices.model.dto.PriceDto;
import com.msprices.model.dto.request.GetPriceByDateRequest;
import com.msprices.service.PriceManagementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.msprices.util.Utilities.getPriceByDateRequest1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PriceControllerTest {
    @Mock
    private PriceManagementService priceManagementService;

    private PriceController priceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        priceController = new PriceController(priceManagementService);
    }

    @Test
    void findPriceByBrandProductAndDate_ValidRequest_ReturnsPriceDto() {

        GetPriceByDateRequest request = getPriceByDateRequest1();

        PriceDto expectedDto = PriceDto.builder().build();

        when(priceManagementService.findPriceByBrandProductAndDate(any())).thenReturn(expectedDto);

        ResponseEntity<PriceDto> response = priceController.findPriceByBrandProductAndDate(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}

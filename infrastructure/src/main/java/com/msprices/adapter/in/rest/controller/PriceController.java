package com.msprices.adapter.in.rest.controller;

import com.msprices.model.dto.PriceDto;
import com.msprices.model.dto.request.GetPriceByDateRequest;
import com.msprices.service.PriceManagementService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/price")
public class PriceController {
    private final PriceManagementService priceManagementService;

    public PriceController(PriceManagementService priceManagementService) {
        this.priceManagementService = priceManagementService;
    }
    @PostMapping(
            path = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceDto> findPriceByBrandProductAndDate(@Valid @RequestBody GetPriceByDateRequest request) {
        return ResponseEntity.ok(priceManagementService.findPriceByBrandProductAndDate(request));
    }
}

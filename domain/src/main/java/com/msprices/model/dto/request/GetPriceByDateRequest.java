package com.msprices.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@Getter
@Setter
public class GetPriceByDateRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    private LocalDateTime date;
    @NotNull(message = "Product id cannot be null")
    @Min(value = 1,message = "must be greater than or equal to 1")
    private Long idProduct;
    @NotNull(message = "Brand id cannot be null")
    @Min(value = 1,message = "must be greater than or equal to 1")
    private Long idBrand;
}

package com.msprices.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class GetPriceByDateRequest {
    @NotNull(message = "Date cannot be null")
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


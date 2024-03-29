package com.msprices.util;

import com.msprices.adapter.out.persistence.entity.BrandEntity;
import com.msprices.adapter.out.persistence.entity.PriceEntity;
import com.msprices.model.Brand;
import com.msprices.model.Price;
import com.msprices.model.dto.request.GetPriceByDateRequest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

import static com.msprices.util.Currency.EUR;

public class Utilities {
    public static Optional<PriceEntity> simulatedDatabaseQuery(LocalDateTime appDate, Long productId, Long brandId) throws ParseException {
        return Stream.of(getPrice1(), getPrice2(), getPrice3(), getPrice4())
                .filter(price -> price.getProductId().equals(productId))
                .filter(price -> price.getBrand().getBrandId().equals(brandId))
                .filter(price -> appDate.isAfter(price.getStartDate()) && appDate.isBefore(price.getEndDate())).min(OrderByPriority());
    }

    public static PriceEntity getPrice1() throws ParseException {
        return PriceEntity.builder().id(1L)
                .curr(EUR)
                .priceList(1L)
                .price(new BigDecimal("35.50"))
                .priority(0)
                .startDate(coverterDate("2020-06-14-00.00.00"))
                .productId(35455L)
                .endDate(coverterDate("2020-12-31-23.59.59"))
                .brand(BrandEntity.builder().brandId(1L).name("ZARA").build())
                .build();
    }
    public static PriceEntity getPrice2() throws ParseException {
        return PriceEntity.builder().id(2L)
                .curr(EUR)
                .priceList(2L)
                .price(new BigDecimal("25.45"))
                .priority(1)
                .endDate(coverterDate("2020-06-14-18.30.00"))
                .productId(35455L)
                .startDate(coverterDate("2020-06-14-15.00.00"))
                .brand(BrandEntity.builder().brandId(1L).name("ZARA").build())
                .build();
    }
    public static PriceEntity getPrice3() throws ParseException {
        return PriceEntity.builder().id(3L)
                .curr(EUR)
                .priceList(3L)
                .price(new BigDecimal("30.50"))
                .priority(1)
                .endDate(coverterDate("2020-06-15-11.00.00"))
                .productId(35455L)
                .startDate(coverterDate("2020-06-15-00.00.00"))
                .brand(BrandEntity.builder().brandId(1L).name("ZARA").build())
                .build();
    }
    public static PriceEntity getPrice4() throws ParseException {
        return PriceEntity.builder().id(4L)
                .curr(EUR)
                .priceList(4L)
                .price(new BigDecimal("38.95"))
                .priority(1)
                .endDate(coverterDate("2020-12-31-23.59.59"))
                .productId(35455L)
                .startDate(coverterDate("2020-06-15-16.00.00"))
                .brand(BrandEntity.builder().brandId(1L).name("ZARA").build())
                .build();
    }

    public static GetPriceByDateRequest getPriceByDateRequest1(){
        return GetPriceByDateRequest.builder()
                .idBrand(1L)
                .idProduct(35455L)
                .date(LocalDateTime.parse("2020-06-14-10.00.00", DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")))
                .build();
    }
    public static Price buildPriceDomain() throws ParseException {
        return Price.builder().id(1L)
                .curr(EUR)
                .priceList(1L)
                .value(new BigDecimal("35.50"))
                .priority(0)
                .startDate(coverterDate("2020-06-14-00.00.00"))
                .productId(35455L)
                .endDate(coverterDate("2020-12-31-23.59.59"))
                .brand(Brand.builder().brandId(1L).name("ZARA").build())
                .build();
    }
    public static GetPriceByDateRequest getPriceByDateRequest2(){
        return GetPriceByDateRequest.builder()
                .idBrand(1L)
                .idProduct(35455L)
                .date(LocalDateTime.parse("2020-06-14-16.00.00",DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")))
                .build();
    }
    public static GetPriceByDateRequest getPriceByDateRequest3(){
        return GetPriceByDateRequest.builder()
                .idBrand(1L)
                .idProduct(35455L)
                .date(LocalDateTime.parse("2020-06-14-21.00.00",DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")))
                .build();
    }
    public static GetPriceByDateRequest getPriceByDateRequest4(){
        return GetPriceByDateRequest.builder()
                .idBrand(1L)
                .idProduct(35455L)
                .date(LocalDateTime.parse("2020-06-15-10.00.00",DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")))
                .build();
    }
    public static GetPriceByDateRequest getPriceByDateRequest5(){
        return GetPriceByDateRequest.builder()
                .idBrand(1L)
                .idProduct(35455L)
                .date(LocalDateTime.parse("2020-06-16-21.00.00",DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss")))
                .build();
    }
    public  static LocalDateTime coverterDate(String date) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

        return LocalDateTime.parse(date, formatter);
    }
    private static Comparator<PriceEntity> OrderByPriority(){
        return Comparator.comparing(PriceEntity::getPriority).reversed();
    }

    public static GetPriceByDateRequest buildGetPriceByDateRequest(){
        return  GetPriceByDateRequest.builder()
                .idProduct(35455L)
                .idBrand(1L)
                .date(formatDate("2020-06-16-21.00.00")).build();
    }
    public static GetPriceByDateRequest buildGetPriceByDateNoContentRequest(){
        return  GetPriceByDateRequest.builder()
                .idProduct(35455L)
                .idBrand(1L)
                .date(LocalDateTime.now()).build();
    }
    private  static LocalDateTime formatDate(String date){
        return LocalDateTime.parse(date,DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));
    }
}

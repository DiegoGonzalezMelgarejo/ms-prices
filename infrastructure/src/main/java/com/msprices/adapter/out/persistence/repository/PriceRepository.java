package com.msprices.adapter.out.persistence.repository;

import com.msprices.adapter.out.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PriceRepository extends CrudRepository<PriceEntity,Long> {


    @Query("SELECT p FROM PriceEntity p " +
            "WHERE  p.brand.brandId = ?1 " +
            "AND p.productId = ?2 " +
            "AND (?3 BETWEEN p.startDate AND p.endDate)" +
            "ORDER BY p.priority DESC LIMIT 1")
    Optional<PriceEntity> findByBrandProductAndDate(Long brandId, Long productId, LocalDateTime appDate);
}

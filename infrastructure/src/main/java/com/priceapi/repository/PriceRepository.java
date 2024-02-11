package com.priceapi.repository;
import com.priceapi.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query("SELECT price FROM Price price WHERE price.productId = :product AND price.brand.id = :brand AND (price.startDate <= :date AND price.endDate >= :date) ORDER BY price.priority DESC LIMIT 1")
    Optional<PriceEntity> findHighestPriorityPriceByProductBrandDate(
            @Param("product") Long product,
            @Param("brand") Long brand,
            @Param("date") String date);

}
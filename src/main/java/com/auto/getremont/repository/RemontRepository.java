package com.auto.getremont.repository;

import com.auto.getremont.entity.RemontEntity;
import com.auto.getremont.model.Remont;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemontRepository extends PagingAndSortingRepository<RemontEntity, Long> {

    @Query(value = "SELECT r.id, r.malfunction, r.car_brand, r.car_model, r.car_year, r.price, r.user_id, u.image " +
            " FROM remont AS r LEFT JOIN user AS u ON r.user_id = u.id", nativeQuery = true)
    Page<RemontEntity> getRemont(Pageable pageable);

    @Query("FROM remont")
    Page<RemontEntity> getRemonts(Pageable pageable);




}

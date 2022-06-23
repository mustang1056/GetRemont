package com.auto.getremont.repository;

import com.auto.getremont.entity.RepairEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends PagingAndSortingRepository<RepairEntity, Long> {

    @Query(value = "SELECT r.id, r.malfunction, r.car_brand, r.car_model, r.car_year, r.price, r.user_id, u.image " +
            " FROM remont AS r LEFT JOIN user AS u ON r.user_id = u.id", nativeQuery = true)
    Page<RepairEntity> getRemont(Pageable pageable);

    @Query("FROM remont")
    Page<RepairEntity> getRemonts(Pageable pageable);




}

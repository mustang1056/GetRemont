package com.auto.getremont.service;

import com.auto.getremont.entity.RepairEntity;
import com.auto.getremont.entity.UserEntity;
import com.auto.getremont.model.Repair;
import com.auto.getremont.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RepairService {

    RepairEntity addRemont(Repair bank);

    void delete(long id);

    Optional<RepairEntity> getById(Long id);

    RepairEntity editRemont(RepairEntity bank);

    Page<Repair> getRemonts(Pageable pageable);

    Repair convertToRemontDto(RepairEntity remont);

    User convertToUserDto(UserEntity user);

    RepairEntity convertToRemontEntity(Repair remont);

}
package com.auto.getremont.service;

import com.auto.getremont.entity.RemontEntity;
import com.auto.getremont.entity.UserEntity;
import com.auto.getremont.model.Remont;
import com.auto.getremont.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface RemontService {

    RemontEntity addRemont(Remont bank);

    void delete(long id);

    Optional<RemontEntity> getById(Long id);

    RemontEntity editRemont(RemontEntity bank);

    Page<Remont> getRemonts(Pageable pageable);

    Remont convertToRemontDto(RemontEntity remont);

    User convertToUserDto(UserEntity user);

    RemontEntity convertToRemontEntity(Remont remont);

}
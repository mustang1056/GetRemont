package com.auto.getremont.repository;


import com.auto.getremont.entity.RemontEntity;
import com.auto.getremont.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {



}

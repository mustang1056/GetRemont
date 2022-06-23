package com.auto.getremont.service;

import com.auto.getremont.entity.RepairEntity;
import com.auto.getremont.entity.UserEntity;
import com.auto.getremont.model.Repair;
import com.auto.getremont.model.User;
import com.auto.getremont.repository.RepairRepository;
import com.auto.getremont.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;


@Component
public class RepairtServiceImpl implements RepairService {

    @Autowired
    private RepairRepository remontRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public RepairEntity addRemont(Repair remont) {

        Long id = remont.getUser_id();
        UserEntity user = userRepository.findById(id).orElse(new UserEntity());
        RepairEntity rem = convertToRemontEntity(remont);
        rem.setUser(user);

        RepairEntity savedRemont = remontRepository.save(rem);

        return savedRemont;
    }

    @Override
    public void delete(long id) {
        remontRepository.deleteById(id);
    }

    @Override
    public Optional<RepairEntity> getById(Long id) {
        return remontRepository.findById(id);
    }

    @Override
    public RepairEntity editRemont(RepairEntity bank) {
        return remontRepository.save(bank);
    }

    @Override
    public Page<Repair> getRemonts(Pageable pageble) {
        Page<RepairEntity> posts = (Page<RepairEntity>) remontRepository.findAll(pageble);
        return posts.map(new Function<RepairEntity, Repair>() {

            @Override
            public Repair apply(RepairEntity t) {
                return new ModelMapper().map(t, Repair.class);
            }

        });
    }



    @Override
    public Repair convertToRemontDto(RepairEntity remont) {
        Repair postDto = modelMapper.map(remont, Repair.class);
        postDto.setCar_model(remont.getCar_model());
        postDto.setUser_id(remont.getUserId());
        return postDto;
    }

    private Repair convertToObjectDto(Object o) {
        Repair dto = new Repair();
        //conversion here
        return dto;
    }

    /*
    public Page<Remont> toPageObjectDto(Page<Remont> objects) {
        Page<Remont> dtos  = MapperUtil.convertList(objects, this::convertToRemontDto);
        return dtos;
    }*/

    @Override
    public User convertToUserDto(UserEntity user) {
        return modelMapper.map(user, User.class);
    }

    @Override
    public RepairEntity convertToRemontEntity(Repair remont) {
        return modelMapper.map(remont, RepairEntity.class);
    }


}

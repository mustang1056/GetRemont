package com.auto.getremont.service;

import com.auto.getremont.config.MapperUtil;
import com.auto.getremont.entity.RemontEntity;
import com.auto.getremont.entity.UserEntity;
import com.auto.getremont.model.Remont;
import com.auto.getremont.model.User;
import com.auto.getremont.repository.RemontRepository;
import com.auto.getremont.repository.UserRepository;
import net.bytebuddy.description.method.MethodDescription;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import org.springframework.data.domain.Sort;


@Component
public class RemontServiceImpl implements RemontService {

    @Autowired
    private RemontRepository remontRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public RemontEntity addRemont(Remont bank) {

        Long id = bank.getUser_id();
        UserEntity user = userRepository.findById(id).orElse(new UserEntity());
        RemontEntity rem = convertToRemontEntity(bank);
        rem.setUser(user);

        RemontEntity savedRemont = remontRepository.save(rem);

        return savedRemont;
    }

    @Override
    public void delete(long id) {
        remontRepository.deleteById(id);
    }

    @Override
    public Optional<RemontEntity> getById(Long id) {
        return remontRepository.findById(id);
    }

    @Override
    public RemontEntity editRemont(RemontEntity bank) {
        return remontRepository.save(bank);
    }

    @Override
    public Page<Remont> getRemonts(Pageable pageble) {
        Page<RemontEntity> posts = (Page<RemontEntity>) remontRepository.findAll(pageble);
        return posts.map(new Function<RemontEntity, Remont>() {

            @Override
            public Remont apply(RemontEntity t) {
                return new ModelMapper().map(t, Remont.class);
            }

        });
    }



    @Override
    public Remont convertToRemontDto(RemontEntity remont) {
        Remont postDto = modelMapper.map(remont, Remont.class);
        postDto.setCar_model(remont.getCar_model());
        postDto.setUser_id(remont.getUserId());
        return postDto;
    }

    private Remont convertToObjectDto(Object o) {
        Remont dto = new Remont();
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
    public RemontEntity convertToRemontEntity(Remont remont) {
        return modelMapper.map(remont, RemontEntity.class);
    }


}

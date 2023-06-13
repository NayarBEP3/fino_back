package com.tiamat.fino.services;

import com.tiamat.fino.dtos.users.AddUserDto;
import com.tiamat.fino.dtos.users.UserDto;
import com.tiamat.fino.entities.UserEntity;
import com.tiamat.fino.repositories.UserRepository;
import com.tiamat.fino.utils.ValidationUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    public UserService(@Autowired UserRepository repository) {
        this.repository = repository;
    }

    public UserDto createUser(AddUserDto addUserDto) {
        addUserDto.validate();
        UserEntity userEntity = mapper.map(addUserDto, UserEntity.class);
        userEntity = repository.save(userEntity);
        return mapper.map(userEntity, UserDto.class);
    }

    public UserDto getUser(String id) {
        Optional<UserEntity> userEntityOptional = repository.findById(id);
        ValidationUtils.getValueFromOptional(userEntityOptional, "Error: User not found");
        return mapper.map(userEntityOptional.get(), UserDto.class);
    }

}
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
        return mapper.map(getUserEntity(id), UserDto.class);
    }

    public UserDto updateUser(AddUserDto addUserDto, String id) {
        UserEntity userEntityFound = getUserEntity(id);
        UserEntity userEntity = mapper.map(addUserDto, UserEntity.class);
        userEntity.setId(id);
        userEntity.setPass(userEntityFound.getPass());
        userEntity = repository.save(userEntity);
        return mapper.map(userEntity, UserDto.class);
    }

    private UserEntity getUserEntity(String id) {
        Optional<UserEntity> userEntityOptional = repository.findById(id);
        ValidationUtils.validateMandatory(userEntityOptional, "Error: User not found");
        return userEntityOptional.get();
    }

}

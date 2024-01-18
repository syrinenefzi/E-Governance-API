package Egovernance.Egovernance.service;

import Egovernance.Egovernance.entity.PersonEntity;
import Egovernance.Egovernance.model.UserDto;
import Egovernance.Egovernance.entity.UserEntity;
import Egovernance.Egovernance.mapper.UserMapper;
import Egovernance.Egovernance.model.UserDto;
import Egovernance.Egovernance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service

public class UserManager {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    public List<UserDto> getAll() {
        return userMapper.entityToModel(userRepository.findAll());
    }
    public UserDto getUser(int userID){
        UserDto userResult = userMapper.entityToModel(userRepository.findUserByUserId(userID));
        if (userResult == null){
            throw new NoSuchElementException(String.format("The id %d is not found", userID));
        }
        return userResult;
    }
    public List<UserDto> addUsers (List<UserDto> users){
        return userMapper.entityToModel(userRepository.saveAll(userMapper.modelToEntity(users)));
    }
    public UserDto addUser(UserDto user){
        UserEntity userToBeSaved = userMapper.modelToEntity(user);
        UserEntity save= userRepository.save(userToBeSaved);
        System.out.println(String.format("The user %s is added successfully",userToBeSaved));
        return userMapper.entityToModel(save);
    }

    public boolean removeUser(Integer idUserToBeRemoved){
        UserEntity userResult = userRepository.findUserByUserId(idUserToBeRemoved);
        if (userResult == null){
            throw new NoSuchElementException(String.format("The id %d is not found", idUserToBeRemoved ));
        }
        userRepository.deleteById(idUserToBeRemoved);
        return true;
    }

    public UserDto getUserById(int userId) {

        return userMapper.entityToModel(userRepository.findUserByUserId(userId));
    }
}


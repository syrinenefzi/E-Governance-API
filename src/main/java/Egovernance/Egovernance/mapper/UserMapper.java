package Egovernance.Egovernance.mapper;

import Egovernance.Egovernance.model.UserDto;
import Egovernance.Egovernance.entity.UserEntity;
import Egovernance.Egovernance.model.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserEntity modelToEntity(UserDto u);
    UserDto entityToModel(UserEntity e);
    List<UserDto> entityToModel(List<UserEntity> e);

    List<UserEntity> modelToEntity (List<UserDto> a);
}

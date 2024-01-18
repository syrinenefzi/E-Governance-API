package Egovernance.Egovernance.mapper;

import Egovernance.Egovernance.entity.UserEntity;
import Egovernance.Egovernance.model.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-17T21:52:02+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity modelToEntity(UserDto u) {
        if ( u == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId( u.getUserId() );
        userEntity.setUserName( u.getUserName() );
        userEntity.setPassword( u.getPassword() );
        userEntity.setRole( u.getRole() );
        userEntity.setLoggedIn( u.getLoggedIn() );

        return userEntity;
    }

    @Override
    public UserDto entityToModel(UserEntity e) {
        if ( e == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        if ( e.getUserId() != null ) {
            userDto.setUserId( e.getUserId() );
        }
        userDto.setUserName( e.getUserName() );
        userDto.setPassword( e.getPassword() );
        userDto.setRole( e.getRole() );
        userDto.setLoggedIn( e.getLoggedIn() );

        return userDto;
    }

    @Override
    public List<UserDto> entityToModel(List<UserEntity> e) {
        if ( e == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( e.size() );
        for ( UserEntity userEntity : e ) {
            list.add( entityToModel( userEntity ) );
        }

        return list;
    }

    @Override
    public List<UserEntity> modelToEntity(List<UserDto> a) {
        if ( a == null ) {
            return null;
        }

        List<UserEntity> list = new ArrayList<UserEntity>( a.size() );
        for ( UserDto userDto : a ) {
            list.add( modelToEntity( userDto ) );
        }

        return list;
    }
}

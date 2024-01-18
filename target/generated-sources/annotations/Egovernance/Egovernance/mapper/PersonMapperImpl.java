package Egovernance.Egovernance.mapper;

import Egovernance.Egovernance.entity.PersonEntity;
import Egovernance.Egovernance.model.PersonDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-17T21:52:03+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public PersonEntity modelToEntity(PersonDto p) {
        if ( p == null ) {
            return null;
        }

        PersonEntity personEntity = new PersonEntity();

        personEntity.setId( p.getId() );
        personEntity.setFullName( p.getFullName() );
        personEntity.setDateOfBirth( p.getDateOfBirth() );
        personEntity.setPlaceOfBirth( cityMapper.modelToEntity( p.getPlaceOfBirth() ) );
        personEntity.setSex( p.getSex() );
        personEntity.setFather( p.getFather() );
        personEntity.setMother( p.getMother() );
        personEntity.setOtherInfo( p.getOtherInfo() );

        return personEntity;
    }

    @Override
    public PersonDto entityToModel(PersonEntity e) {
        if ( e == null ) {
            return null;
        }

        PersonDto personDto = new PersonDto();

        personDto.setId( e.getId() );
        personDto.setFullName( e.getFullName() );
        personDto.setDateOfBirth( e.getDateOfBirth() );
        personDto.setPlaceOfBirth( cityMapper.entityToModel( e.getPlaceOfBirth() ) );
        personDto.setSex( e.getSex() );
        personDto.setFather( e.getFather() );
        personDto.setMother( e.getMother() );
        personDto.setOtherInfo( e.getOtherInfo() );

        return personDto;
    }

    @Override
    public List<PersonDto> entityToModel(List<PersonEntity> e) {
        if ( e == null ) {
            return null;
        }

        List<PersonDto> list = new ArrayList<PersonDto>( e.size() );
        for ( PersonEntity personEntity : e ) {
            list.add( entityToModel( personEntity ) );
        }

        return list;
    }

    @Override
    public List<PersonEntity> modelToEntity(List<PersonDto> e) {
        if ( e == null ) {
            return null;
        }

        List<PersonEntity> list = new ArrayList<PersonEntity>( e.size() );
        for ( PersonDto personDto : e ) {
            list.add( modelToEntity( personDto ) );
        }

        return list;
    }
}

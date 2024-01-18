package Egovernance.Egovernance.mapper;


import Egovernance.Egovernance.entity.PersonEntity;
import Egovernance.Egovernance.model.PersonDto;
import org.mapstruct.Mapper;

import java.util.List;

    @Mapper(uses={CityMapper.class})
    public interface PersonMapper {

        PersonEntity modelToEntity(PersonDto p);
        PersonDto entityToModel(PersonEntity e);
        List<PersonDto> entityToModel(List<PersonEntity> e);
        List<PersonEntity> modelToEntity (List<PersonDto> e);

    }

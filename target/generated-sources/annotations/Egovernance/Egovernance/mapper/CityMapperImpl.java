package Egovernance.Egovernance.mapper;

import Egovernance.Egovernance.entity.CityEntity;
import Egovernance.Egovernance.model.CityDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-17T21:52:03+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CityMapperImpl implements CityMapper {

    @Override
    public CityEntity modelToEntity(CityDto city) {
        if ( city == null ) {
            return null;
        }

        CityEntity cityEntity = new CityEntity();

        cityEntity.setId( city.getId() );
        cityEntity.setCityName( city.getCityName() );

        return cityEntity;
    }

    @Override
    public CityDto entityToModel(CityEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CityDto cityDto = new CityDto();

        cityDto.setId( entity.getId() );
        cityDto.setCityName( entity.getCityName() );

        return cityDto;
    }

    @Override
    public List<CityDto> entityToModel(List<CityEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<CityDto> list = new ArrayList<CityDto>( entities.size() );
        for ( CityEntity cityEntity : entities ) {
            list.add( entityToModel( cityEntity ) );
        }

        return list;
    }

    @Override
    public List<CityEntity> modelToEntity(List<CityDto> cities) {
        if ( cities == null ) {
            return null;
        }

        List<CityEntity> list = new ArrayList<CityEntity>( cities.size() );
        for ( CityDto cityDto : cities ) {
            list.add( modelToEntity( cityDto ) );
        }

        return list;
    }
}

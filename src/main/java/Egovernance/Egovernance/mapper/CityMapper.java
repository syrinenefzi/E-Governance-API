package Egovernance.Egovernance.mapper;

import Egovernance.Egovernance.model.CityDto;
import Egovernance.Egovernance.entity.CityEntity;
import Egovernance.Egovernance.model.CityDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CityMapper {
    CityEntity modelToEntity(CityDto city);
    CityDto entityToModel(CityEntity entity);
    List<CityDto> entityToModel(List<CityEntity> entities);
    List<CityEntity> modelToEntity (List<CityDto> cities);
}

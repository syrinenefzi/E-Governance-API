package Egovernance.Egovernance.service;

import Egovernance.Egovernance.model.CityDto;
import Egovernance.Egovernance.entity.CityEntity;
import Egovernance.Egovernance.mapper.CityMapper;
import Egovernance.Egovernance.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class CityManager {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CityMapper cityMapper;

    public List<CityDto> getAll() {
        return cityMapper.entityToModel(cityRepository.findAll());
    }
    public CityDto getCity(int id){
        CityDto cityResult = cityMapper.entityToModel(cityRepository.findCityById(id));
        if (cityResult == null){
            throw new NoSuchElementException(String.format("The id %d is not found", id));
        }
        return cityResult;
    }
    public List<CityDto> addCities (List<CityDto> cities){
        return cityMapper.entityToModel(cityRepository.saveAll(cityMapper.modelToEntity(cities)));
    }
    public CityDto addCity(CityDto city){
        CityEntity cityToBeSaved = cityMapper.modelToEntity(city);
        CityEntity save= cityRepository.save(cityToBeSaved);
        System.out.println(String.format("The city %s is added successfully",cityToBeSaved));
        return cityMapper.entityToModel(save);
    }

    public boolean removeCity(int idCityToBeRemoved){
        cityRepository.deleteById(idCityToBeRemoved);
        return true;
    }

    public CityDto getCityById(int id) {

        return cityMapper.entityToModel(cityRepository.findCityById(id));
    }

}

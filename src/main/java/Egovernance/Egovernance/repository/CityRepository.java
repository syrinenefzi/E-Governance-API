package Egovernance.Egovernance.repository;

import Egovernance.Egovernance.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityEntity, Integer > {
    public CityEntity findCityById(Integer id);

}

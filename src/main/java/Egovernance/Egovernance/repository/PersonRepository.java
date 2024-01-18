package Egovernance.Egovernance.repository;

import Egovernance.Egovernance.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <PersonEntity, Integer > {
        public PersonEntity findPersonById(Integer id);
    }


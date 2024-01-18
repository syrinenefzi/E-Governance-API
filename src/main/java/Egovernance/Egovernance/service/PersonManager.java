package Egovernance.Egovernance.service;


import Egovernance.Egovernance.entity.PersonEntity;
import Egovernance.Egovernance.mapper.PersonMapper;
import Egovernance.Egovernance.model.PersonDto;
import Egovernance.Egovernance.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonManager {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;


    public List<PersonDto> getAll() {
        return personMapper.entityToModel(personRepository.findAll());
    }

    public PersonDto getPerson(int id ) {
        PersonEntity personResult = personRepository.findPersonById( id );
        if (personResult == null){
            throw new NoSuchElementException(String.format("The id %d is not found", id ));
        }
        return personMapper.entityToModel(personResult);
    }

    public PersonDto addPerson(PersonDto person){
        PersonEntity personToBeSaved = personMapper.modelToEntity(person);
        PersonEntity save = personRepository.save(personToBeSaved);
        System.out.println(String.format("The person %s is added successfully",personToBeSaved));
        return personMapper.entityToModel(save);
    }

    public List<PersonDto> addPersons (List<PersonDto> persons){
        return personMapper.entityToModel(personRepository.saveAll(personMapper.modelToEntity(persons)));
    }

    public boolean removePerson (int idPersonToBeRemoved){
        personRepository.deleteById(idPersonToBeRemoved);
        return true;
    }

}

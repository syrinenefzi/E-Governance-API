package Egovernance.Egovernance.controller;


import Egovernance.Egovernance.model.PersonDto;
import Egovernance.Egovernance.service.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/persons")
@Controller
public class PersonController {
    @Autowired
    private PersonManager personManager;
    @GetMapping("/")
    public @ResponseBody List<PersonDto> getPersons(){
        return personManager.getAll();
    }
    @PostMapping("/list")
    public @ResponseBody List<PersonDto> addPersons(@RequestBody List<PersonDto> newTransaction){
        return personManager.addPersons(newTransaction);
    }
    @PostMapping("/")
    public @ResponseBody PersonDto addPerson (@RequestBody PersonDto newPerson){
        return personManager.addPerson(newPerson);
    }

    @DeleteMapping("/")
    public @ResponseBody boolean deletePerson (int idPersonToBeDeleted){
        return personManager.removePerson(idPersonToBeDeleted);
    }
}

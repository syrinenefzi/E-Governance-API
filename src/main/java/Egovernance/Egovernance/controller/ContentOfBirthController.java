package Egovernance.Egovernance.controller;

import Egovernance.Egovernance.entity.PersonEntity;
import Egovernance.Egovernance.model.ContentOfBirthObject;
import Egovernance.Egovernance.service.ContentOfBirthManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/generator")
@Controller
public class ContentOfBirthController {
    @Autowired
    private ContentOfBirthManager contentOfBirthManager;
    private ContentOfBirthObject contentOfBirthObject;



    @GetMapping("/ContentOfBirth/{personId}")
    public @ResponseBody List<PersonEntity> ContentOfBirthByPerson(@PathVariable int personId) {
        return contentOfBirthManager.generateContentOfBirthByPersonId ( personId) ;
    }
    @GetMapping("/DownloadContentOfBirth/{id}")
    public @ResponseBody void DownloadContentOfBirth (@PathVariable int id){
        contentOfBirthManager.generateContentOfBirthById(id);
    }

}



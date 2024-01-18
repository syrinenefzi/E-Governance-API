package Egovernance.Egovernance.controller;

import Egovernance.Egovernance.model.CityDto;
import Egovernance.Egovernance.service.CityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cities")
@Controller
public class CityController {
    @Autowired
    private CityManager cityManager;
    private CityDto city ;

    @GetMapping("/")
    public @ResponseBody List<CityDto> getCity() {
        return cityManager.getAll();
    }

    @PostMapping("/list")
    public @ResponseBody List<CityDto> addCities(@RequestBody List<CityDto> newCities){
        return cityManager.addCities(newCities);
    }

    @PostMapping("/")
    public @ResponseBody CityDto addCity(@RequestBody CityDto newCity){
        return cityManager.addCity(newCity);
    }

    @DeleteMapping("/")
    public @ResponseBody boolean deleteCity(int idCityToBeDeleted){
        return cityManager.removeCity(idCityToBeDeleted);
    }

    @GetMapping("/{id}")
    public @ResponseBody CityDto getCityNameById(@PathVariable int id) {
        return cityManager.getCityById(id);
    }

}

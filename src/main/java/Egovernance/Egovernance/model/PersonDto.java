package Egovernance.Egovernance.model;

import Egovernance.Egovernance.model.CityDto;
import lombok.Data;

import java.time.LocalDate;
@Data
public class PersonDto {

        private Integer id;
        private String fullName;
        private LocalDate dateOfBirth;
        private CityDto placeOfBirth;
        private Gender sex;
        private String father;
        private String mother;
        private String otherInfo;
}

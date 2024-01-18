package Egovernance.Egovernance.model;

import Egovernance.Egovernance.entity.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ContentOfBirthGenerator {
    private List<PersonEntity> persons;
}

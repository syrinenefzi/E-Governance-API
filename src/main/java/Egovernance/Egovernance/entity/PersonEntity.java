package Egovernance.Egovernance.entity;

import Egovernance.Egovernance.model.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class PersonEntity {
    @Id
    private Integer id;
    private String fullName;
    private LocalDate dateOfBirth;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id_placeOfBirth")
    private CityEntity placeOfBirth;
    private Gender sex;
    private String father;
    private String mother;
    private String otherInfo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id_address")
    private CityEntity cityOfResidence;




}
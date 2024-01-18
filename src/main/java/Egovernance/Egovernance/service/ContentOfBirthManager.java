package Egovernance.Egovernance.service;

import Egovernance.Egovernance.entity.CityEntity;
import Egovernance.Egovernance.entity.PersonEntity;
import Egovernance.Egovernance.mapper.CityMapper;
import Egovernance.Egovernance.mapper.PersonMapper;
import Egovernance.Egovernance.repository.CityRepository;
import Egovernance.Egovernance.repository.PersonRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContentOfBirthManager {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private EntityManager entityManager;


    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private CityMapper cityMapper;


    public List<PersonEntity> generateContentOfBirthByPersonId(int id) {
        List<PersonEntity> persons = personRepository.findAll();
        System.out.println("Content Of Birth for Person ID: " + id);
        return persons.stream().filter(tr -> tr.getId() == id).collect(Collectors.toList());

    }


        public void generateContentOfBirthById(int id) {
            List<PersonEntity> persons = personRepository.findAll();

            // Filter the person by ID
            List<PersonEntity> filteredPersons = persons.stream()
                    .filter(person -> person.getId() == id)
                    .collect(Collectors.toList());

            // Generate PDF
            generatePdf(filteredPersons);
        }


    public void generatePdf(List<PersonEntity> persons) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:/Users/hp/Desktop/Contentofbirth/BirthCertificate.pdf"));
            document.open();

            for (PersonEntity person : persons) {
                document.add(new Paragraph("___________Content Of Birth for Person ID: " + person.getId() + " at Date = " + LocalDate.now() + "___________"));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("__________________________________________________________________"));
                document.add(new Paragraph("Name: " + person.getFullName()));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("__________________________________________________________________"));
                document.add(new Paragraph("Date of Birth: " + person.getDateOfBirth()));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("__________________________________________________________________"));
                document.add(new Paragraph("Place of Birth: " + cityRepository.findCityById(person.getPlaceOfBirth().getId()).getCityName()));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("__________________________________________________________________"));
                document.add(new Paragraph("Gender: " + person.getSex()));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("__________________________________________________________________"));
                document.add(new Paragraph("Father's Name: " + person.getFather()));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("__________________________________________________________________"));
                document.add(new Paragraph("Mother's Name: " + person.getMother()));
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("__________________________________________________________________"));
                document.add(new Paragraph("Other Info: " + person.getOtherInfo()));
                document.add(new Paragraph("\n"));
            }

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }





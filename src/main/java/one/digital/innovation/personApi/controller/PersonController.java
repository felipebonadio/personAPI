package one.digital.innovation.personApi.controller;

import one.digital.innovation.personApi.entity.Person;
import one.digital.innovation.personApi.dto.response.MessageResponseDTO;
import one.digital.innovation.personApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/people")
public class PersonController { //local de entrada para as coisas

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){ //parametro Person
    return personService.createPerson(person);
    }
}

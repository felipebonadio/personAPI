package one.digital.innovation.personApi.controller;

import one.digital.innovation.personApi.dto.request.PersonDTO;
import one.digital.innovation.personApi.dto.response.MessageResponseDTO;
import one.digital.innovation.personApi.exception.PersonNotFoundException;
import one.digital.innovation.personApi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/people")
public class PersonController { //local de entrada para as coisas

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping //criação de objetos
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){ //parametro Person
    return personService.createPerson(personDTO);
    }

    @GetMapping //lista todos
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}") //lista por id
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @PutMapping("{/id}") //atualiza o objeto
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByID(@PathVariable Long id) throws PersonNotFoundException {
        personService.deleteById(id);
    }
}

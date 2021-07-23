package one.digital.innovation.personApi.service;

import one.digital.innovation.personApi.dto.request.PersonDTO;
import one.digital.innovation.personApi.dto.response.MessageResponseDTO;
import one.digital.innovation.personApi.entity.Person;
import one.digital.innovation.personApi.exception.PersonNotFoundException;
import one.digital.innovation.personApi.mapper.PersonMapper;
import one.digital.innovation.personApi.repository.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service // gerenciador classe do tipo serviço, transações
public class PersonService {
    public PersonRespository personRespository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRespository personRespository) {
        this.personRespository = personRespository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO){ //parametro Person
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRespository.save(personToSave); // salva a pessoa
        return createMessageResponse(savedPerson.getId(), "Created person with id ");

    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRespository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        return personMapper.toDTO(person);
    }

    public void deleteById(Long id) throws PersonNotFoundException {
       verifyIfExists(id);
       personRespository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRespository.save(personToUpdate); // salva a pessoa
        return createMessageResponse(updatedPerson.getId(), "Updated person with id ");
    }

    private Person verifyIfExists (Long id) throws PersonNotFoundException {
        return personRespository.findById(id).
                orElseThrow(()->new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}

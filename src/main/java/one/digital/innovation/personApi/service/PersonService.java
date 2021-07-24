package one.digital.innovation.personApi.service;

import lombok.AllArgsConstructor;
import one.digital.innovation.personApi.dto.request.PersonDTO;
import one.digital.innovation.personApi.dto.response.MessageResponseDTO;
import one.digital.innovation.personApi.entity.Person;
import one.digital.innovation.personApi.exception.PersonNotFoundException;
import one.digital.innovation.personApi.mapper.PersonMapper;
import one.digital.innovation.personApi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(onConstructor = @__(@Autowired)) // faz os autowireds automaticamente
@Service // gerenciador classe do tipo serviço, transações
public class PersonService {
    public PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;



    public MessageResponseDTO createPerson(PersonDTO personDTO){ //parametro Person
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave); // salva a pessoa
        return createMessageResponse(savedPerson.getId(), "Created person with id ");

    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
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
       personRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);

        Person updatedPerson = personRepository.save(personToUpdate); // salva a pessoa
        return createMessageResponse(updatedPerson.getId(), "Updated person with id ");
    }

    private Person verifyIfExists (Long id) throws PersonNotFoundException {
        return personRepository.findById(id).
                orElseThrow(()->new PersonNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}

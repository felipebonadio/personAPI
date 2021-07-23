package one.digital.innovation.personApi.service;

import one.digital.innovation.personApi.dto.response.MessageResponseDTO;
import one.digital.innovation.personApi.entity.Person;
import one.digital.innovation.personApi.repository.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // gerenciador classe do tipo serviço, transações
public class PersonService {
    public PersonRespository personRespository;

    @Autowired
    public PersonService(PersonRespository personRespository) {
        this.personRespository = personRespository;
    }

    public MessageResponseDTO createPerson(Person person){ //parametro Person
        personRespository.save(person); // salva a pessoa
        return MessageResponseDTO
                .builder()
                .message("Created person with id "+ person.getId())
                .build();
    }
}

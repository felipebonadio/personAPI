package one.digital.innovation.personApi.repository;

import one.digital.innovation.personApi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRespository extends JpaRepository<Person, Long> {
}

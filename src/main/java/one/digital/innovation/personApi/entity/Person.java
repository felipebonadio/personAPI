package one.digital.innovation.personApi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Person {
    @Id//chave primária da classe Phone
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera os ids automaticamente
    private Long id;

    @Column(nullable = false)//cria o campo como not null, tornando obrigatório
    private String firstName;
    @Column(nullable = false)//cria o campo como not null, tornando obrigatório
    private String lastName;
    @Column(nullable = false, unique = true)//cria o campo como not null, tornando obrigatório.
    // unique só pode cadastrar com dados unicos
    private String cpf;

    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}

package one.digital.innovation.personApi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    private Long id;

    @NotEmpty
    @Size(min =2, max = 100)
    private String firstName;

    @NotEmpty
    @Size(min =2, max = 100)
    private String lastName;

    @NotEmpty

    private String cpf;

    private String birthDate;

    @Valid
    @NotEmpty // não pode ser vazio
    @Size(min = 13, max = 14) //numero maximo de caracteres
    private List<PhoneDTO> phones;
}

package one.digital.innovation.personApi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.personApi.enums.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty // não pode ser vazio
    @Size(min = 13, max = 14) //numero maximo de caracteres
    private String number;

}

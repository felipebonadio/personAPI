package one.digital.innovation.personApi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digital.innovation.personApi.enums.PhoneType;

import javax.persistence.*;

@Entity//reconhece a classe como parte do banco
@Data //gera todos os gets, sets, equals e hashcodes,
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    @Id//chave primária da classe Phone
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gera os ids automaticamente
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)//cria o campo como not null, tornando obrigatório
    private PhoneType type;
    @Column(nullable = false)//cria o campo como not null, tornando obrigatório
    private String number;
}

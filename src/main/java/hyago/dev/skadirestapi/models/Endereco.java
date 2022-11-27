package hyago.dev.skadirestapi.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Endereco {

    private String logradouro;
    private String complemento;
    private String bairro;
    private String numero;


}
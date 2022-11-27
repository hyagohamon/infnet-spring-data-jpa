package hyago.dev.skadirestapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;


/*
 *
 * */

public record ProfissionalDTO(

        @NotBlank
        String nome,
        @Email
        String email,

        @NotBlank
        @CPF
        String cpf,
        String nomeSocial,
        String rg,
        @Past
        LocalDate dataNascimento,
        LocalDate dataExpedicaoRG,
        String nomeDoPai,
        String nomeDaMae,
        String celular,
        String telefone,
        String cns
) {


}

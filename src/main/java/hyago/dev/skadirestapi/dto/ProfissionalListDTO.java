package hyago.dev.skadirestapi.dto;

import hyago.dev.skadirestapi.models.Profissional;

public record ProfissionalListDTO(Long id, String nome, String cpf, String cns, String rg, String email) {

    public ProfissionalListDTO(Profissional profissional) {
        this(
                profissional.getId(),
                profissional.getNome(),
                profissional.getCpf(),
                profissional.getCns(),
                profissional.getRg(),
                profissional.getEmail()


        );
    }
}

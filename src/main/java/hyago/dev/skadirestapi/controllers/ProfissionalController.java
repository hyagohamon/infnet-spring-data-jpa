package hyago.dev.skadirestapi.controllers;

import hyago.dev.skadirestapi.dto.ProfissionalDTO;
import hyago.dev.skadirestapi.dto.ProfissionalListDTO;
import hyago.dev.skadirestapi.models.Profissional;
import hyago.dev.skadirestapi.repositories.ProfissionalRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profissionais")
public class ProfissionalController {

    @Autowired
    ProfissionalRepository profissionalRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ProfissionalDTO profissionalDTO) {
        Profissional profissional = new Profissional(profissionalDTO);
        profissionalRepository.save(profissional);
    }

    @GetMapping
    public Page<ProfissionalListDTO> listar(@PageableDefault(sort = {"nome"}) Pageable paginacao) {
        return profissionalRepository.findAllByExcluidoFalse(paginacao).map(ProfissionalListDTO::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id) {
        Profissional profissional = profissionalRepository.getReferenceById(id);
        Profissional.excluir(profissional);
    }
}

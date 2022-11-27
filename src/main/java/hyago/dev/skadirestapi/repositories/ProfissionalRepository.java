package hyago.dev.skadirestapi.repositories;

import hyago.dev.skadirestapi.models.Profissional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {

    Page<Profissional> findAllByExcluidoFalse(Pageable paginacao);

    Profissional findAllByNome(String nome);

    @Query("SELECT p FROM Profissional p WHERE p.cpf = ?1")
    Profissional findAllByCpf(String cpf);
}

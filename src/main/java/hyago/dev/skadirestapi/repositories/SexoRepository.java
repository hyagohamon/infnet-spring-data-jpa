package hyago.dev.skadirestapi.repositories;

import hyago.dev.skadirestapi.models.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexoRepository extends JpaRepository<Sexo, Long> {

}

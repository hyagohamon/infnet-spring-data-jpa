package hyago.dev.skadirestapi.repositories;

import hyago.dev.skadirestapi.models.Naturalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NaturalidadeRepository extends JpaRepository<Naturalidade, Long> {

}

package hyago.dev.skadirestapi.repositories;

import hyago.dev.skadirestapi.models.RacaCor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacaCorRepository extends JpaRepository<RacaCor, Long> {

}

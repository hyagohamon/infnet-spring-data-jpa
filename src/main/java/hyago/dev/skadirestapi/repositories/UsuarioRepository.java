package hyago.dev.skadirestapi.repositories;

import hyago.dev.skadirestapi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
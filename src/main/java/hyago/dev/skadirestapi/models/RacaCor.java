package hyago.dev.skadirestapi.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "raca_cor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class RacaCor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
}
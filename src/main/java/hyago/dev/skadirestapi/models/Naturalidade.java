package hyago.dev.skadirestapi.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "naturalidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Naturalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String descricao;


}
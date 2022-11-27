package hyago.dev.skadirestapi.models;

import hyago.dev.skadirestapi.dto.ProfissionalDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "profissional")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Profissional {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String nomeSocial;
    private LocalDate dataNascimento;
    @ManyToOne
    @JoinColumn(name = "raca_cor_ID")
    private RacaCor racaCor;
    private String rg;
    private String cns;
    private LocalDate dataExpedicaoRg;
    private String nomeDoPai;
    private String nomeDaMae;
    private String celular;
    private String telefone;
    @Embedded
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "naturalidade_id")
    private Naturalidade naturalidade;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "sexo_id")
    private Sexo sexo;

    private Boolean excluido = false;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;


//    @OneToMany(mappedBy = "profissional", orphanRemoval = true)
//    private Collection<Vinculo> vinculoes = new ArrayList<>();


    public Profissional(ProfissionalDTO profissionalDTO) {

        this.nome = profissionalDTO.nome();
        this.email = profissionalDTO.email();
        this.cpf = profissionalDTO.cpf();
        this.nomeSocial = profissionalDTO.nomeSocial();
        this.dataNascimento = profissionalDTO.dataNascimento();
        this.rg = profissionalDTO.rg();
        this.cns = profissionalDTO.cns();
        this.dataExpedicaoRg = profissionalDTO.dataExpedicaoRG();
        this.nomeDoPai = profissionalDTO.nomeDoPai();
        this.nomeDaMae = profissionalDTO.nomeDaMae();
        this.celular = profissionalDTO.celular();
        this.telefone = profissionalDTO.telefone();
        this.excluido = false;
    }

    public static void excluir(Profissional profissional) {
        profissional.setExcluido(true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Profissional that = (Profissional) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

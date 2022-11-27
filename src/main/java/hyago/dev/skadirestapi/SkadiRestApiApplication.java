package hyago.dev.skadirestapi;

import hyago.dev.skadirestapi.models.*;
import hyago.dev.skadirestapi.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SkadiRestApiApplication implements CommandLineRunner {

    @Autowired
    ProfissionalRepository profissionalRepository;

    @Autowired
    RacaCorRepository racaCorRepository;

    @Autowired
    SexoRepository sexoRepository;

    @Autowired
    NaturalidadeRepository naturalidadeRepository;

    @Autowired
    UsuarioRepository usuarioRepository;


    public static void main(String[] args) {
        SpringApplication.run(SkadiRestApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        cadastrarProfissional();

        System.out.println("----------------------------------");
        System.out.println("Listando todos os profissionais: ");

        for (Profissional profissional : listaProfissionais()) {
            System.out.println(profissional);
        }

        listaProfissionalPorNome("Hyago Hamon Sousa de Aquino");


        delete(1l);

        atualizarPorId(3l);

        listarPorCPF("05027864346");
    }

    private void cadastrarProfissional() {

        Usuario usuario = new Usuario(null,"admin","admin","admin");
        usuarioRepository.save(usuario);
        RacaCor racaCor = new RacaCor(null, "Branco");
        racaCorRepository.save(racaCor);

        Sexo sexo = new Sexo(null, "Masculino");
        sexoRepository.save(sexo);

        Sexo sexoFeminino = new Sexo(null, "Feminino");
        sexoRepository.save(sexoFeminino);


        Naturalidade naturalidade = new Naturalidade(null, "Bacabal-MA");
        naturalidadeRepository.save(naturalidade);

        Profissional p1 = new Profissional();
        p1.setNome("Hyago Hamon Sousa de Aquino");
        p1.setEmail("hyagohamon@gmail.com");
        p1.setCpf("05027864341");
        p1.setNomeSocial("Hyago");
        p1.setDataNascimento(LocalDate.of(1992, 07, 01));
        p1.setRacaCor(racaCor);
        p1.setSexo(sexo);
        p1.setRg("999888777666");
        p1.setDataExpedicaoRg(LocalDate.now());
        p1.setCns("444 444 333 222");
        p1.setEndereco(new Endereco("Cleomenes Falcao", "Casa", "Centro", "15"));
        p1.setNomeDoPai("Eugenio Lima de Aquino");
        p1.setNomeDaMae("Regina Lucia Sousa de Aquino");
        p1.setCelular("99985453296");
        p1.setTelefone("36210711");
        p1.setNaturalidade(naturalidade);
        p1.setUsuario(usuario);
        p1.setEndereco(new Endereco("rua","casa","centro","15"));

        Profissional p2 = new Profissional();
        p2.setNome("Osvaldo Pereira");
        p2.setEmail("o@mario.com");
        p2.setCpf("05027864346");
        p2.setNomeSocial("");
        p2.setDataNascimento(LocalDate.now());
        p2.setRacaCor(racaCor);
        p2.setSexo(sexo);
        p2.setRg("999999999");
        p2.setCns("123456");
        p2.setDataExpedicaoRg(LocalDate.now());
        p2.setNomeDoPai("Mario de Souza");
        p2.setNomeDaMae("Maria de Souza");
        p2.setCelular("99999999");
        p2.setTelefone("12345678");
        p2.setNaturalidade(naturalidade);
        p2.setUsuario(usuario);
        p2.setEndereco(new Endereco("rua x","casa","esperanca","105"));

        Profissional p3 = new Profissional();
        p3.setNome("Mariana Cutrim");
        p3.setEmail("mariana@mariana.com");
        p3.setCpf("05027864335");
        p3.setNomeSocial("mari");
        p3.setDataNascimento(LocalDate.now());
        p3.setRacaCor(racaCor);
        p3.setSexo(sexoFeminino);
        p3.setRg("58452233");
        p3.setCns("00002254");
        p3.setDataExpedicaoRg(LocalDate.now());
        p3.setNomeDoPai("Messias Tomaz");
        p3.setNomeDaMae("Jocyane Oliveira");
        p3.setCelular("55554433321");
        p3.setTelefone("12345678");
        p3.setNaturalidade(naturalidade);
        p3.setUsuario(usuario);
        p3.setEndereco(new Endereco("rua y","casa amarela","teixeira de freitas","1224"));

        System.out.println("--------------------------------------------------------------------");
        System.out.println("Cadastrando profissionais");
        System.out.println(profissionalRepository.save(p1));
        System.out.println(profissionalRepository.save(p2));
        System.out.println(profissionalRepository.save(p3));


    }

    private List<Profissional> listaProfissionais() {
        return profissionalRepository.findAll();
    }

    private void listaProfissionalPorNome(String nome) {
        System.out.println("----------------------------------------------");
        System.out.println("Listando profissional pelo nome");
        System.out.println(profissionalRepository.findAllByNome(nome));

    }

    private void delete(Long id) {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Deletando profissional de código: " + id);
        profissionalRepository.deleteById(id);
    }

    private void atualizarPorId(Long id) {



        Optional<Profissional> profissionalRecuperadoDoBanco = profissionalRepository.findById(id);
        if (profissionalRecuperadoDoBanco.isPresent()) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Atualizando profissional:" + profissionalRecuperadoDoBanco.get().getId());
            System.out.println("Antes da atualização o nome do profissional era :" + profissionalRecuperadoDoBanco.get().getNome());

            profissionalRecuperadoDoBanco.get().setNome("CAMILA DIAS DOS SANTOS");
            profissionalRecuperadoDoBanco.get().setEmail("CAMILA@KMILA.COM");
            profissionalRepository.save(profissionalRecuperadoDoBanco.get());
            System.out.println("Depois da atualização o nome do profissional é :" + profissionalRecuperadoDoBanco.get().getNome());
        }


    }

    private void listarPorCPF(String cpf){
        Profissional profissional = profissionalRepository.findAllByCpf(cpf);
        System.out.println("listando profissional pelo cpf pesquisado via @query");
        System.out.println(profissional);
    }


}

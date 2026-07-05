package br.com.ccs.filasaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.ccs.filasaude.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}

/*repository.save(paciente);
repository.findAll();
repository.findById(id);
repository.deleteById(id);

Sem Repository (Java puro)

Você teria que escrever:

Connection con =
DriverManager.getConnection(...);

PreparedStatement ps =
con.prepareStatement(
"insert into paciente(nome,cpf) values (?,?)");

ps.setString(1, paciente.getNome());
ps.setString(2, paciente.getCpf());

ps.execute();

E quando criar métodos?

Exemplo:

public interface PacienteRepository
extends JpaRepository<Paciente, Long>{

    List<Paciente> findByNomeContaining(String nome);

    Paciente findByCpf(String cpf);

}
repository.findByCpf("123");

Sem SQL.

Então o Repository existe para cumprir a responsabilidade de:

Controller
↓
Repository
↓
Banco

e deixar o Controller sem código SQL.

“repository.save(paciente); repository.findAll(); repository.findById(id); repository.deleteById(id);”
*/
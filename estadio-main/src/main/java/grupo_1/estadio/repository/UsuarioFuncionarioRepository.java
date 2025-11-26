package grupo_1.estadio.repository;

import grupo_1.estadio.model.Ingresso;
import grupo_1.estadio.model.UsuarioFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.pringframework.stereotype.Repository;

public interface UsuarioFuncionarioRepository extends JpaRepository<UsuarioFuncionario, Integer> {}

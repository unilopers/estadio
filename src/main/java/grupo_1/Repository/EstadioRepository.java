package grupo_1.estadio.Repository;

import grupo_1.estadio.Model.EstadioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadioRepository extends JpaRepository<EstadioModel, Long> {
    Optional<EstadioModel> findByNome(String nome);
    
}

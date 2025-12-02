package grupo_1.Repository;

import grupo_1.Model.EstadioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadioRepository extends JpaRepository<EstadioModel, Integer> {
    Optional<EstadioModel> findByNome(String nome);
    
}

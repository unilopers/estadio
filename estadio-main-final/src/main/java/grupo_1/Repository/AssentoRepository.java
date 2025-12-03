package grupo_1.Repository;

import grupo_1.Model.AssentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssentoRepository extends JpaRepository<AssentoModel, Integer> {
}

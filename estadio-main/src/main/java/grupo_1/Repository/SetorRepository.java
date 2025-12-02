package grupo_1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import grupo_1.Model.SetorModel;

@Repository
public interface SetorRepository extends JpaRepository<SetorModel, Integer> {

}

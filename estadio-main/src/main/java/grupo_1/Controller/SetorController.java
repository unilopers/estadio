package grupo_1.Controller;

import grupo_1.Model.SetorModel;
import grupo_1.Repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorRepository setorRepository;

    @GetMapping
    public List<SetorModel> listarSetores() {
        return setorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<SetorModel> buscarPorId(@PathVariable Integer id) {
        return setorRepository.findById(id);
    }

    @PostMapping
    public SetorModel criarSetor(@RequestBody SetorModel setor) {
        return setorRepository.save(setor);
    }

    @PutMapping("/{id}")
    public SetorModel atualizarSetor(@PathVariable Integer id, @RequestBody SetorModel setorAtualizado) {
        return setorRepository.findById(id).map(setor -> {
            setor.setNome(setorAtualizado.getNome());
            setor.setEstadio(setorAtualizado.getEstadio());
            return setorRepository.save(setor);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarSetor(@PathVariable Integer id) {
        setorRepository.deleteById(id);
    }
}

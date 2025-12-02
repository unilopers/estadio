package grupo_1.Controller;

import grupo_1.Model.AssentoModel;
import grupo_1.Repository.AssentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assentos")
public class AssentoController {

    @Autowired
    private AssentoRepository assentoRepository;

    @GetMapping
    public List<AssentoModel> listar() {
        return assentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AssentoModel> buscar(@PathVariable Integer id) {
        Optional<AssentoModel> assento = assentoRepository.findById(id);
        return assento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public AssentoModel criar(@RequestBody AssentoModel assento) {
        return assentoRepository.save(assento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AssentoModel> atualizar(@PathVariable Integer id, @RequestBody AssentoModel detalhes) {
        return assentoRepository.findById(id).map(assentoToUpdate -> {
            assentoToUpdate.setSetor(detalhes.getSetor());
            AssentoModel saved = assentoRepository.save(assentoToUpdate);
            return ResponseEntity.ok(saved);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (!assentoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        assentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

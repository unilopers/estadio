package grupo_1.Controller;

import grupo_1.Model.EstadioModel;
import grupo_1.Repository.EstadioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadios")
public class EstadioController {

    private static final Logger logger = LoggerFactory.getLogger(EstadioController.class);

    private final EstadioRepository estadioRepository;

    public EstadioController(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }

    @GetMapping
    public ResponseEntity<List<EstadioModel>> list(){
        logger.debug("Listando estadios");
        return ResponseEntity.ok(estadioRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadioModel> read(@PathVariable Integer id){
        logger.debug("Buscando estadio id={}", id);
        Optional<EstadioModel> estadio = estadioRepository.findById(id);
        return estadio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadioModel> create(@RequestBody EstadioModel estadio){
        if (estadio == null || estadio.getNome() == null) {
            return ResponseEntity.badRequest().build();
        }
        Optional<EstadioModel> existing = estadioRepository.findByNome(estadio.getNome());
        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        EstadioModel saved = estadioRepository.save(estadio);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadioModel> update(@PathVariable Integer id, @RequestBody EstadioModel details) {
        return estadioRepository.findById(id).map(estadioToUpdate -> {
            String novoNome = details.getNome();
            if (novoNome != null && !novoNome.equalsIgnoreCase(estadioToUpdate.getNome())) {
                Optional<EstadioModel> byNome = estadioRepository.findByNome(novoNome);
                if (byNome.isPresent() && !byNome.get().getId().equals(id)) {
                    return new ResponseEntity<EstadioModel>(HttpStatus.CONFLICT);
                }
                estadioToUpdate.setNome(novoNome);
            }
            EstadioModel saved = estadioRepository.save(estadioToUpdate);
            return ResponseEntity.ok(saved);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

package grupo_1.estadio.Controller;

import grupo_1.estadio.Model.EstadioModel;
import grupo_1.estadio.Repository.EstadioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EstadioRepository estadioRepository;

    @GetMapping
    public List<EstadioModel> list(){
        return estadioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadioModel> read(@PathVariable Long id){
        Optional<EstadioModel> estadio = estadioRepository.findById(id);
        return estadio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstadioModel> create(@RequestBody EstadioModel estadio){
        if (estadio.getNome() == null) {
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
    public ResponseEntity<EstadioModel> update(@PathVariable Long id, @RequestBody EstadioModel details) {
    Optional<EstadioModel> opt = estadioRepository.findById(id);
    if (opt.isEmpty()) {
        return ResponseEntity.notFound().build();
    }
    
    EstadioModel estadioToUpdate = opt.get();
    
    String novoNome = details.getNome();

    if (novoNome != null && !novoNome.equalsIgnoreCase(estadioToUpdate.getNome())) {
        Optional<EstadioModel> byNome = estadioRepository.findByNome(novoNome);
        if (byNome.isPresent() && !byNome.get().getId().equals(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        
        estadioToUpdate.setNome(novoNome);
    } 
    
    EstadioModel saved = estadioRepository.save(estadioToUpdate);
    
    return ResponseEntity.ok(saved);
}
}


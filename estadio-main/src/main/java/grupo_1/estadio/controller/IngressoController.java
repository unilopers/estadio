package group_1_estadio.controller;

import group_1_estadio.Ingresso;
import group_1_estadio.service.IngressoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingressos")
public class IngressoController {

    @Autowired
    private IngressoService service;

    @PostMapping
    public ResponseEntity<Ingresso> criarIngresso(@RequestBody Ingresso ingresso) {
        try {
            Ingresso novoIngresso = service.salvar(ingresso);
            return new ResponseEntity<>(novoIngresso, HttpStatus.CREATED); 
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build(); 
        }
    }

    @GetMapping
    public ResponseEntity<List<Ingresso>> listarTodos() {
        List<Ingresso> ingressos = service.buscarTodos();
        return ResponseEntity.ok(ingressos); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingresso> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build()); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ingresso> atualizarIngresso(@PathVariable Long id, @RequestBody Ingresso ingressoAtualizado) {
        try {
            Ingresso atualizado = service.atualizar(id, ingressoAtualizado);
            return ResponseEntity.ok(atualizado); 
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); 
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarIngresso(@PathVariable Long id) {
        try {
            service.deletar(id);
            return ResponseEntity.noContent().build(); 
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); 
        }
    }
}
package grupo_1.estadio.controller;

public package grupo_1.estadio.controller;

import grupo_1.estadio.model.Estacionamento;
import grupo_1.estadio.repository.EstacionamentoRepository;
import grupo_1.estadio.view.EstacionamentoView;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {

    private final EstacionamentoRepository repository;

    public EstacionamentoController(EstacionamentoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<EstacionamentoView> listar() {
        return repository.findAll().stream()
                .map(EstacionamentoView::new)
                .toList();
    }

    @PostMapping
    public EstacionamentoView criar(@RequestBody Estacionamento estacionamento) {
        Estacionamento salvo = repository.save(estacionamento);
        return new EstacionamentoView(salvo);
    }

    @GetMapping("/{id}")
    public EstacionamentoView buscar(@PathVariable Long id) {
        Estacionamento est = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado"));
        return new EstacionamentoView(est);
    }

    @PutMapping("/{id}")
    public EstacionamentoView atualizar(@PathVariable Long id, @RequestBody Estacionamento atualizado) {
        Estacionamento est = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado"));

        est.setDescricao(atualizado.getDescricao());
        est.setCapacidade(atualizado.getCapacidade());

        return new EstacionamentoView(repository.save(est));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
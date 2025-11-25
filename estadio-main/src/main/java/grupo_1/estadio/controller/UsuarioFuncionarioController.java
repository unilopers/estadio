package grupo_1.estadio.controller;

import grupo_1.estadio.dto.UsuarioFuncionarioDTO;
import grupo_1.estadio.model.UsuarioFuncionario;
import grupo_1.estadio.service.UsuarioFuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioFuncionarioController {

    private final UsuarioFuncionarioService service;

    public UsuarioFuncionarioController(UsuarioFuncionarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioFuncionarioDTO>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioFuncionarioDTO> buscar(@PathVariable Integer id) {
        var usuario = service.buscar(id);
        if (usuario == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<UsuarioFuncionarioDTO> criar(@RequestBody UsuarioFuncionario usuario) {
        var criado = service.salvar(usuario);
        return ResponseEntity.created(URI.create("/usuarios/" + criado.getIdUsuario()))
                .body(new UsuarioFuncionarioDTO(
                        criado.getIdUsuario(),
                        criado.getNome(),
                        criado.getUsername(),
                        criado.getEmail()
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

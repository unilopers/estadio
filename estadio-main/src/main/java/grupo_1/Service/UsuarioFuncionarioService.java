package grupo_1.Service;

import grupo_1.dto.UsuarioFuncionarioDTO;
import grupo_1.Model.UsuarioFuncionario;
import grupo_1.Repository.UsuarioFuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioFuncionarioService {

    private final UsuarioFuncionarioRepository repository;

    public UsuarioFuncionarioService(UsuarioFuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<UsuarioFuncionarioDTO> listar() {
        return repository.findAll().stream()
                .map(u -> new UsuarioFuncionarioDTO(
                        u.getIdUsuario(),
                        u.getNome(),
                        u.getUsername(),
                        u.getEmail()
                ))
                .collect(java.util.stream.Collectors.toList());
    }

    public UsuarioFuncionarioDTO buscar(Integer id) {
        return repository.findById(id)
                .map(u -> new UsuarioFuncionarioDTO(
                        u.getIdUsuario(),
                        u.getNome(),
                        u.getUsername(),
                        u.getEmail()
                ))
                .orElse(null);
    }

    public UsuarioFuncionario salvar(UsuarioFuncionario usuario) {
        return repository.save(usuario);
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}

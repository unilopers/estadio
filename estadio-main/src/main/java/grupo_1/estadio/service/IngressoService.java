package group_1_estadio.service;

import group_1_estadio.Ingresso;
import group_1_estadio.repository.IngressoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IngressoService {

    @Autowired 
    private IngressoRepository repository;

    public Ingresso salvar(Ingresso novoIngresso) {
        if (novoIngresso.getDataEmissao() == null) {
            novoIngresso.setDataEmissao(LocalDateTime.now());
        }
        return repository.save(novoIngresso);
    }

    public List<Ingresso> buscarTodos() {
        return repository.findAll();
    }

    public Optional<Ingresso> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Ingresso atualizar(Long id, Ingresso ingressoDetalhes) {
        return repository.findById(id).map(ingressoExistente -> {
            
            ingressoExistente.setPrecoVenda(ingressoDetalhes.getPrecoVenda());
            ingressoExistente.setCodigoIngresso(ingressoDetalhes.getCodigoIngresso()); 
            ingressoExistente.setIsUtilizado(ingressoDetalhes.getIsUtilizado());
            
            if (ingressoDetalhes.getIsUtilizado() != null && ingressoDetalhes.getIsUtilizado() && ingressoExistente.getDataHoraUso() == null) {
                ingressoExistente.setDataHoraUso(LocalDateTime.now());
            }

            return repository.save(ingressoExistente);
        }).orElseThrow(() -> new RuntimeException("Ingresso ID " + id + " não encontrado para atualização."));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Ingresso ID " + id + " não encontrado para deleção.");
        }
        repository.deleteById(id);
    }
}
package com.seuprojeto.controller;

import com.seuprojeto.model.Setor;
import com.seuprojeto.repository.SetorRepository;
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
    public List<Setor> listarSetores() {
        return setorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Setor> buscarPorId(@PathVariable Integer id) {
        return setorRepository.findById(id);
    }

    @PostMapping
    public Setor criarSetor(@RequestBody Setor setor) {
        return setorRepository.save(setor);
    }

    @PutMapping("/{id}")
    public Setor atualizarSetor(@PathVariable Integer id, @RequestBody Setor setorAtualizado) {
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

package com.example.projetos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetos.dtos.SetorDTO;
import com.example.projetos.models.Setor;
import com.example.projetos.repositories.SetorRepository;

@Service
public class SetorService {

    @Autowired
    private SetorRepository repo;

    public void adicionar(SetorDTO dto) {
        Setor s = new Setor();
        s.setNome(dto.getNome());
        repo.save(s);
    }

    public Setor buscarSetorPorId(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));
    }
}

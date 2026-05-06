package com.example.projetos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetos.dtos.FuncionarioDTO;
import com.example.projetos.models.Funcionario;
import com.example.projetos.models.Projeto;
import com.example.projetos.models.Setor;
import com.example.projetos.repositories.FuncionarioRepository;
import com.example.projetos.repositories.SetorRepository;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repo;

    @Autowired
    private SetorRepository setorRepo;

    public void adicionar(FuncionarioDTO dto) {

        Funcionario f = new Funcionario();
        f.setNome(dto.getNome());

        Setor setor = setorRepo.findById(dto.getSetorId())
                .orElseThrow(() -> new RuntimeException("Setor não encontrado"));

        f.setSetor(setor);
        repo.save(f);
    }

    public List<Projeto> buscarProjetos(Integer idFuncionario) {
        return repo.buscarProjetosDoFuncionario(idFuncionario);
    }
}
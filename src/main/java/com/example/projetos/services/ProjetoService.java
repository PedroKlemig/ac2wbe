package com.example.projetos.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetos.dtos.ProjetoDTO;
import com.example.projetos.models.Funcionario;
import com.example.projetos.models.Projeto;
import com.example.projetos.repositories.FuncionarioRepository;
import com.example.projetos.repositories.ProjetoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepo;

    @Autowired
    private FuncionarioRepository funcRepo;

    public void adicionar(ProjetoDTO dto) {
        Projeto p = new Projeto();
        p.setDescricao(dto.getDescricao());
        p.setDataInicio(dto.getDataInicio());
        p.setDataFim(dto.getDataFim());
        projetoRepo.save(p);
    }

    @Transactional
    public Projeto buscarProjetoPorId(Integer id) {
        return projetoRepo.buscarProjetoComFuncionarios(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }

    @Transactional
    public void vincularFuncionario(Integer idProjeto, Integer idFuncionario) {

        Projeto projeto = projetoRepo.findById(idProjeto)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        Funcionario funcionario = funcRepo.findById(idFuncionario)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        projeto.getFuncionarios().add(funcionario);
        //projetoRepo.save(projeto);
    }
}
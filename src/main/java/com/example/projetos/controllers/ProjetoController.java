package com.example.projetos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetos.dtos.ProjetoDTO;
import com.example.projetos.models.Projeto;
import com.example.projetos.services.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService service;

    @PostMapping
    public void adicionar(@RequestBody ProjetoDTO dto) {
        service.adicionar(dto);
    }

    @GetMapping("/{id}")
    public Projeto buscarProjetoPorId(@PathVariable Integer id) {
        return service.buscarProjetoPorId(id);
    }


    @PostMapping("/{idProjeto}/funcionario/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto,
                                    @PathVariable Integer idFuncionario) {
        service.vincularFuncionario(idProjeto, idFuncionario);
    }
}

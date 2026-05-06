package com.example.projetos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetos.dtos.FuncionarioDTO;
import com.example.projetos.models.Projeto;
import com.example.projetos.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public void adicionar(@RequestBody FuncionarioDTO dto) {
        service.adicionar(dto);
    }

    @GetMapping("/{id}/projetos")
    public List<Projeto> buscarProjetos(@PathVariable Integer id) {
        return service.buscarProjetos(id);
    }
}

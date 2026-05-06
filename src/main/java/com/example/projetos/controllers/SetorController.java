package com.example.projetos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetos.dtos.SetorDTO;
import com.example.projetos.models.Setor;
import com.example.projetos.services.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private SetorService service;

    @PostMapping
    public void adicionar(@RequestBody SetorDTO dto) {
        service.adicionar(dto);
    }

    @GetMapping("/{id}")
    public Setor buscarSetorPorId(@PathVariable Integer id) {
        return service.buscarSetorPorId(id);
    }
}

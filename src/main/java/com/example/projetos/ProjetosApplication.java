package com.example.projetos;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.projetos.dtos.FuncionarioDTO;
import com.example.projetos.dtos.ProjetoDTO;
import com.example.projetos.dtos.SetorDTO;
import com.example.projetos.models.Projeto;
import com.example.projetos.services.FuncionarioService;
import com.example.projetos.services.ProjetoService;
import com.example.projetos.services.SetorService;

@SpringBootApplication
public class ProjetosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetosApplication.class, args);
    }

    @Bean
    CommandLineRunner run(
            ProjetoService projetoService,
            FuncionarioService funcionarioService,
            SetorService setorService
    ) {
        return args -> {

            SetorDTO setorDTO = new SetorDTO();
            setorDTO.setNome("TI");
            setorService.adicionar(setorDTO);

            FuncionarioDTO funcDTO = new FuncionarioDTO();
            funcDTO.setNome("João");
            funcDTO.setSetorId(1);
            funcionarioService.adicionar(funcDTO);

            ProjetoDTO projDTO = new ProjetoDTO();
            projDTO.setDescricao("Sistema ERP");
            projDTO.setDataInicio(LocalDate.now());
            projDTO.setDataFim(LocalDate.now().plusDays(30));
            projetoService.adicionar(projDTO);

            projetoService.vincularFuncionario(1, 1);

            Projeto projeto = projetoService.buscarProjetoPorId(1);

            System.out.println("\n\nProjeto: " + projeto.getDescricao());
            System.out.println("Funcionários vinculados:");

            projeto.getFuncionarios().forEach(f ->
                System.out.println("- " + f.getNome())
            );

            System.out.println("Projetos do funcionário:");
            funcionarioService.buscarProjetos(1).forEach(p ->
                System.out.println(p)
            );

        };
    }
}
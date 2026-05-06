package com.example.projetos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projetos.models.Funcionario;
import com.example.projetos.models.Projeto;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("SELECT f.projetos FROM Funcionario f WHERE f.id = :id")
    List<Projeto> buscarProjetosDoFuncionario(@Param("id") Integer id);
}

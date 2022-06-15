package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Integer> {
  Aluno findByMatricula(int matricula);
}

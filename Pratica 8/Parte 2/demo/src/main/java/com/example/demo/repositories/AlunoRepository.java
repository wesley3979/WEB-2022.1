package com.example.demo.repositories;

import com.example.demo.entities.Aluno;
import org.springframework.data.repository.CrudRepository;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
  Aluno findByMatricula(int matricula);
}

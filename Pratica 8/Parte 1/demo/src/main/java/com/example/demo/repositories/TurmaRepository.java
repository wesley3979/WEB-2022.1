package com.example.demo.repositories;

import com.example.demo.entities.Turma;

import org.springframework.data.repository.CrudRepository;

public interface TurmaRepository extends CrudRepository<Turma, Long> {
  Turma findByCodigo(int codigo);
}

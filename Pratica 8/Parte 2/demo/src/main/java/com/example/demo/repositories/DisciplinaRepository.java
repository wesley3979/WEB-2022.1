package com.example.demo.repositories;

import com.example.demo.entities.Disciplina;
import org.springframework.data.repository.CrudRepository;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {
    Disciplina findByCodigo(int codigo);
}

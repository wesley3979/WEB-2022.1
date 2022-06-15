package com.example.demo.services;

import com.example.demo.entities.Disciplina;
import com.example.demo.repositories.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DisciplinaService {

  @Autowired
  private DisciplinaRepository repository;

  @Transactional
  public Disciplina addDisciplina(Disciplina newDisciplina) throws Exception {
    try {
      Disciplina disciplina = repository.findByCodigo(newDisciplina.getCodigo());
      if (disciplina != null)
        return null;

      disciplina = new Disciplina();
      disciplina.setCodigo(newDisciplina.getCodigo());
      disciplina.setCreditos(newDisciplina.getCreditos());
      disciplina.setNome(newDisciplina.getNome());
      repository.save(disciplina);

      return disciplina;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Transactional(readOnly = true)
  public Iterable<Disciplina> getAllDisciplinas() throws Exception {
    try {
      Iterable<Disciplina> disciplinas = repository.findAll();
      if (!disciplinas.iterator().hasNext())
        return null;

      return disciplinas;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Transactional(readOnly = true)
  public Disciplina isNullDisciplina(Disciplina newDisciplina) throws Exception {
    try {
      Disciplina disciplina = repository.findByCodigo(newDisciplina.getCodigo());
      if (disciplina == null)
        return null;

      return disciplina;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}
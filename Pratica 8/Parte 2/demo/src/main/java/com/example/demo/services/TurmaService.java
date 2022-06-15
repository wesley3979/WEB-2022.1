package com.example.demo.services;

import com.example.demo.entities.Aluno;
import com.example.demo.entities.Turma;
import com.example.demo.repositories.TurmaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TurmaService {

  @Autowired
  private TurmaRepository repository;
  @Autowired
  private AlunoService alunoService;
  @Autowired
  private DisciplinaService disciplinaService;
  @Autowired
  private HorarioService horarioService;

  @Transactional
  public Turma addTurma(Turma newTurma) throws Exception {
    try {
      Turma turma = repository.findByCodigo(newTurma.getCodigo());
      if (turma != null)
        return null;

      turma = new Turma();
      turma.setCodigo(newTurma.getCodigo());
      turma.setDisciplina(disciplinaService.isNullDisciplina(newTurma.getDisciplina()));
      turma.setAlunos(alunoService.isNullAlunos(newTurma));
      turma.setHorarios(horarioService.isExistsDate(newTurma.getHorarios()));
      repository.save(turma);

      return turma;

    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Transactional(readOnly = true)
  public Iterable<Turma> getAllTurmas() throws Exception {
    try {
      Iterable<Turma> turmas = repository.findAll();
      if (!turmas.iterator().hasNext())
        return null;

      return turmas;

    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Transactional
  public Turma addAlunoByTurmaId(Long id, Aluno newAluno) throws Exception {
    try {
      Optional<Turma> turma = repository.findById(id);
      if (turma.isEmpty())
        return null;
      if (alunoService.alunoIsOnTheList(turma.get(), newAluno))
        return null;

      turma.get().getAlunos().add(alunoService.isNullAluno(newAluno));
      repository.save(turma.get());

      return turma.get();

    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}

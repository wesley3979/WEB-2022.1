package com.example.demo.services;

import com.example.demo.entities.Aluno;
import com.example.demo.entities.Turma;
import com.example.demo.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class AlunoService {
  @Autowired
  private AlunoRepository repository;

  @Transactional
  public Aluno addAluno(Aluno newAluno) throws Exception {
    try {
      Aluno aluno = repository.findByMatricula(newAluno.getMatricula());
      if (aluno != null)
        return null;

      aluno = new Aluno();
      aluno.setMatricula(newAluno.getMatricula());
      aluno.setNome(newAluno.getNome());
      aluno.setData_nasc(newAluno.getData_nasc());
      aluno.setEmail(newAluno.getEmail());
      aluno.setTelefone(newAluno.getTelefone());
      aluno.setEndereco(newAluno.getEndereco());
      repository.save(aluno);

      return aluno;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Transactional(readOnly = true)
  public Iterable<Aluno> getAllAlunos() throws Exception {
    try {
      Iterable<Aluno> alunos = repository.findAll();
      if (!alunos.iterator().hasNext())
        return null;

      return alunos;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Transactional(readOnly = true)
  public Set<Aluno> isNullAlunos(Turma newTurma) throws Exception {
    try {
      Set<Aluno> alunos = new HashSet<>();
      Aluno exist;
      for (Aluno aluno : newTurma.getAlunos()) {
        exist = repository.findByMatricula(aluno.getMatricula());
        if (exist == null)
          return null;
        alunos.add(exist);
      }
      return alunos;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Transactional(readOnly = true)
  public boolean alunoIsOnTheList(Turma turma, Aluno newAluno) {

    for (Aluno aluno : turma.getAlunos()) {
      if (aluno.getMatricula() == newAluno.getMatricula())
        return true;
    }

    return false;
  }

  @Transactional(readOnly = true)
  public Aluno isNullAluno(Aluno aluno) throws Exception {
    try {
      Aluno exist;
      exist = repository.findByMatricula(aluno.getMatricula());
      if (exist == null)
        return null;
      return exist;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}

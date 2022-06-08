package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Aluno;
import com.example.demo.entities.Turma;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurmaService {

  public List<Turma> turmas = new ArrayList<Turma>();

  public List<Turma> findAll() {

    List<Turma> result = turmas;

    return result;
  }

  public Turma addTurma(Turma newTurma) {

    for (Turma turma : turmas) {
      if (turma.getCodigo() == newTurma.getCodigo()) {
        return null;
      }
    }

    turmas.add(newTurma);

    return newTurma;
  }

  public Turma findByCodigo(int codigo) {

    for (Turma turma : turmas) {
      if (turma.getCodigo() == codigo) {
        return turma;
      }
    }

    return null;
  }

  public Turma editTurmaByCodigo(int codigo, Turma editTurma) {
    for (Turma turma : turmas) {
      if (turma.getCodigo() == codigo) {

        if (editTurma.getDisciplina() != null)
          turma.setDisciplina(editTurma.getDisciplina());

        if (editTurma.getSemestre() > 0)
          turma.setSemestre(editTurma.getSemestre());

        if (editTurma.getAlunos() != null)
          turma.setAlunos(editTurma.getAlunos());
        return turma;
      }
    }

    return null;
  }

  public List<Turma> deleteTurmaByCodigo(int codigo) {
    for (Turma turma : turmas) {
      if (turma.getCodigo() == codigo) {
        turmas.remove(turma);
        return turmas;
      }
    }

    return null;
  }

  public List<Aluno> findAllAlunosByCodigoTurma(int codigo) {
    for (Turma turma : turmas) {
      if (turma.getCodigo() == codigo) {
        return turma.getAlunos();
      }
    }

    return null;
  }

  public Turma addAlunoByCodigoTurma(int codigo, Aluno aluno) {
    for (Turma turma : turmas) {
      if (turma.getCodigo() == codigo) {
        turma.addAluno(aluno);
        return turma;
      }
    }

    return null;
  }

  public Turma deleteAlunoByMatriculaAndCodigoTurma(int codigo, int matricula) {
    for (Turma turma : turmas) {
      if (turma.getCodigo() == codigo) {
        for (Aluno aluno : turma.getAlunos()) {
          if (aluno.getMatricula() == matricula) {
            turma.removeAluno(aluno);
            return turma;
          }
        }
      }
    }

    return null;
  }

  public Aluno editAlunoByMatricula(int codigo, int matricula, Aluno editAluno) {
    for (Turma turma : turmas) {
      if (turma.getCodigo() == codigo) {

        for (Aluno aluno : turma.getAlunos()) {
          if (aluno.getMatricula() == matricula) {
            if (editAluno.getNome() != null)
              aluno.setNome(editAluno.getNome());

            if (editAluno.getEmail() != null)
              editAluno.setEmail(editAluno.getEmail());

            return aluno;
          }
        }

      }
    }

    return null;
  }
}

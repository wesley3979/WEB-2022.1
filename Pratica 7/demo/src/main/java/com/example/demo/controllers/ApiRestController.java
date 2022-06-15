package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Aluno;
import com.example.demo.entities.Turma;
import com.example.demo.repositories.AlunoRepository;
import com.example.demo.services.TurmaService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/turma")
public class ApiRestController {
  @Autowired
  private TurmaService service;

  @Autowired
  AlunoRepository alunoRepository;

  @GetMapping
  Iterable<Aluno> getAlunos() {
    return alunoRepository.findAll();
  }

  // @GetMapping
  // public List<Turma> getTurmas() {
  // return service.findAll();
  // }

  @GetMapping(value = "/{codigo}")
  public Turma getTurmaByCodigo(@PathVariable int codigo) {
    return service.findByCodigo(codigo);
  }

  @PostMapping
  public Turma addTurma(@RequestBody Turma turma) {
    return service.addTurma(turma);
  }

  @PutMapping(value = "/{codigo}")
  public Turma editTurmaByCodigo(@PathVariable int codigo, @RequestBody Turma turma) {
    return service.editTurmaByCodigo(codigo, turma);
  }

  @DeleteMapping(value = "/{codigo}")
  public List<Turma> deleteTurmaByCodigo(@PathVariable int codigo) {
    return service.deleteTurmaByCodigo(codigo);
  }

  @GetMapping(value = "/{codigo}/alunos")
  public List<Aluno> findAllAlunosByCodigoTurma(@PathVariable int codigo) {
    return service.findAllAlunosByCodigoTurma(codigo);
  }

  @PostMapping(value = "/{codigo}/alunos")
  public Turma addAlunosByCodigoTurma(@PathVariable int codigo, @RequestBody Aluno aluno) {
    return service.addAlunoByCodigoTurma(codigo, aluno);
  }

  @DeleteMapping(value = "/{codigo}/alunos/{matricula}")
  public Turma deleteAlunoByMatriculaAndCodigoTurma(@PathVariable int codigo, @PathVariable int matricula) {
    return service.deleteAlunoByMatriculaAndCodigoTurma(codigo, matricula);
  }

  @PutMapping(value = "/{codigo}/alunos/{matricula}")
  public Aluno editAlunoByMatricula(@PathVariable int codigo, @PathVariable int matricula, @RequestBody Aluno aluno) {
    return service.editAlunoByMatricula(codigo, matricula, aluno);
  }

}

package com.example.demo.controllers;

import com.example.demo.entities.Aluno;
import com.example.demo.entities.Turma;
import com.example.demo.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/turma")
public class TurmaController {
  @Autowired
  private TurmaService service;

  @PostMapping
  public Turma addTurma(@RequestBody Turma turma) throws Exception {
    try {
      return service.addTurma(turma);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @GetMapping
  public Iterable<Turma> getAllTurmas() throws Exception {
    try {
      return service.getAllTurmas();
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @PostMapping(value = "/{id}/aluno")
  public Turma addAlunoByTurmaId(@PathVariable Long id, @RequestBody Aluno aluno) throws Exception {
    try {
      return service.addAlunoByTurmaId(id, aluno);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}

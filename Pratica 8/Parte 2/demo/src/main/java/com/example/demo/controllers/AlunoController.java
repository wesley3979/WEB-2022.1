package com.example.demo.controllers;

import com.example.demo.entities.Aluno;
import com.example.demo.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/aluno")
public class AlunoController {
  @Autowired
  private AlunoService service;

  @PostMapping
  public Aluno addAluno(@RequestBody Aluno aluno) throws Exception {
    try {
      return service.addAluno(aluno);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @GetMapping
  public Iterable<Aluno> getAllAlunos() throws Exception {
    try {
      return service.getAllAlunos();
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}
package com.example.demo.controllers;

import com.example.demo.entities.Disciplina;
import com.example.demo.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/disciplina")
public class DisciplinaController {
  @Autowired
  private DisciplinaService service;

  @PostMapping
  public Disciplina addDisciplina(@RequestBody Disciplina disciplina) throws Exception {
    try {
      return service.addDisciplina(disciplina);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @GetMapping
  public Iterable<Disciplina> getAllDisciplina() throws Exception {
    try {
      return service.getAllDisciplinas();
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}

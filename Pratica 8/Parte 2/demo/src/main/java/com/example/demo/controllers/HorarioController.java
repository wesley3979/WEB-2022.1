package com.example.demo.controllers;

import com.example.demo.entities.Horario;
import com.example.demo.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/horario")
public class HorarioController {
  @Autowired
  private HorarioService service;

  @PostMapping
  public Horario addHorario(@RequestBody Horario horario) throws Exception {
    try {
      return service.addHorario(horario);
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @GetMapping
  public Iterable<Horario> getAllHorarios() throws Exception {
    try {
      return service.getAllHorarios();
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}

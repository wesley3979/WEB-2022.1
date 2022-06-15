package com.example.demo.services;

import com.example.demo.entities.Horario;
import com.example.demo.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class HorarioService {
  @Autowired
  private HorarioRepository repository;

  @Transactional
  public Horario addHorario(Horario newHorario) throws Exception {
    try {
      Horario horario = repository.findByHorario(newHorario.getHorario());
      if (horario != null)
        return null;
      horario = new Horario();
      horario.setHorario(newHorario.getHorario());
      repository.save(horario);

      return horario;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Transactional(readOnly = true)
  public Iterable<Horario> getAllHorarios() throws Exception {
    try {
      Iterable<Horario> horarios = repository.findAll();
      if (!horarios.iterator().hasNext())
        return null;

      return horarios;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }

  @Transactional(readOnly = true)
  public Set<Horario> isExistsDate(Set<Horario> newHorarios) throws Exception {
    try {
      Set<Horario> horarios = new HashSet<>();
      Horario exists;
      for (Horario horario : newHorarios) {
        exists = repository.findByHorario(horario.getHorario());
        if (exists == null)
          return null;

        horarios.add(exists);
      }

      return horarios;
    } catch (Exception e) {
      throw new Exception(e);
    }
  }
}

package com.example.demo.repositories;

import com.example.demo.entities.Horario;
import org.springframework.data.repository.CrudRepository;

public interface HorarioRepository extends CrudRepository<Horario, Long> {
  Horario findByHorario(java.util.Date horario);
}

package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "aluno")
public class Aluno {

  @Id
  @GeneratedValue
  private int id;
  private int matricula;
  private String nome;
  private String email;

  public Aluno() {
  }

  public Aluno(int id, int matricula, String nome, String email) {
    this.id = id;
    this.matricula = matricula;
    this.nome = nome;
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getMatricula() {
    return matricula;
  }

  public void setMatricula(int matricula) {
    this.matricula = matricula;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}

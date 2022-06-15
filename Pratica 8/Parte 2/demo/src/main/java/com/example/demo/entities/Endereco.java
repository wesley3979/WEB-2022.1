package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

  @Column(length = 2)
  private String estado;
  private String cidade;
  private String logradouro;
  @Column(length = 10)
  private String numero;
  @Column(length = 8)
  private int cep;

  public Endereco() {
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public int getCep() {
    return cep;
  }

  public void setCep(int cep) {
    this.cep = cep;
  }
}

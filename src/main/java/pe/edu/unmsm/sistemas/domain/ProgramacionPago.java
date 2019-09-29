package pe.edu.unmsm.sistemas.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "programacion_pagos")
public class ProgramacionPago {
  @Id
  @Column(name = "id_programacion_pagos")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "f_vigencia_ini")
  private Date fechaVigenciaInicio;
  @Column(name = "f_vigencia_fin")
  private Date fechaVigenciaFin;

  public ProgramacionPago() {
  }

  public ProgramacionPago(Long id, Date fechaVigenciaInicio, Date fechaVigenciaFin) {
    this.id = id;
    this.fechaVigenciaInicio = fechaVigenciaInicio;
    this.fechaVigenciaFin = fechaVigenciaFin;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getFechaVigenciaInicio() {
    return this.fechaVigenciaInicio;
  }

  public void setFechaVigenciaInicio(Date fechaVigenciaInicio) {
    this.fechaVigenciaInicio = fechaVigenciaInicio;
  }

  public Date getFechaVigenciaFin() {
    return this.fechaVigenciaFin;
  }

  public void setFechaVigenciaFin(Date fechaVigenciaFin) {
    this.fechaVigenciaFin = fechaVigenciaFin;
  }

}
package pe.edu.unmsm.sistemas.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "programacion_pagos")
public class ProgramacionPago {
    @Id
    @Column(name = "id_programacion_pagos")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "f_vigencia_ini")
    private Date fechaVigenciaInicio;
    @Column(name = "f_vigencia_fin")
    private Date fechaVigenciaFin;

    public ProgramacionPago() {
    }

    public ProgramacionPago(Integer id, Date fechaVigenciaInicio, Date fechaVigenciaFin) {
        this.id = id;
        this.fechaVigenciaInicio = fechaVigenciaInicio;
        this.fechaVigenciaFin = fechaVigenciaFin;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
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
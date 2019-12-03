package pe.edu.unmsm.sistemas.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity(name = "programa_presupuesto")
public class ProgramaPresupuesto {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(name = "id_programa_presupuesto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_programa")
    private Programa programa;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_programacion_pagos")
    private ProgramacionPago programacionPago;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "programaPresupuesto")
    private List<ProgramaPresupuestoDetalle> programaPresupuestoDetalles;
    @Column(name = "costo_credito", nullable = false)
    private Integer costoCredito;
    @Column(name = "costo_total", nullable = false)
    private Long costoTotal;

    public ProgramaPresupuesto() {
    }

    public ProgramaPresupuesto(Programa programa, ProgramacionPago programacionPago, List<ProgramaPresupuestoDetalle> programaPresupuestoDetalles, Integer costoCredito, Long costoTotal) {
        this.programa = programa;
        this.programacionPago = programacionPago;
        this.programaPresupuestoDetalles = programaPresupuestoDetalles;
        this.costoCredito = costoCredito;
        this.costoTotal = costoTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }

    public ProgramacionPago getProgramacionPago() {
        return programacionPago;
    }

    public void setProgramacionPago(ProgramacionPago programacionPago) {
        this.programacionPago = programacionPago;
    }

    public List<ProgramaPresupuestoDetalle> getProgramaPresupuestoDetalles() {
        return programaPresupuestoDetalles;
    }

    public void setProgramaPresupuestoDetalles(List<ProgramaPresupuestoDetalle> programaPresupuestoDetalles) {
        this.programaPresupuestoDetalles = programaPresupuestoDetalles;
    }

    public Integer getCostoCredito() {
        return costoCredito;
    }

    public void setCostoCredito(Integer costoCredito) {
        this.costoCredito = costoCredito;
    }

    public Long getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Long costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "ProgramaPresupuesto{" +
                "id=" + id +
                ", programa=" + programa +
                ", programacionPago=" + programacionPago +
                ", programaPresupuestoDetalles=" + programaPresupuestoDetalles +
                ", costoCredito=" + costoCredito +
                ", costoTotal=" + costoTotal +
                '}';
    }
}

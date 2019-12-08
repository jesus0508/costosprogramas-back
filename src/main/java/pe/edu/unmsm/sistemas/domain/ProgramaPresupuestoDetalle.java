package pe.edu.unmsm.sistemas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@IdClass(ProgramaPresupuestoDetalleId.class)
@Entity(name = "programa_presupuesto_det")
public class ProgramaPresupuestoDetalle {

    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_programa_presupuesto")
    private ProgramaPresupuesto programaPresupuesto;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_concepto")
    private Concepto concepto;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_programa_ciclo")
    private ProgramaCiclo programaCiclo;
    @Column(name = "credito")
    private Short credito;
    @Column(name = "importe")
    private Double importe;
    @Column(name = "cuotas")
    private Integer cuotas;

    public ProgramaPresupuestoDetalle() {
    }

    public ProgramaPresupuesto getProgramaPresupuesto() {
        return programaPresupuesto;
    }

    public void setProgramaPresupuesto(ProgramaPresupuesto programaPresupuesto) {
        this.programaPresupuesto = programaPresupuesto;
    }

    public Concepto getConcepto() {
        return concepto;
    }

    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    public ProgramaCiclo getProgramaCiclo() {
        return programaCiclo;
    }

    public void setProgramaCiclo(ProgramaCiclo programaCiclo) {
        this.programaCiclo = programaCiclo;
    }

    public Short getCredito() {
        return credito;
    }

    public void setCredito(Short credito) {
        this.credito = credito;
    }

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Integer getCuotas() {
        return cuotas;
    }

    public void setCuotas(Integer cuotas) {
        this.cuotas = cuotas;
    }

    public Double calcularImporte(Integer costoCredito) {
        return this.importe = getCredito() * costoCredito.doubleValue();
    }

    @Override
    public String toString() {
        return "ProgramaPresupuestoDetalle{" +
                "  concepto=" + concepto +
                ", programaCiclo=" + programaCiclo +
                ", credito=" + credito +
                ", importe=" + importe +
                ", cuotas=" + cuotas +
                '}';
    }
}

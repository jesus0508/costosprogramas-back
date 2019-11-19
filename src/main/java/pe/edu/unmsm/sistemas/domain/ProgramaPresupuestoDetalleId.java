package pe.edu.unmsm.sistemas.domain;

import java.io.Serializable;

public class ProgramaPresupuestoDetalleId implements Serializable {

    private Integer programaPresupuesto;
    private Short concepto;
    private Integer programaCiclo;

    public ProgramaPresupuestoDetalleId() {
    }

    public ProgramaPresupuestoDetalleId(Integer programaPresupuesto, Short concepto, Integer programaCiclo) {
        this.programaPresupuesto = programaPresupuesto;
        this.concepto = concepto;
        this.programaCiclo = programaCiclo;
    }

    public Integer getProgramaPresupuesto() {
        return programaPresupuesto;
    }

    public void setProgramaPresupuesto(Integer programaPresupuesto) {
        this.programaPresupuesto = programaPresupuesto;
    }

    public Short getConcepto() {
        return concepto;
    }

    public void setConcepto(Short concepto) {
        this.concepto = concepto;
    }

    public Integer getProgramaCiclo() {
        return programaCiclo;
    }

    public void setProgramaCiclo(Integer programaCiclo) {
        this.programaCiclo = programaCiclo;
    }

    @Override
    public String toString() {
        return "ProgramaPresupuestoDetalleId{" +
                "programaPresupuesto=" + programaPresupuesto +
                ", concepto=" + concepto +
                ", programaCiclo=" + programaCiclo +
                '}';
    }
}

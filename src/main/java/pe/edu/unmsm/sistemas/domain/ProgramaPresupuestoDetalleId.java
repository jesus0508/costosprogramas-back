package pe.edu.unmsm.sistemas.domain;

import java.io.Serializable;

public class ProgramaPresupuestoDetalleId implements Serializable {

    private ProgramaPresupuesto programaPresupuesto;
    private Concepto concepto;
    private ProgramaCiclo programaCiclo;

    public ProgramaPresupuestoDetalleId() {
    }
}

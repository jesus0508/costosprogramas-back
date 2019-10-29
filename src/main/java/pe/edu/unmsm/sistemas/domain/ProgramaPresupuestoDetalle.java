package pe.edu.unmsm.sistemas.domain;

import javax.persistence.*;

@IdClass(ProgramaPresupuestoDetalleId.class)
@Entity(name = "programa_presupuesto_det")
public class ProgramaPresupuestoDetalle {

    @Id
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
}

package pe.edu.unmsm.sistemas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "programa_presupuesto")
public class ProgramaPresupuesto {
  @Id
  @Column(name = "id_programa_presupuesto")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Programa programa;
  private ProgramacionPago programacionPagos;//mapedby
  @Column(name = "costo_credito")
  private Integer costoCredito;
  @Column(name = "costo_total")
  private Integer costoTotal;

  public ProgramaPresupuesto() {
  }

  public ProgramaPresupuesto(Long id, Programa programa, ProgramacionPago programacionPagos, Integer costoCredito,
      Integer costoTotal) {
    this.id = id;
    this.programa = programa;
    this.programacionPagos = programacionPagos;
    this.costoCredito = costoCredito;
    this.costoTotal = costoTotal;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Programa getPrograma() {
    return this.programa;
  }

  public void setPrograma(Programa programa) {
    this.programa = programa;
  }

  public ProgramacionPago getProgramacionPagos() {
    return this.programacionPagos;
  }

  public void setProgramacionPagos(ProgramacionPago programacionPagos) {
    this.programacionPagos = programacionPagos;
  }

  public Integer getCostoCredito() {
    return this.costoCredito;
  }

  public void setCostoCredito(Integer costoCredito) {
    this.costoCredito = costoCredito;
  }

  public Integer getCostoTotal() {
    return this.costoTotal;
  }

  public void setCostoTotal(Integer costoTotal) {
    this.costoTotal = costoTotal;
  }

}
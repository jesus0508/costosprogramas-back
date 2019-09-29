package pe.edu.unmsm.sistemas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "programa")
public class Programa {
  @Id
  @Column(name = "id_programa")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "nom_programa")
  private String nombrePrograma;
  @Column(name = "sigla_programa")
  private String siglaPrograma;
  @Column(name = "vigencia_programa")
  private Boolean vigenciaPrograma;
  @Column(name = "n_prioridad")
  private Integer numeroPrioridad;


  public Programa() {
  }

  public Programa(Long id, String nombrePrograma, String siglaPrograma, Boolean vigenciaPrograma, Integer numeroPrioridad) {
    this.id = id;
    this.nombrePrograma = nombrePrograma;
    this.siglaPrograma = siglaPrograma;
    this.vigenciaPrograma = vigenciaPrograma;
    this.numeroPrioridad = numeroPrioridad;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombrePrograma() {
    return this.nombrePrograma;
  }

  public void setNombrePrograma(String nombrePrograma) {
    this.nombrePrograma = nombrePrograma;
  }

  public String getSiglaPrograma() {
    return this.siglaPrograma;
  }

  public void setSiglaPrograma(String siglaPrograma) {
    this.siglaPrograma = siglaPrograma;
  }

  public Boolean isVigenciaPrograma() {
    return this.vigenciaPrograma;
  }

  public Boolean getVigenciaPrograma() {
    return this.vigenciaPrograma;
  }

  public void setVigenciaPrograma(Boolean vigenciaPrograma) {
    this.vigenciaPrograma = vigenciaPrograma;
  }

  public Integer getNumeroPrioridad() {
    return this.numeroPrioridad;
  }

  public void setNumeroPrioridad(Integer numeroPrioridad) {
    this.numeroPrioridad = numeroPrioridad;
  }

}
package pe.edu.unmsm.sistemas.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "programa_ciclo")
public class ProgramaCiclo {
  @Id
  @Column(name = "id_programa_ciclo")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_tip_grado")
  private TipoGrado tipoGrado;
  @Column(name = "ciclo")
  private Integer ciclo;


  public ProgramaCiclo() {
  }

  public ProgramaCiclo(Long id, TipoGrado tipoGrado, Integer ciclo) {
    this.id = id;
    this.tipoGrado = tipoGrado;
    this.ciclo = ciclo;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TipoGrado getTipoGrado() {
    return this.tipoGrado;
  }

  public void setTipoGrado(TipoGrado tipoGrado) {
    this.tipoGrado = tipoGrado;
  }

  public Integer getCiclo() {
    return this.ciclo;
  }

  public void setCiclo(Integer ciclo) {
    this.ciclo = ciclo;
  }

}

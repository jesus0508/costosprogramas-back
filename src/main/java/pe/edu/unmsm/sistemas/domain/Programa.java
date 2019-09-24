package pe.edu.unmsm.sistemas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "programa")
public class Programa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;
  @Column(name = "nom_programa")
  public String nombrePrograma;
  @Column(name = "sigla_programa")
  public String siglaPrograma;
  @Column(name = "vigencia_programa")
  public Boolean vigenciaPrograma;
  @Column(name = "n_prioridad")
  public Integer numeroPrioridad;


}
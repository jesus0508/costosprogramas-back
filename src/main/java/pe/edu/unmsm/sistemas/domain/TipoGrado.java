package pe.edu.unmsm.sistemas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tipo_grado")
public class TipoGrado {
  @Id
  @Column(name = "id_tip_grado")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String id;
  @Column(name = "nom_tip_grado")
  private String nombreTipoGrado;

  public TipoGrado() {
  }

  public TipoGrado(String id, String nombreTipoGrado) {
    this.id = id;
    this.nombreTipoGrado = nombreTipoGrado;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombreTipoGrado() {
    return this.nombreTipoGrado;
  }

  public void setNombreTipoGrado(String nombreTipoGrado) {
    this.nombreTipoGrado = nombreTipoGrado;
  }

}

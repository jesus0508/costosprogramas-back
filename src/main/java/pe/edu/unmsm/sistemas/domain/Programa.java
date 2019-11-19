package pe.edu.unmsm.sistemas.domain;

import javax.persistence.*;

@Entity(name = "programa")
public class Programa {

    @Id
    @Column(name = "id_programa")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short id;
    @Column(name = "nom_programa")
    private String nombrePrograma;
    @Column(name = "sigla_programa")
    private String siglaPrograma;
    @Column(name = "vigencia_programa")
    private Boolean vigenciaPrograma;
    @Column(name = "n_prioridad")
    private Integer numeroPrioridad;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tip_grado")
    private TipoGrado tipoGrado;

    public Programa() {
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNombrePrograma() {
        return nombrePrograma;
    }

    public void setNombrePrograma(String nombrePrograma) {
        this.nombrePrograma = nombrePrograma;
    }

    public String getSiglaPrograma() {
        return siglaPrograma;
    }

    public void setSiglaPrograma(String siglaPrograma) {
        this.siglaPrograma = siglaPrograma;
    }

    public Boolean getVigenciaPrograma() {
        return vigenciaPrograma;
    }

    public void setVigenciaPrograma(Boolean vigenciaPrograma) {
        this.vigenciaPrograma = vigenciaPrograma;
    }

    public Integer getNumeroPrioridad() {
        return numeroPrioridad;
    }

    public void setNumeroPrioridad(Integer numeroPrioridad) {
        this.numeroPrioridad = numeroPrioridad;
    }

    public TipoGrado getTipoGrado() {
        return tipoGrado;
    }

    public void setTipoGrado(TipoGrado tipoGrado) {
        this.tipoGrado = tipoGrado;
    }

}
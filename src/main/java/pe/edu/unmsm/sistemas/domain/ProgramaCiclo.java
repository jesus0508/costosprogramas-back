package pe.edu.unmsm.sistemas.domain;

import javax.persistence.*;

@Entity(name = "programa_ciclo")
public class ProgramaCiclo {
    @Id
    @Column(name = "id_programa_ciclo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tip_grado")
    private TipoGrado tipoGrado;
    @Column(name = "ciclo")
    private Short ciclo;


    public ProgramaCiclo() {
    }

    public ProgramaCiclo(Integer id, TipoGrado tipoGrado, Short ciclo) {
        this.id = id;
        this.tipoGrado = tipoGrado;
        this.ciclo = ciclo;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoGrado getTipoGrado() {
        return this.tipoGrado;
    }

    public void setTipoGrado(TipoGrado tipoGrado) {
        this.tipoGrado = tipoGrado;
    }

    public Short getCiclo() {
        return this.ciclo;
    }

    public void setCiclo(Short ciclo) {
        this.ciclo = ciclo;
    }

}

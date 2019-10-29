package pe.edu.unmsm.sistemas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "concepto")
public class Concepto {
    @Id
    @Column(name = "id_concepto")
    private Integer id;
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "descripcion")
    private String descripcion;

    public Concepto() {
    }

    public Concepto(Integer id, String concepto, String descripcion) {
        this.id = id;
        this.concepto = concepto;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

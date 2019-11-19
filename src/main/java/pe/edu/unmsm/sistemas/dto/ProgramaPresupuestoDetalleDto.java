package pe.edu.unmsm.sistemas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProgramaPresupuestoDetalleDto {

    @JsonProperty("id_programa_presupuesto")
    public Integer id;
    @JsonProperty("id_concepto")
    public Short idConcepto;
    @JsonProperty("id_programa_ciclo")
    public Integer idProgramaCiclo;
    @JsonProperty("creditos")
    public Short credito;
    @JsonProperty("importe")
    public Double importe;
    @JsonProperty("cuotas")
    public Integer cuotas;

    public ProgramaPresupuestoDetalleDto() {

    }

    public ProgramaPresupuestoDetalleDto(Integer id, Short idConcepto, Integer idProgramaCiclo, Short credito, Double importe, Integer cuotas) {
        this.id = id;
        this.idConcepto = idConcepto;
        this.idProgramaCiclo = idProgramaCiclo;
        this.credito = credito;
        this.importe = importe;
        this.cuotas = cuotas;
    }
}

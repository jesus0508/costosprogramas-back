package pe.edu.unmsm.sistemas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


public class ProgramaPresupuestoDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Integer id;
    @JsonProperty("id_programa")
    public Short idPrograma;
    @JsonProperty("id_programacion_pagos")
    public Integer idProgramacionPago;
    @JsonProperty("id_concepto")
    public Short idConcepto;
    @JsonProperty("id_programa_ciclo")
    public Short idProgramaCiclo;
    @JsonProperty("costo_credito")
    public Integer costoCredito;
    @JsonProperty("costo_total")
    public Long costoTotal;
    @JsonProperty("creditos")
    public Short credito;
    @JsonProperty("importe")
    public Double importe;
    @JsonProperty("cuotas")
    public Integer cuotas;

    public ProgramaPresupuestoDto() {
    }

    public ProgramaPresupuestoDto(Integer id, Short idPrograma, Integer idProgramacionPago, Short idConcepto,
                                  Short idProgramaCiclo, Integer costoCredito, Long costoTotal, Short credito,
                                  Double importe, Integer cuotas) {
        this.id = id;
        this.idPrograma = idPrograma;
        this.idProgramacionPago = idProgramacionPago;
        this.idConcepto = idConcepto;
        this.idProgramaCiclo = idProgramaCiclo;
        this.costoCredito = costoCredito;
        this.costoTotal = costoTotal;
        this.credito = credito;
        this.importe = importe;
        this.cuotas = cuotas;
    }

}

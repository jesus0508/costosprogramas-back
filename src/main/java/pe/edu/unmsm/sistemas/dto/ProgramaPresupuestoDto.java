package pe.edu.unmsm.sistemas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProgramaPresupuestoDto {

    @JsonProperty("id_programa")
    public Short idPrograma;
    @JsonProperty("id_programacion_pagos")
    public Integer idProgramacionPago;
    @JsonProperty("costo_credito")
    public Integer costoCredito;
    @JsonProperty("costo_total")
    public Long costoTotal;

    public ProgramaPresupuestoDto() {
    }

    public ProgramaPresupuestoDto(ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto) {
        idPrograma = programaPresupuestoWithDetalleDto.idPrograma;
        idProgramacionPago = programaPresupuestoWithDetalleDto.idProgramacionPago;
        costoCredito = programaPresupuestoWithDetalleDto.costoCredito;
        costoTotal = programaPresupuestoWithDetalleDto.costoTotal;
    }
}

package pe.edu.unmsm.sistemas.service;

import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalleId;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoDetalleDto;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoWithDetalleDto;

import java.util.Set;


public interface ProgramaPresupuestoDetalleService {
    Set<ProgramaPresupuestoDetalle> getAllProgramaPresupuestoDetalle();

    ProgramaPresupuestoDetalle buildProgramaPresupuestoDetalle(
            ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto);

    ProgramaPresupuestoDetalle buildProgramaPresupuestoDetalle(
            ProgramaPresupuestoDetalleDto programaPresupuestoDetalleDto);

    ProgramaPresupuestoDetalle saveProgramPresupuestoDetalle(ProgramaPresupuestoDetalle programaPresupuestoDetalle);

    ProgramaPresupuestoDetalleId deleteProgramaPresupuestoDetalle(ProgramaPresupuestoDetalleId programaPresupuestoDetalleId);

    ProgramaPresupuestoDetalle getProgramaPresupuestoDetalle(ProgramaPresupuestoDetalleId programaPresupuestoDetalleId);

    ProgramaPresupuestoDetalle updateProgramaPresupuestoDetalle(
            ProgramaPresupuestoDetalleId programaPresupuestoDetalleId, ProgramaPresupuestoDetalle programaPresupuestoDetalle);

}

package pe.edu.unmsm.sistemas.service;

import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalleId;

import java.util.Set;

public interface ProgramaPresupuestoDetalleService {
    Set<ProgramaPresupuestoDetalle> getAllProgramaPresupuestoDetalle();

    ProgramaPresupuestoDetalleId create(ProgramaPresupuestoDetalle programaPresupuestoDetalle);
}

package pe.edu.unmsm.sistemas.service;

import pe.edu.unmsm.sistemas.domain.ProgramaPresupuesto;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoWithDetalleDto;

import java.util.List;

public interface ProgramaPresupuestoService {
    List<ProgramaPresupuesto> getAllProgramaPresupuestos();

    ProgramaPresupuesto buildProgramaPresupuesto(ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto);

    ProgramaPresupuesto create(ProgramaPresupuesto programaPresupuesto);

    ProgramaPresupuesto createOrGetProgramPresupuesto(ProgramaPresupuesto programaPresupuesto);
}

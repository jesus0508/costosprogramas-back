package pe.edu.unmsm.sistemas.service;

import pe.edu.unmsm.sistemas.domain.ProgramaPresupuesto;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoDto;

import java.util.List;

public interface ProgramaPresupuestoService {
    List<ProgramaPresupuesto> getAllProgramaPresupuestos();

    ProgramaPresupuesto buildProgramaPresupuesto(ProgramaPresupuestoDto programaPresupuestoDto);

    ProgramaPresupuesto create(ProgramaPresupuesto programaPresupuesto);
}

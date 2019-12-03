package pe.edu.unmsm.sistemas.service;

import pe.edu.unmsm.sistemas.domain.ProgramaPresupuesto;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoDto;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoWithDetalleDto;

import java.util.List;

public interface ProgramaPresupuestoService {
    List<ProgramaPresupuesto> getAllProgramaPresupuestos();

    ProgramaPresupuesto getProgramaPresupuestoByProgramaAndProgramacionPago(Short idPrograma, Integer idProgramacionPago);

    ProgramaPresupuesto getProgramaPresupuesto(Integer id);

    ProgramaPresupuesto buildProgramaPresupuesto(ProgramaPresupuestoDto programaPresupuestoDto);

    ProgramaPresupuesto saveProgramaPresupuesto(ProgramaPresupuesto programaPresupuesto);

    ProgramaPresupuesto createOrGetProgramPresupuesto(ProgramaPresupuestoDto programaPresupuestoDto);

    ProgramaPresupuestoDetalle addProgramaPresupuestoDetalle(Integer id, ProgramaPresupuestoWithDetalleDto programaPresupuestoDetalle);

    ProgramaPresupuesto updateProgramaPresupuesto(ProgramaPresupuesto programaPresupuesto);
}

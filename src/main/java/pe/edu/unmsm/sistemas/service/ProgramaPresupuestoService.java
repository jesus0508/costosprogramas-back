package pe.edu.unmsm.sistemas.service;

import pe.edu.unmsm.sistemas.domain.ProgramaPresupuesto;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoDetalleDto;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoDto;

import java.util.List;

public interface ProgramaPresupuestoService {
    List<ProgramaPresupuesto> getAllProgramaPresupuestos();

    ProgramaPresupuesto getProgramaPresupuestoByProgramaAndProgramacionPago(Short idPrograma, Integer idProgramacionPago);

    ProgramaPresupuesto getProgramaPresupuesto(Integer id);

    ProgramaPresupuesto buildProgramaPresupuesto(ProgramaPresupuestoDto programaPresupuestoDto);

    ProgramaPresupuesto saveProgramaPresupuesto(ProgramaPresupuesto programaPresupuesto);

    ProgramaPresupuestoDetalle addProgramaPresupuestoDetalle(Integer id, ProgramaPresupuestoDetalleDto programaPresupuestoDetalle);

    ProgramaPresupuesto updateProgramaPresupuesto(Integer id, ProgramaPresupuesto programaPresupuesto);

    Integer deleteProgramaPresupuesto(Integer id);
}

package pe.edu.unmsm.sistemas.service;

import pe.edu.unmsm.sistemas.domain.ProgramaPresupuesto;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoWithDetalleDto;

import java.util.List;

public interface ProgramaPresupuestoService {
    List<ProgramaPresupuesto> getAllProgramaPresupuestos();

    ProgramaPresupuesto getProgramaPresupuestoByProgramaAndProgramacionPago(Short idPrograma, Integer idProgramacionPago);

    ProgramaPresupuesto getProgramaPresupuesto(Integer id);

    ProgramaPresupuesto buildProgramaPresupuesto(ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto);

    ProgramaPresupuesto create(ProgramaPresupuesto programaPresupuesto);

    ProgramaPresupuesto createOrGetProgramPresupuesto(ProgramaPresupuesto programaPresupuesto);

    ProgramaPresupuestoDetalle addProgramaPresupuestoDetalle(Integer id, ProgramaPresupuestoWithDetalleDto programaPresupuestoDetalle);
}

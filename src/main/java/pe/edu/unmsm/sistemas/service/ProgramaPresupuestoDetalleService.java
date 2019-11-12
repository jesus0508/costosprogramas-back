package pe.edu.unmsm.sistemas.service;

import org.springframework.stereotype.Service;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoWithDetalleDto;

import java.util.Set;

@Service
public interface ProgramaPresupuestoDetalleService {
    Set<ProgramaPresupuestoDetalle> getAllProgramaPresupuestoDetalle();

    ProgramaPresupuestoDetalle buildProgramaPresupuestoDetalle(ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto);

    ProgramaPresupuestoDetalle create(ProgramaPresupuestoDetalle programaPresupuestoDetalle);
}

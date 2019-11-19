package pe.edu.unmsm.sistemas.service;

import pe.edu.unmsm.sistemas.domain.ProgramacionPago;

import java.util.Set;

public interface ProgramacionPagoService {
    Set<ProgramacionPago> getAllProgramacionPagos();

    ProgramacionPago getProgramacionPagoById(Integer id);
}
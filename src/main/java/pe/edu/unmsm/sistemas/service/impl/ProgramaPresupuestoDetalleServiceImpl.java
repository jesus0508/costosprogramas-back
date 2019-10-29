package pe.edu.unmsm.sistemas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalleId;
import pe.edu.unmsm.sistemas.repository.ProgramaPresupuestoDetalleRepository;
import pe.edu.unmsm.sistemas.service.ProgramaPresupuestoDetalleService;

import java.util.HashSet;
import java.util.Set;

public class ProgramaPresupuestoDetalleServiceImpl implements ProgramaPresupuestoDetalleService {

    @Autowired
    ProgramaPresupuestoDetalleRepository programaPresupuestoDetalleRepository;

    @Override
    public Set<ProgramaPresupuestoDetalle> getAllProgramaPresupuestoDetalle() {
        Set<ProgramaPresupuestoDetalle> programaPresupuestoDetalles = new HashSet<>();
        programaPresupuestoDetalleRepository.findAll().forEach(programaPresupuestoDetalle -> programaPresupuestoDetalles.add(programaPresupuestoDetalle));
        return programaPresupuestoDetalles;
    }

    @Override
    public ProgramaPresupuestoDetalleId create(ProgramaPresupuestoDetalle programaPresupuestoDetalle) {
        return null;
    }
}

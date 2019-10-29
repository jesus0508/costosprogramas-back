package pe.edu.unmsm.sistemas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.sistemas.domain.ProgramacionPago;
import pe.edu.unmsm.sistemas.repository.ProgramacionPagoRepository;
import pe.edu.unmsm.sistemas.service.ProgramacionPagoService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProgramacionPagoServiceImpl implements ProgramacionPagoService {

    @Autowired
    ProgramacionPagoRepository programacionPagoRepository;

    @Override
    public Set<ProgramacionPago> getAllProgramacionPagos() {
        Set<ProgramacionPago> programacionPagos = new HashSet<>();
        programacionPagoRepository.findAll().forEach(programacionPago -> programacionPagos.add(programacionPago));
        return programacionPagos;
    }

}
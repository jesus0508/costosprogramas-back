package pe.edu.unmsm.sistemas.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.sistemas.domain.ProgramacionPago;
import pe.edu.unmsm.sistemas.repository.ProgramacionPagoRepository;
import pe.edu.unmsm.sistemas.service.ProgramacionPagoService;

@Service
public class ProgramacionPagoServiceImpl implements ProgramacionPagoService {

  @Autowired
  ProgramacionPagoRepository programacionPagoRepository;

  @Override
  public Set<ProgramacionPago> getAllProgramacionPagos() {
    Set<ProgramacionPago> setProgramacionPagos = new HashSet<>();
    programacionPagoRepository.findAll().forEach(programacionPago -> setProgramacionPagos.add(programacionPago));
    return setProgramacionPagos;
  }

}
package pe.edu.unmsm.sistemas.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.sistemas.domain.ProgramaCiclo;
import pe.edu.unmsm.sistemas.repository.ProgramaCicloRepository;
import pe.edu.unmsm.sistemas.service.ProgramaCicloService;

@Service
public class ProgramaCicloImpl implements ProgramaCicloService {

  @Autowired
  ProgramaCicloRepository programaCicloRepository;

  @Override
  public Set<ProgramaCiclo> getAllProgramaCiclos() {
    Set<ProgramaCiclo> setProgramaCiclos = new HashSet<>();
    programaCicloRepository.findAll().forEach(programaCiclo -> setProgramaCiclos.add(programaCiclo));
    return setProgramaCiclos;
  }

  @Override
  public ProgramaCiclo getProgramaCicloById(Long id) {
    return programaCicloRepository.findById(id).orElseThrow(() -> new RuntimeException());
  }

  @Override
  public Set<ProgramaCiclo> getAllProgramaCicloByTipoPago(String id) {
    Set<ProgramaCiclo> setProgramaCiclos = new HashSet<>();
    programaCicloRepository.findAllByTipoGradoId(id).forEach(programaCiclo -> setProgramaCiclos.add(programaCiclo));
    return setProgramaCiclos;
  }

}
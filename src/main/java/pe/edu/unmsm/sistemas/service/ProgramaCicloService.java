package pe.edu.unmsm.sistemas.service;

import java.util.Set;

import pe.edu.unmsm.sistemas.domain.ProgramaCiclo;

public interface ProgramaCicloService {
  public Set<ProgramaCiclo> getAllProgramaCiclos();

  public ProgramaCiclo getProgramaCicloById(Long id);

  public Set<ProgramaCiclo> getAllProgramaCicloByTipoPago(String id);
}
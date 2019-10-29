package pe.edu.unmsm.sistemas.service;

import pe.edu.unmsm.sistemas.domain.ProgramaCiclo;

import java.util.List;
import java.util.Set;

public interface ProgramaCicloService {
    Set<ProgramaCiclo> getAllProgramaCiclos();

    ProgramaCiclo getProgramaCicloById(Integer id);

    List<ProgramaCiclo> getAllProgramaCicloByTipoPago(String id);
}
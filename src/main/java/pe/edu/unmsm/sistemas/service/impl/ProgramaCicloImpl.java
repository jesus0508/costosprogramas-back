package pe.edu.unmsm.sistemas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.sistemas.domain.ProgramaCiclo;
import pe.edu.unmsm.sistemas.repository.ProgramaCicloRepository;
import pe.edu.unmsm.sistemas.service.ProgramaCicloService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProgramaCicloImpl implements ProgramaCicloService {

    @Autowired
    ProgramaCicloRepository programaCicloRepository;

    @Override
    public Set<ProgramaCiclo> getAllProgramaCiclos() {
        Set<ProgramaCiclo> programaCiclos = new HashSet<>();
        programaCicloRepository.findAll().forEach(programaCiclo -> programaCiclos.add(programaCiclo));
        return programaCiclos;
    }

    @Override
    public ProgramaCiclo getProgramaCicloById(Integer id) {
        return programaCicloRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public List<ProgramaCiclo> getAllProgramaCicloByTipoPago(String id) {
        List<ProgramaCiclo> programaCiclos = new ArrayList<>();
        programaCicloRepository.findAllByTipoGradoId(id).forEach(programaCiclo -> programaCiclos.add(programaCiclo));
        return programaCiclos;
    }

}
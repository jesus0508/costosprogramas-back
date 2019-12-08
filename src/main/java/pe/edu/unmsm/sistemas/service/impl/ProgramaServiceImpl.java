package pe.edu.unmsm.sistemas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.sistemas.domain.Programa;
import pe.edu.unmsm.sistemas.repository.ProgramaRepository;
import pe.edu.unmsm.sistemas.service.ProgramaService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProgramaServiceImpl implements ProgramaService {

    @Autowired
    ProgramaRepository programaRepository;

    public Set<Programa> getAllProgramas() {
        Set<Programa> programas = new HashSet<>();
        programaRepository.findAll().forEach(programa -> programas.add(programa));
        return programas;
    }

    @Override
    public Programa getProgramaById(Short id) {
        return programaRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
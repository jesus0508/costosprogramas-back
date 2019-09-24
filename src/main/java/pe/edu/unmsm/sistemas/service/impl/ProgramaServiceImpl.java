package pe.edu.unmsm.sistemas.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.unmsm.sistemas.domain.Programa;
import pe.edu.unmsm.sistemas.repository.ProgramaRepository;
import pe.edu.unmsm.sistemas.service.ProgramaService;

@Service
public class ProgramaServiceImpl implements ProgramaService {

  @Autowired
  ProgramaRepository programaRepository;

  public Set<Programa> getAllProgramas() {
    Set<Programa> setProgramas = new HashSet<>();
    programaRepository.findAll().forEach(programa -> setProgramas.add(programa));
    return setProgramas;
  }
}
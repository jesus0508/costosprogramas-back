package pe.edu.unmsm.sistemas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.sistemas.domain.Concepto;
import pe.edu.unmsm.sistemas.repository.ConceptoRepository;
import pe.edu.unmsm.sistemas.service.ConceptoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConceptoServiceImpl implements ConceptoService {

    @Autowired
    ConceptoRepository conceptoRepository;

    @Override
    public List<Concepto> getAllConceptos() {
        ArrayList<Concepto> conceptos = new ArrayList<>();
        conceptoRepository.findAll().forEach(concepto -> conceptos.add(concepto));
        return conceptos;
    }

    //9-21-62-117
    @Override
    public List<Concepto> getAllConceptosPresupuesto(List<Short> conceptosId) {
        ArrayList<Concepto> conceptos = new ArrayList<>();
        conceptoRepository.findByIdIn(conceptosId).forEach(concepto -> conceptos.add(concepto));
        return conceptos;
    }
}

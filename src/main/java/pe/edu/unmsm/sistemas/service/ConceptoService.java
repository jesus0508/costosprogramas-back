package pe.edu.unmsm.sistemas.service;

import pe.edu.unmsm.sistemas.domain.Concepto;

import java.util.List;


public interface ConceptoService {
    List<Concepto> getAllConceptos();
    List<Concepto> getAllConceptosPresupuesto(List<Integer> conceptosId);
}

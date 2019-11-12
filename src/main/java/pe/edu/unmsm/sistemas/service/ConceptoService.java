package pe.edu.unmsm.sistemas.service;

import pe.edu.unmsm.sistemas.domain.Concepto;

import java.util.List;


public interface ConceptoService {
    List<Concepto> getAllConceptos();

    Concepto getConceptoById(Short id);

    List<Concepto> getAllConceptosPresupuesto(List<Short> conceptosId);
}

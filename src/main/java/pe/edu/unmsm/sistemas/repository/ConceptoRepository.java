package pe.edu.unmsm.sistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unmsm.sistemas.domain.Concepto;

import java.util.List;

public interface ConceptoRepository extends JpaRepository<Concepto, Short> {
    List<Concepto> findByIdIn(List<Short> conceptoIds);
}

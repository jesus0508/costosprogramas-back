package pe.edu.unmsm.sistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unmsm.sistemas.domain.ProgramaCiclo;

import java.util.Set;

public interface ProgramaCicloRepository extends JpaRepository<ProgramaCiclo, Integer> {
    Set<ProgramaCiclo> findAllByTipoGradoId(String id);

}
package pe.edu.unmsm.sistemas.repository;

import pe.edu.unmsm.sistemas.domain.ProgramaCiclo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramaCicloRepository extends JpaRepository<ProgramaCiclo, Long> {
  public Set<ProgramaCiclo> findAllByTipoGradoId(String id);

}
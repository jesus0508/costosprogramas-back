package pe.edu.unmsm.sistemas.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.unmsm.sistemas.domain.Programa;

public interface ProgramaRepository extends CrudRepository<Programa, Short> {

}
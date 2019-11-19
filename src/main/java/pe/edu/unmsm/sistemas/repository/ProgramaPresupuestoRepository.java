package pe.edu.unmsm.sistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuesto;

public interface ProgramaPresupuestoRepository extends JpaRepository<ProgramaPresupuesto, Integer> {
    ProgramaPresupuesto findByProgramaIdAndProgramacionPagoId(Short idPrograma, Integer idProgramacionPago);
}

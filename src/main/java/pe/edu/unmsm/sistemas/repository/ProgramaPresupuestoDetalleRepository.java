package pe.edu.unmsm.sistemas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalleId;

public interface ProgramaPresupuestoDetalleRepository extends JpaRepository<ProgramaPresupuestoDetalle, ProgramaPresupuestoDetalleId> {
}

package pe.edu.unmsm.sistemas.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.sistemas.domain.Programa;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuesto;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.domain.ProgramacionPago;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoWithDetalleDto;
import pe.edu.unmsm.sistemas.repository.ProgramaPresupuestoRepository;
import pe.edu.unmsm.sistemas.service.ProgramaPresupuestoDetalleService;
import pe.edu.unmsm.sistemas.service.ProgramaPresupuestoService;
import pe.edu.unmsm.sistemas.service.ProgramaService;
import pe.edu.unmsm.sistemas.service.ProgramacionPagoService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramaPresupuestoImpl implements ProgramaPresupuestoService {

    private static final Logger logger = LoggerFactory.getLogger(ProgramaPresupuestoService.class);

    @Autowired
    ProgramaPresupuestoRepository programaPresupuestoRepository;
    @Autowired
    ProgramaService programaService;
    @Autowired
    ProgramacionPagoService programacionPagoService;
    @Autowired
    ProgramaPresupuestoDetalleService programaPresupuestoDetalleService;

    @Override
    public List<ProgramaPresupuesto> getAllProgramaPresupuestos() {
        List<ProgramaPresupuesto> programaPresupuestos = new LinkedList<>();
        programaPresupuestoRepository.findAll().forEach(programaPresupuesto -> programaPresupuestos.add(programaPresupuesto));
        return programaPresupuestos;
    }

    @Override
    public ProgramaPresupuesto getProgramaPresupuestoByProgramaAndProgramacionPago(Short idPrograma, Integer idProgramacionPago) {
        return programaPresupuestoRepository.findByProgramaIdAndProgramacionPagoId(idPrograma, idProgramacionPago);
    }

    @Override
    public ProgramaPresupuesto getProgramaPresupuesto(Integer id) {
        logger.info("Id Programa Presupuesto " + id);
        return programaPresupuestoRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public ProgramaPresupuesto buildProgramaPresupuesto(ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto) {
        Programa programa = programaService.getProgramaById(programaPresupuestoWithDetalleDto.idPrograma);
        ProgramacionPago programacionPago = programacionPagoService.getProgramacionPagoById(programaPresupuestoWithDetalleDto.idProgramacionPago);
        ProgramaPresupuesto programaPresupuesto = new ProgramaPresupuesto();
        programaPresupuesto.setPrograma(programa);
        programaPresupuesto.setProgramacionPago(programacionPago);
        programaPresupuesto.setCostoCredito(programaPresupuestoWithDetalleDto.costoCredito);
        programaPresupuesto.setCostoTotal(programaPresupuestoWithDetalleDto.costoTotal);
        return programaPresupuesto;
    }

    @Override
    public ProgramaPresupuesto create(ProgramaPresupuesto programaPresupuesto) {
        return programaPresupuestoRepository.save(programaPresupuesto);
    }

    @Override
    public ProgramaPresupuesto createOrGetProgramPresupuesto(ProgramaPresupuesto programaPresupuesto) {
        Optional<ProgramaPresupuesto> programaPresupuestoOptional = programaPresupuestoRepository.findById(programaPresupuesto.getId());
        if (programaPresupuestoOptional.isPresent()) {
            return programaPresupuestoOptional.get();
        } else {
            return programaPresupuestoRepository.save(programaPresupuesto);
        }
    }

    @Override
    public ProgramaPresupuesto addProgramaPresupuestoDetalle(
            Integer id, ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto) {

        ProgramaPresupuesto programaPresupuesto = getProgramaPresupuesto(id);
        ProgramaPresupuestoDetalle programaPresupuestoDetalle = programaPresupuestoDetalleService.buildProgramaPresupuestoDetalle(programaPresupuestoWithDetalleDto);
        programaPresupuestoDetalle.setProgramaPresupuesto(programaPresupuesto);
        programaPresupuesto.getProgramaPresupuestoDetalles().add(programaPresupuestoDetalle);
        Long costoTotal = programaPresupuesto.getCostoTotal() + programaPresupuestoDetalle.getImporte().longValue();
        programaPresupuesto.setCostoTotal(costoTotal);
        logger.info("Programa Presupuesto= " + programaPresupuesto);
        return programaPresupuestoRepository.save(programaPresupuesto);
    }


}

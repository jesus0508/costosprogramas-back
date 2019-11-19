package pe.edu.unmsm.sistemas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.sistemas.domain.*;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoWithDetalleDto;
import pe.edu.unmsm.sistemas.repository.ProgramaPresupuestoDetalleRepository;
import pe.edu.unmsm.sistemas.service.ConceptoService;
import pe.edu.unmsm.sistemas.service.ProgramaCicloService;
import pe.edu.unmsm.sistemas.service.ProgramaPresupuestoDetalleService;
import pe.edu.unmsm.sistemas.service.ProgramaPresupuestoService;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProgramaPresupuestoDetalleServiceImpl implements ProgramaPresupuestoDetalleService {

    @Autowired
    ProgramaPresupuestoDetalleRepository programaPresupuestoDetalleRepository;

    @Autowired
    ConceptoService conceptoService;

    @Autowired
    ProgramaCicloService programaCicloService;

    @Autowired
    ProgramaPresupuestoService programaPresupuestoService;

    @Override
    public Set<ProgramaPresupuestoDetalle> getAllProgramaPresupuestoDetalle() {
        Set<ProgramaPresupuestoDetalle> programaPresupuestoDetalles = new HashSet<>();
        programaPresupuestoDetalleRepository.findAll().forEach(programaPresupuestoDetalle -> programaPresupuestoDetalles.add(programaPresupuestoDetalle));
        return programaPresupuestoDetalles;
    }

    @Override
    public ProgramaPresupuestoDetalle buildProgramaPresupuestoDetalle(ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto) {

        ProgramaPresupuesto programaPresupuesto = programaPresupuestoService.buildProgramaPresupuesto(programaPresupuestoWithDetalleDto);
        Concepto concepto = conceptoService.getConceptoById(programaPresupuestoWithDetalleDto.idConcepto);
        ProgramaCiclo programaCiclo = programaCicloService.getProgramaCicloById(programaPresupuestoWithDetalleDto.idProgramaCiclo);

        ProgramaPresupuestoDetalle programaPresupuestoDetalle = new ProgramaPresupuestoDetalle();
        programaPresupuestoDetalle.setProgramaPresupuesto(programaPresupuesto);
        programaPresupuestoDetalle.setConcepto(concepto);
        programaPresupuestoDetalle.setProgramaCiclo(programaCiclo);
        programaPresupuestoDetalle.setCredito(programaPresupuestoWithDetalleDto.credito);
        programaPresupuestoDetalle.setCuotas(programaPresupuestoWithDetalleDto.cuotas);
        programaPresupuestoDetalle.setImporte(programaPresupuestoWithDetalleDto.importe);
        return programaPresupuestoDetalle;
    }

    @Override
    public ProgramaPresupuestoDetalle saveProgramPresupuestoDetalle(ProgramaPresupuestoDetalle programaPresupuestoDetalle) {
        return programaPresupuestoDetalleRepository.save(programaPresupuestoDetalle);
    }

    @Override
    public ProgramaPresupuestoDetalleId deleteProgramaPresupuestoDetalle(ProgramaPresupuestoDetalleId programaPresupuestoDetalleId) {
        programaPresupuestoDetalleRepository.deleteById(programaPresupuestoDetalleId);
        return programaPresupuestoDetalleId;
    }
}

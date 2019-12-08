package pe.edu.unmsm.sistemas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.sistemas.domain.*;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoDetalleDto;
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
    public ProgramaPresupuestoDetalle buildProgramaPresupuestoDetalle(
            ProgramaPresupuestoDetalleDto programaPresupuestoDetalleDto) {

        Concepto concepto = conceptoService.getConceptoById(programaPresupuestoDetalleDto.idConcepto);
        ProgramaCiclo programaCiclo = programaCicloService.getProgramaCicloById(programaPresupuestoDetalleDto.idProgramaCiclo);

        ProgramaPresupuestoDetalle programaPresupuestoDetalle = new ProgramaPresupuestoDetalle();
        programaPresupuestoDetalle.setConcepto(concepto);
        programaPresupuestoDetalle.setProgramaCiclo(programaCiclo);
        programaPresupuestoDetalle.setCredito(programaPresupuestoDetalleDto.credito);
        programaPresupuestoDetalle.setCuotas(programaPresupuestoDetalleDto.cuotas);
        programaPresupuestoDetalle.setImporte(programaPresupuestoDetalleDto.importe);
        return programaPresupuestoDetalle;
    }

    @Override
    public ProgramaPresupuestoDetalle buildProgramaPresupuestoDetalle(
            ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto) {

        Concepto concepto = conceptoService.getConceptoById(programaPresupuestoWithDetalleDto.idConcepto);
        ProgramaCiclo programaCiclo = programaCicloService.getProgramaCicloById(programaPresupuestoWithDetalleDto.idProgramaCiclo);
        ProgramaPresupuesto programaPresupuesto = programaPresupuestoService.getProgramaPresupuesto(programaPresupuestoWithDetalleDto.id);

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
        programaPresupuestoDetalle.getProgramaPresupuesto().calcularCostoTotal(programaPresupuestoDetalle.getImporte().longValue());
        return programaPresupuestoDetalleRepository.save(programaPresupuestoDetalle);
    }

    @Override
    public ProgramaPresupuestoDetalleId deleteProgramaPresupuestoDetalle(ProgramaPresupuestoDetalleId programaPresupuestoDetalleId) {
        ProgramaPresupuestoDetalle programaPresupuestoDetalle = getProgramaPresupuestoDetalle(programaPresupuestoDetalleId);
        ProgramaPresupuesto programaPresupuesto = programaPresupuestoDetalle.getProgramaPresupuesto();
        programaPresupuesto.getProgramaPresupuestoDetalles().remove(programaPresupuestoDetalle);
        programaPresupuesto.calcularCostoTotal(programaPresupuestoDetalle.getImporte().longValue() * (-1));
        programaPresupuestoService.saveProgramaPresupuesto(programaPresupuesto);
        programaPresupuestoDetalleRepository.delete(programaPresupuestoDetalle);
        return programaPresupuestoDetalleId;
    }

    @Override
    public ProgramaPresupuestoDetalle getProgramaPresupuestoDetalle(ProgramaPresupuestoDetalleId programaPresupuestoDetalleId) {
        return programaPresupuestoDetalleRepository.findById(programaPresupuestoDetalleId).orElseThrow(RuntimeException::new);
    }

    @Override
    public ProgramaPresupuestoDetalle updateProgramaPresupuestoDetalle(
            ProgramaPresupuestoDetalleId programaPresupuestoDetalleId, ProgramaPresupuestoDetalle newProgramaPresupuestoDetalle) {

        ProgramaPresupuestoDetalle programaPresupuestoDetalle = getProgramaPresupuestoDetalle(programaPresupuestoDetalleId);
        programaPresupuestoDetalle.setCredito(newProgramaPresupuestoDetalle.getCredito());
        programaPresupuestoDetalle.setCuotas(newProgramaPresupuestoDetalle.getCuotas());
        ProgramaPresupuesto programaPresupuesto = programaPresupuestoDetalle.getProgramaPresupuesto();

        Double importe = programaPresupuestoDetalle.getImporte();
        Double newImporte;

        if (programaPresupuestoDetalle.getCredito() > 0) {
            newImporte = programaPresupuestoDetalle.calcularImporte(programaPresupuesto.getCostoCredito());
        } else {
            newImporte = newProgramaPresupuestoDetalle.getImporte();
        }
        programaPresupuestoDetalle.setImporte(newImporte);
        programaPresupuesto.calcularCostoTotal(newImporte.longValue() - importe.longValue());

        programaPresupuestoService.saveProgramaPresupuesto(programaPresupuesto);
        return programaPresupuestoDetalle;
    }

}

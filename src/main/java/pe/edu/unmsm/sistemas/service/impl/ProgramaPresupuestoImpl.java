package pe.edu.unmsm.sistemas.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.unmsm.sistemas.domain.Programa;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuesto;
import pe.edu.unmsm.sistemas.domain.ProgramacionPago;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoDto;
import pe.edu.unmsm.sistemas.repository.ProgramaPresupuestoRepository;
import pe.edu.unmsm.sistemas.service.ProgramaPresupuestoService;
import pe.edu.unmsm.sistemas.service.ProgramaService;
import pe.edu.unmsm.sistemas.service.ProgramacionPagoService;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProgramaPresupuestoImpl implements ProgramaPresupuestoService {
    @Autowired
    ProgramaPresupuestoRepository programaPresupuestoRepository;
    @Autowired
    ProgramaService programaService;
    @Autowired
    ProgramacionPagoService programacionPagoService;
    @Override
    public List<ProgramaPresupuesto> getAllProgramaPresupuestos() {
        List<ProgramaPresupuesto> programaPresupuestos = new LinkedList<>();
        programaPresupuestoRepository.findAll().forEach(programaPresupuesto -> programaPresupuestos.add(programaPresupuesto));
        return programaPresupuestos;
    }

    @Override
    public ProgramaPresupuesto buildProgramaPresupuesto(ProgramaPresupuestoDto programaPresupuestoDto) {
        Programa programa = programaService.getProgramaById(programaPresupuestoDto.idPrograma);
        ProgramacionPago programacionPago = programacionPagoService.getProgramacionPagoById(programaPresupuestoDto.idProgramacionPago);
        ProgramaPresupuesto programaPresupuesto = new ProgramaPresupuesto();
        programaPresupuesto.setPrograma(programa);
        programaPresupuesto.setProgramacionPago(programacionPago);
        programaPresupuesto.setCostoCredito(programaPresupuestoDto.costoCredito);
        programaPresupuesto.setCostoTotal(programaPresupuestoDto.costoTotal);
        return programaPresupuesto;
    }

    @Override
    public ProgramaPresupuesto create(ProgramaPresupuesto programaPresupuesto) {
        return programaPresupuestoRepository.save(programaPresupuesto);
    }
}

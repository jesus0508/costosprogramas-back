package pe.edu.unmsm.sistemas.service.impl;

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
    public ProgramaPresupuesto buildProgramaPresupuesto(ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto) {
        Programa programa = programaService.getProgramaById(programaPresupuestoWithDetalleDto.idPrograma);
        ProgramacionPago programacionPago = programacionPagoService.getProgramacionPagoById(programaPresupuestoWithDetalleDto.idProgramacionPago);
        ProgramaPresupuesto programaPresupuesto = new ProgramaPresupuesto();
        programaPresupuesto.setId(programaPresupuestoWithDetalleDto.id);
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
    public ProgramaPresupuesto createOrGetProgramPresupuesto(ProgramaPresupuesto programaPresupuesto){
        Optional<ProgramaPresupuesto> programaPresupuestoOptional = programaPresupuestoRepository.findById(programaPresupuesto.getId());
        if(programaPresupuestoOptional.isPresent()){
            return programaPresupuestoOptional.get();
        }else{
            return programaPresupuestoRepository.save(programaPresupuesto);
        }
    }


}

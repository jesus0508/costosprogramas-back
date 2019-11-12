package pe.edu.unmsm.sistemas.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuesto;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoWithDetalleDto;
import pe.edu.unmsm.sistemas.service.ProgramaPresupuestoDetalleService;
import pe.edu.unmsm.sistemas.service.ProgramaPresupuestoService;

import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "Programa Presupuesto")
@RequestMapping("/presupuestos")
public class ProgramaPresupuestoController {
    @Autowired
    ProgramaPresupuestoService programaPresupuestoService;

    @Autowired
    ProgramaPresupuestoDetalleService programaPresupuestoDetalleService;

    @GetMapping
    public ResponseEntity<List<ProgramaPresupuesto>> getAllProgramasPresupuesto() {
        List<ProgramaPresupuesto> programaPresupuestos = programaPresupuestoService.getAllProgramaPresupuestos();
        return new ResponseEntity<>(programaPresupuestos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProgramaPresupuesto> createProgramaPresupuesto(@RequestBody ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto) {
        ProgramaPresupuesto programaPresupuesto = programaPresupuestoService.buildProgramaPresupuesto(programaPresupuestoWithDetalleDto);
        programaPresupuesto = programaPresupuestoService.createOrGetProgramPresupuesto(programaPresupuesto);
        ProgramaPresupuestoDetalle programaPresupuestoDetalle = programaPresupuestoDetalleService.buildProgramaPresupuestoDetalle(programaPresupuestoWithDetalleDto);
        programaPresupuesto.getProgramaPresupuestoDetalles().add(programaPresupuestoDetalle);
        return new ResponseEntity<>(programaPresupuesto, HttpStatus.OK);
    }
}

package pe.edu.unmsm.sistemas.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuesto;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoDto;
import pe.edu.unmsm.sistemas.service.ProgramaPresupuestoService;

import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "Programa Presupuesto")
@RequestMapping("/presupuestos")
public class ProgramaPresupuestoController {
    @Autowired
    ProgramaPresupuestoService programaPresupuestoService;

    @GetMapping
    public ResponseEntity<List<ProgramaPresupuesto>> getAllProgramasPresupuesto() {
        List<ProgramaPresupuesto> programaPresupuestos = programaPresupuestoService.getAllProgramaPresupuestos();
        return new ResponseEntity<>(programaPresupuestos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProgramaPresupuesto> createProgramaPresupuesto(@RequestBody ProgramaPresupuestoDto programaPresupuestoDto) {
        ProgramaPresupuesto programaPresupuesto = programaPresupuestoService.buildProgramaPresupuesto(programaPresupuestoDto);
        programaPresupuesto = programaPresupuestoService.create(programaPresupuesto);
        return new ResponseEntity<>(programaPresupuesto, HttpStatus.CREATED);
    }
}

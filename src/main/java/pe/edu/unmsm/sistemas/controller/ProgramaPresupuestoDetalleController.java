package pe.edu.unmsm.sistemas.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalleId;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoWithDetalleDto;
import pe.edu.unmsm.sistemas.service.ProgramaPresupuestoDetalleService;


@RestController
@CrossOrigin
@Api(tags = "Programa Presupuesto Detalle")
@RequestMapping("programa-presupuesto-detalle")
public class ProgramaPresupuestoDetalleController {

    @Autowired
    ProgramaPresupuestoDetalleService programaPresupuestoDetalleService;

    @PostMapping
    public ResponseEntity<ProgramaPresupuestoDetalle> createProgramaPresupuestoDetalle(
            @RequestBody ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto) {

        ProgramaPresupuestoDetalle programaPresupuestoDetalle = programaPresupuestoDetalleService.buildProgramaPresupuestoDetalle(programaPresupuestoWithDetalleDto);
        programaPresupuestoDetalle = programaPresupuestoDetalleService.saveProgramPresupuestoDetalle(programaPresupuestoDetalle);
        return new ResponseEntity<>(programaPresupuestoDetalle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaPresupuestoDetalle> updateProgramaPresupuestoDetalle(
            @RequestBody ProgramaPresupuestoDetalle programaPresupuestoDetalle) {

        programaPresupuestoDetalle = programaPresupuestoDetalleService.saveProgramPresupuestoDetalle(programaPresupuestoDetalle);
        return new ResponseEntity<>(programaPresupuestoDetalle, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProgramaPresupuestoDetalleId> deleteProgramaPresupuestoDetalle(
            @RequestBody ProgramaPresupuestoDetalleId programaPresupuestoDetalleId) {
        programaPresupuestoDetalleId = programaPresupuestoDetalleService.deleteProgramaPresupuestoDetalle(programaPresupuestoDetalleId);
        return new ResponseEntity<>(programaPresupuestoDetalleId, HttpStatus.OK);

    }
}

package pe.edu.unmsm.sistemas.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuesto;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoDetalleDto;
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

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,
            params = {"idPrograma", "idProgramacionPago"})
    public ResponseEntity<ProgramaPresupuesto> getProgramaPresupuestoByProgramaAndProgramacionPago(
            @RequestParam("idPrograma") Short idPrograma,
            @RequestParam("idProgramacionPago") Integer idProgramacionPago) {

        ProgramaPresupuesto programaPresupuestos = programaPresupuestoService.getProgramaPresupuestoByProgramaAndProgramacionPago(idPrograma, idProgramacionPago);
        return new ResponseEntity<>(programaPresupuestos, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProgramaPresupuesto>> getAllProgramasPresupuesto() {
        List<ProgramaPresupuesto> programaPresupuestos = programaPresupuestoService.getAllProgramaPresupuestos();
        return new ResponseEntity<>(programaPresupuestos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ProgramaPresupuesto> getProgramaPresupuesto(@PathVariable Integer id){
        ProgramaPresupuesto programaPresupuesto = programaPresupuestoService.getProgramaPresupuesto(id);
        return new ResponseEntity<>(programaPresupuesto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProgramaPresupuesto> createProgramaPresupuesto(
            @RequestBody ProgramaPresupuestoDto programaPresupuestoDto) {
        ProgramaPresupuesto programaPresupuesto = programaPresupuestoService.buildProgramaPresupuesto(programaPresupuestoDto);
        programaPresupuesto = programaPresupuestoService.saveProgramaPresupuesto(programaPresupuesto);
        return new ResponseEntity<>(programaPresupuesto, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/detalle")
    public ResponseEntity<ProgramaPresupuestoDetalle> addProgramaPresupuestoDetalle(
            @PathVariable Integer id,
            @RequestBody ProgramaPresupuestoDetalleDto programaPresupuestoDetalleDto) {

        ProgramaPresupuestoDetalle programaPresupuestoDetalle = programaPresupuestoService.addProgramaPresupuestoDetalle(id, programaPresupuestoDetalleDto);
        return new ResponseEntity<>(programaPresupuestoDetalle, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProgramaPresupuesto> updateProgramaPresupuesto(
            @PathVariable Integer id, @RequestBody ProgramaPresupuestoDto programaPresupuestoDto) {
        ProgramaPresupuesto programaPresupuesto = programaPresupuestoService.buildProgramaPresupuesto(programaPresupuestoDto);
        programaPresupuesto = programaPresupuestoService.updateProgramaPresupuesto(id, programaPresupuesto);
        return new ResponseEntity<>(programaPresupuesto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteProgramaPresupuesto(@PathVariable Integer id){
        Integer deleted = programaPresupuestoService.deleteProgramaPresupuesto(id);
        return new ResponseEntity<>(deleted, HttpStatus.OK);
    }
}

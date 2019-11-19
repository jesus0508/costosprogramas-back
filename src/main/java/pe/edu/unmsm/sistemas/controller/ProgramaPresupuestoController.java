package pe.edu.unmsm.sistemas.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuesto;
import pe.edu.unmsm.sistemas.domain.ProgramaPresupuestoDetalle;
import pe.edu.unmsm.sistemas.dto.ProgramaPresupuestoWithDetalleDto;
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

    @PostMapping
    public ResponseEntity<ProgramaPresupuesto> createProgramaPresupuesto(
            @RequestBody ProgramaPresupuesto programaPresupuesto) {

        programaPresupuesto = programaPresupuestoService.createOrGetProgramPresupuesto(programaPresupuesto);
        return new ResponseEntity<>(programaPresupuesto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/detalle")
    public ResponseEntity<ProgramaPresupuestoDetalle> addProgramaPresupuestoDetalle(
            @PathVariable Integer id,
            @RequestBody ProgramaPresupuestoWithDetalleDto programaPresupuestoWithDetalleDto) {

        ProgramaPresupuestoDetalle programaPresupuesto = programaPresupuestoService.addProgramaPresupuestoDetalle(id, programaPresupuestoWithDetalleDto);
        return new ResponseEntity<>(programaPresupuesto, HttpStatus.CREATED);
    }
}

package pe.edu.unmsm.sistemas.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.sistemas.domain.ProgramaCiclo;
import pe.edu.unmsm.sistemas.service.ProgramaCicloService;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@Api(tags = "Programa Ciclos")
@RequestMapping("/programa-ciclos")
public class ProgramaCicloController {

    @Autowired
    ProgramaCicloService programaCicloService;

    @GetMapping
    public ResponseEntity<Set<ProgramaCiclo>> getAllProgramaCiclos() {
        Set<ProgramaCiclo> programaCiclos = programaCicloService.getAllProgramaCiclos();
        return new ResponseEntity<>(programaCiclos, HttpStatus.OK);
    }

    @GetMapping("/{tipo-grado}")
    public ResponseEntity<List<ProgramaCiclo>> getProgramaCiclo(@PathVariable(name = "tipo-grado") String tipoGrado) {
        List<ProgramaCiclo> programaCiclos = programaCicloService.getAllProgramaCicloByTipoPago(tipoGrado);
        return new ResponseEntity<>(programaCiclos, HttpStatus.OK);
    }
}
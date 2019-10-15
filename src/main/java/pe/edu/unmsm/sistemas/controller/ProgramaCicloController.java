package pe.edu.unmsm.sistemas.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pe.edu.unmsm.sistemas.domain.ProgramaCiclo;
import pe.edu.unmsm.sistemas.service.ProgramaCicloService;

@CrossOrigin
@RestController
@Api(tags = "Programa Ciclos")
@RequestMapping("/programa_ciclos")
public class ProgramaCicloController {

  @Autowired
  ProgramaCicloService programaCicloService;

  @GetMapping
  public ResponseEntity<Set<ProgramaCiclo>> getAllProgramaCiclos() {
    Set<ProgramaCiclo> setProgramaCiclos = programaCicloService.getAllProgramaCiclos();
    return new ResponseEntity<>(setProgramaCiclos, HttpStatus.OK);
  }

  // @GetMapping("/{id}")
  // public ResponseEntity<ProgramaCiclo> getProgramaCiclo(@PathVariable Long id){
  // ProgramaCiclo programaCiclo=programaCicloService.getProgramaCicloById(id);
  // return new ResponseEntity<>(programaCiclo,HttpStatus.OK);
  // }

  @GetMapping("/{tipo_pago}")
  public ResponseEntity<Set<ProgramaCiclo>> getProgramaCiclo(@PathVariable String tipo_pago) {
    Set<ProgramaCiclo> setProgramaCiclos = programaCicloService.getAllProgramaCicloByTipoPago(tipo_pago);
    return new ResponseEntity<>(setProgramaCiclos, HttpStatus.OK);
  }
}
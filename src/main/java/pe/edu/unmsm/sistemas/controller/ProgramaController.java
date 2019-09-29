package pe.edu.unmsm.sistemas.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pe.edu.unmsm.sistemas.domain.Programa;
import pe.edu.unmsm.sistemas.service.ProgramaService;

@RestController
@Api(tags = "Programas")
@RequestMapping("/programas")
public class ProgramaController {

  @Autowired
  ProgramaService programaService;

  @GetMapping
  public ResponseEntity<Set<Programa>> getAllProgramas() {
    Set<Programa> setProgramas = programaService.getAllProgramas();
    return new ResponseEntity<>(setProgramas, HttpStatus.OK);
  }

}
package pe.edu.unmsm.sistemas.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.unmsm.sistemas.domain.Programa;
import pe.edu.unmsm.sistemas.service.ProgramaService;

import java.util.Set;

@RestController
@CrossOrigin
@Api(tags = "Programas")
@RequestMapping("/programas")
public class ProgramaController {

    @Autowired
    ProgramaService programaService;

    @GetMapping
    public ResponseEntity<Set<Programa>> getAllProgramas() {
        Set<Programa> programas = programaService.getAllProgramas();
        return new ResponseEntity<>(programas, HttpStatus.OK);
    }

}
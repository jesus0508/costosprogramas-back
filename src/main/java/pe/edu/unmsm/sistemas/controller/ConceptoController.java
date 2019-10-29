package pe.edu.unmsm.sistemas.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unmsm.sistemas.domain.Concepto;
import pe.edu.unmsm.sistemas.service.ConceptoService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@Api(tags = "Concepto")
@RequestMapping("/conceptos")
public class ConceptoController {
    @Autowired
    ConceptoService conceptoService;

    @GetMapping
    public ResponseEntity<List<Concepto>> getAllConceptosPresupuesto(@RequestParam("id") Optional<List<Integer>> conceptosId) {
        List<Concepto> conceptos;
        if (conceptosId.isPresent()) {
            conceptos = conceptoService.getAllConceptosPresupuesto(conceptosId.get());
        } else {
            conceptos = conceptoService.getAllConceptos();
        }
        return new ResponseEntity<>(conceptos, HttpStatus.OK);
    }
}

package pe.edu.unmsm.sistemas.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.unmsm.sistemas.domain.ProgramacionPago;
import pe.edu.unmsm.sistemas.service.ProgramacionPagoService;

import java.util.Set;

@RestController
@CrossOrigin
@Api(tags = "Programacion Pagos")
@RequestMapping("/programacion_pagos")
public class ProgramacionPagoController {

    @Autowired
    ProgramacionPagoService programacionPagoService;

    @GetMapping
    public ResponseEntity<Set<ProgramacionPago>> getAllProgramacionPagos() {
        Set<ProgramacionPago> programacionPagos = programacionPagoService.getAllProgramacionPagos();
        return new ResponseEntity<>(programacionPagos, HttpStatus.OK);
    }

}
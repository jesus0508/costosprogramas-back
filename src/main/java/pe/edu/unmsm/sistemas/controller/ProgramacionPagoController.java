package pe.edu.unmsm.sistemas.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import pe.edu.unmsm.sistemas.domain.ProgramacionPago;
import pe.edu.unmsm.sistemas.service.ProgramacionPagoService;

@RestController
@CrossOrigin
@Api(tags = "Programacion Pagos")
@RequestMapping("/programacion_pagos")
public class ProgramacionPagoController {
  @Autowired
  ProgramacionPagoService programacionPagoService;

  @GetMapping
  public ResponseEntity<Set<ProgramacionPago>> getAllProgramacionPagos() {
    Set<ProgramacionPago> setProgramacionPagos = programacionPagoService.getAllProgramacionPagos();
    return new ResponseEntity<>(setProgramacionPagos, HttpStatus.OK);
  }

}
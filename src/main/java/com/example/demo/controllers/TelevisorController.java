package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TelevisorDTO;
import com.example.demo.model.Televisor;
import com.example.demo.services.TelevisorService;

@RestController
@RequestMapping("/api/televisor")
public class TelevisorController {

    @Autowired
    private TelevisorService televisorService;

    // http://localhost:8080/api/televisor/list
    @GetMapping("/list")
    public ResponseEntity<List<Televisor>> listarTelevisores() {
        List<Televisor> televisores = televisorService.listarTelevisores();
        if (televisores.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(televisores, HttpStatus.OK);
    }

    // http://localhost:8080/api/televisor/{idTelevisor}
    @GetMapping("/{idTelevisor}")
    public ResponseEntity<TelevisorDTO> recuperarTelevisor(@PathVariable Long idTelevisor) {
        Televisor televisor = televisorService.recuperarTelevisor(idTelevisor);
        if (televisor == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        TelevisorDTO televisorDTO = televisorService.convertirATelevisorDTO(televisor);
        return new ResponseEntity<>(televisorDTO, HttpStatus.OK);
    }

    // http://localhost:8080/api/televisor/save
    @PostMapping("/save")
    public ResponseEntity<Televisor> guardarTelevisor(@RequestBody TelevisorDTO televisorDTO) {
        Televisor televisor = televisorService.guardarTelevisor(televisorDTO);
        return new ResponseEntity<>(televisor, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/televisor/update/{idTelevisor}
    @PutMapping("/update/{idTelevisor}")
    public ResponseEntity<Televisor> actualizarTelevisor(@PathVariable Long idTelevisor, @RequestBody TelevisorDTO televisorDTO) {
        Televisor televisor = televisorService.actualizarTelevisor(idTelevisor, televisorDTO);
        return new ResponseEntity<>(televisor, HttpStatus.OK);
    }

    // http://localhost:8080/api/televisor/delete/{idTelevisor}
    @DeleteMapping("/delete/{idTelevisor}")
    public ResponseEntity<HttpStatus> eliminarTelevisor(@PathVariable Long idTelevisor) {
        televisorService.eliminarTelevisor(idTelevisor);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

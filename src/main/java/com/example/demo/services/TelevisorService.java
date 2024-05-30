package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TelevisorDTO;
import com.example.demo.model.Resolucion;
import com.example.demo.model.Televisor;
import com.example.demo.repository.TelevisorRepository;
import com.example.demo.util.NotFoundException;

import jakarta.transaction.Transactional;

@Service
public class TelevisorService {

    @Autowired
    private TelevisorRepository televisorRepository;

    public Televisor recuperarTelevisor(Long id) {
        return televisorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Televisor no encontrado con ID: " + id));
    }

    public List<Televisor> listarTelevisores() {
        return televisorRepository.findAll();
    }

    @Transactional
    public Televisor guardarTelevisor(TelevisorDTO televisorDTO) {
        Televisor televisor = new Televisor();
        actualizarTelevisorDesdeDTO(televisor, televisorDTO);
        return televisorRepository.save(televisor);
    }

    public void eliminarTelevisor(Long id) {
        televisorRepository.deleteById(id);
    }

    @Transactional
    public Televisor actualizarTelevisor(Long id, TelevisorDTO televisorDTO) {
        Televisor televisor = recuperarTelevisor(id);
        actualizarTelevisorDesdeDTO(televisor, televisorDTO);
        return televisorRepository.save(televisor);
    }

    private void actualizarTelevisorDesdeDTO(Televisor televisor, TelevisorDTO televisorDTO) {
        if (!"".equals(televisorDTO.getMarca())) {
            televisor.setMarca(televisorDTO.getMarca());
        }
        if (televisorDTO.getTamanoPantalla() != -1D) {
            televisor.setTamanoPantalla(televisorDTO.getTamanoPantalla());
        }
        if (!"".equals(televisorDTO.getResolucion())) {
            televisor.setResolucion(Resolucion.valueOf(televisorDTO.getResolucion()));
        }
        if (!"".equals(televisorDTO.getDescripcion())) {
            televisor.setDescripcion(televisorDTO.getDescripcion());
        }
        if (!"".equals(televisorDTO.getFuncionesAdicionales())) {
            televisor.setFuncionesAdicionales(televisorDTO.getFuncionesAdicionales());
        }
        if (televisorDTO.getPrecio() != -1D) {
            televisor.setPrecio(televisorDTO.getPrecio());
        }
        if (!"".equals(televisorDTO.getDescripcionGarantia())) {
            televisor.setDescripcionGarantia(televisorDTO.getDescripcionGarantia());
        }
        if (televisorDTO.getFechaCreacion() != null) {
            televisor.setFechaCreacion(televisorDTO.getFechaCreacion());
        }
    }

    public TelevisorDTO convertirATelevisorDTO(Televisor televisor) {
        TelevisorDTO televisorDTO = new TelevisorDTO();
    
        if (televisor.getId() != null) {
            televisorDTO.setId(televisor.getId());
        }
    
        if (televisor.getMarca() != null && !televisor.getMarca().isEmpty()) {
            televisorDTO.setMarca(televisor.getMarca());
        }
    
        if (televisor.getTamanoPantalla() != 0) {
            televisorDTO.setTamanoPantalla(televisor.getTamanoPantalla());
        }
    
        if (televisor.getResolucion() != null) {
            televisorDTO.setResolucion(televisor.getResolucion().name());
        }
    
        if (televisor.getDescripcion() != null && !televisor.getDescripcion().isEmpty()) {
            televisorDTO.setDescripcion(televisor.getDescripcion());
        }
    
        if (televisor.getFuncionesAdicionales() != null && !televisor.getFuncionesAdicionales().isEmpty()) {
            televisorDTO.setFuncionesAdicionales(televisor.getFuncionesAdicionales());
        }
    
        if (televisor.getPrecio() != 0) {
            televisorDTO.setPrecio(televisor.getPrecio());
        }
    
        if (televisor.getDescripcionGarantia() != null && !televisor.getDescripcionGarantia().isEmpty()) {
            televisorDTO.setDescripcionGarantia(televisor.getDescripcionGarantia());
        }
    
        if (televisor.getFechaCreacion() != null) {
            televisorDTO.setFechaCreacion(televisor.getFechaCreacion());
        }
    
        return televisorDTO;
    }
}

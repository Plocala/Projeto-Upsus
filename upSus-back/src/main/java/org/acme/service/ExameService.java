package org.acme.service;

import java.util.List;

import org.acme.DTO.ExameDTO;
import org.acme.DTO.ExameResponseDTO;
import jakarta.validation.Valid;

public interface ExameService {

    public ExameResponseDTO create(@Valid ExameDTO dto);
    public void update(Long id, ExameDTO dto);
    public void delete(Long id);
    public ExameResponseDTO findById(Long id);
    public List<ExameResponseDTO> findAll();
    public List<ExameResponseDTO> findByTipo(String tipo);
    public List<ExameResponseDTO> findByResultado(String resultado);
    public List<ExameResponseDTO> findByPaciente(Long pacienteId);
    public List<ExameResponseDTO> findByProfissional(Long profissionalId);
}
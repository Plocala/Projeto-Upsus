package org.acme.service;

import java.util.List;

import org.acme.DTO.ProfissionalDTO;
import org.acme.DTO.ProfissionalResponseDTO;
import jakarta.validation.Valid;

public interface ProfissionalService {

    public ProfissionalResponseDTO create(@Valid ProfissionalDTO dto);
    public void update(Long id, ProfissionalDTO dto);
    public void delete(Long id);
    public ProfissionalResponseDTO findById(Long id);
    public List<ProfissionalResponseDTO> findAll();
    public List<ProfissionalResponseDTO> findByNome(String nome);
    public List<ProfissionalResponseDTO> findByEspecialidade(String especialidade);
    public List<ProfissionalResponseDTO> findByFormacao (String formacao);
    
}
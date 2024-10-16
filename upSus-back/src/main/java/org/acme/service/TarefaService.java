package org.acme.service;

import java.util.List;

import org.acme.DTO.TarefaDTO;
import org.acme.DTO.TarefaResponseDTO;
import jakarta.validation.Valid;

public interface TarefaService {
    public TarefaResponseDTO create(@Valid TarefaDTO dto);
    public void update(Long id, @Valid TarefaDTO dto);
    public void delete(Long id);
    public TarefaResponseDTO findById(Long id);
    public List<TarefaResponseDTO> findAll();
    public List<TarefaResponseDTO> findByNome(String nome);
    public List<TarefaResponseDTO> findByDescricao(String descricao);
    public List<TarefaResponseDTO> findByStatus(String status);
}
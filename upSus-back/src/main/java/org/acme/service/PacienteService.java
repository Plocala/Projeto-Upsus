package org.acme.service;

import java.util.List;

import org.acme.DTO.PacienteDTO;
import org.acme.DTO.PacienteResponseDTO;
import jakarta.validation.Valid;

public interface PacienteService {

    public PacienteResponseDTO create(@Valid PacienteDTO dto);
    public void update(Long id, PacienteDTO dto);
    public void delete(Long id);
    public PacienteResponseDTO findById(Long id);
    public List<PacienteResponseDTO> findAll();
    public List<PacienteResponseDTO> findByNome(String nome);
    public List<PacienteResponseDTO> findByNomeMae(String nomeMae);
    public List<PacienteResponseDTO> findByDataNascimento(String dataInicio, String dataFim);
    public List<PacienteResponseDTO> findByLastConsult(String dataInicio, String dataFim);
    public PacienteResponseDTO findByCartaoSus(String cartaoSus);
    public PacienteResponseDTO findByCpf(String cpf);
    public List<PacienteResponseDTO> findBySexo(boolean sexo);
    public List<PacienteResponseDTO> findByObs(String obs);
}
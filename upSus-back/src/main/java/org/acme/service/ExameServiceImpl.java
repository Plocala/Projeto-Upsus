package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import org.acme.DTO.ExameDTO;
import org.acme.DTO.ExameResponseDTO;
import org.acme.model.Exame;
import org.acme.model.Paciente;
import org.acme.model.Profissional;
import org.acme.repository.ExameRepository;
import org.acme.repository.PacienteRepository;
import org.acme.repository.ProfissionalRepository;
import org.acme.util.Error;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ExameServiceImpl implements ExameService {

    @Inject
    ExameRepository exameRepository;

    @Inject
    PacienteRepository pacienteRepository;

    @Inject
    ProfissionalRepository profissionalRepository;

    @Override
    @Transactional
    public ExameResponseDTO create(@Valid ExameDTO dto) {
        Exame exame = new Exame();
        exame.setMomento(dto.momento());
        exame.setResultado(dto.resultado());
        exame.setTipo(dto.tipo());
        exame.setAnotacao(dto.anotacao());

        Paciente paciente = pacienteRepository.findById(dto.paciente());
        if (paciente == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity(new Error("404", "Paciente não encontrado para o ID fornecido: " + dto.paciente()))
                    .build());
        }
        exame.setPaciente(paciente);

        List<Profissional> profissionais = dto.idProfissionais().stream()
                .map(profissionalId -> {
                    Profissional profissional = profissionalRepository.findById(profissionalId);
                    if (profissional == null) {
                        throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                                .entity(new Error("404", "Profissional não encontrado para o ID fornecido: " + profissionalId))
                                .build());
                    }
                    return profissional;
                })
                .collect(Collectors.toList());
        exame.setProfissional(profissionais);

        exameRepository.persist(exame);
        return ExameResponseDTO.valueOf(exame);
    }

    @SuppressWarnings("resource")
    public void validarId(long id) {
        if (exameRepository.findById(id) == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity(new Error("404", "Exame não encontrado para o ID fornecido: " + id))
                    .build());
        }
    }

    @Override
    @Transactional
    public void update(Long id, ExameDTO dto) {
        validarId(id);
        Exame exameBanco = exameRepository.findById(id);
        exameBanco.setMomento(dto.momento());
        exameBanco.setResultado(dto.resultado());
        exameBanco.setTipo(dto.tipo());
        exameBanco.setAnotacao(dto.anotacao());

        Paciente paciente = pacienteRepository.findById(dto.paciente());
        if (paciente == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity(new Error("404", "Paciente não encontrado para o ID fornecido: " + dto.paciente()))
                    .build());
        }
        exameBanco.setPaciente(paciente);

        List<Profissional> profissionais = dto.idProfissionais().stream()
                .map(profissionalId -> {
                    Profissional profissional = profissionalRepository.findById(profissionalId);
                    if (profissional == null) {
                        throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                                .entity(new Error("404", "Profissional não encontrado para o ID fornecido: " + profissionalId))
                                .build());
                    }
                    return profissional;
                })
                .collect(Collectors.toList());
        exameBanco.setProfissional(profissionais);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        validarId(id);
        exameRepository.deleteById(id);
    }

    @Override
    public ExameResponseDTO findById(Long id) {
        Exame exame = exameRepository.findById(id);
        if (exame == null) {
            return null;
        }
        return ExameResponseDTO.valueOf(exame);
    }

    @Override
    public List<ExameResponseDTO> findAll() {
        return exameRepository
                .listAll()
                .stream()
                .map(e -> ExameResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ExameResponseDTO> findByTipo(String tipo) {
        return exameRepository.findByTipo(tipo).stream()
                .map(e -> ExameResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ExameResponseDTO> findByResultado(String resultado) {
        return exameRepository.findByResultado(resultado).stream()
                .map(e -> ExameResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ExameResponseDTO> findByPaciente(Long pacienteId) {
        return exameRepository.findByPaciente(pacienteId).stream()
                .map(e -> ExameResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ExameResponseDTO> findByProfissional(Long profissionalId) {
        return exameRepository.findByProfissional(profissionalId).stream()
                .map(e -> ExameResponseDTO.valueOf(e)).toList();
    }
}
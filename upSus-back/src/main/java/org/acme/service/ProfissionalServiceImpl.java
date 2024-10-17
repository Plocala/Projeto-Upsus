package org.acme.service;

import java.util.List;

import org.acme.DTO.ProfissionalDTO;
import org.acme.DTO.ProfissionalResponseDTO;
import org.acme.model.Formacao;
import org.acme.model.Profissional;
import org.acme.repository.ProfissionalRepository;
import org.acme.util.Error;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class ProfissionalServiceImpl implements ProfissionalService {

    @Inject
    public ProfissionalRepository profissionalRepository;

    @Override
    @Transactional
    public ProfissionalResponseDTO create(@Valid ProfissionalDTO dto) {
        Profissional profissional = new Profissional();
        profissional.setNome(dto.nome());
        profissional.setEspecialidade(dto.especialidade());
        profissional.setSenha(dto.senha());
        profissional.setFormacao(Formacao.value(dto.formacao()));
        profissional.setCpf(dto.cpf());
        profissional.setEmail(dto.email());
        profissional.setTelefone(dto.telefone());
        profissional.setEndereco(dto.endereco());

        profissionalRepository.persist(profissional);
        return ProfissionalResponseDTO.valueOf(profissional);
    }

    @SuppressWarnings("resource")
    public void validarId(long id) {
        if (profissionalRepository.findById(id) == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity(new Error("404", "Profissional não encontrado para o ID fornecido: " + id))
                    .build());
        }
    }

    @Override
    @Transactional
    public void update(Long id, ProfissionalDTO dto) {
        validarId(id);
        Profissional profissionalBanco = profissionalRepository.findById(id);

        profissionalBanco.setNome(dto.nome());
        profissionalBanco.setEspecialidade(dto.especialidade());
        profissionalBanco.setSenha(dto.senha());
        profissionalBanco.setFormacao(Formacao.value(dto.formacao()));
        profissionalBanco.setCpf(dto.cpf());
        profissionalBanco.setEmail(dto.email());
        profissionalBanco.setTelefone(dto.telefone());
        profissionalBanco.setEndereco(dto.endereco());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        validarId(id);
        profissionalRepository.deleteById(id);
    }

    @Override
    public ProfissionalResponseDTO findById(Long id) {
        Profissional profissional = profissionalRepository.findById(id);
        if (profissional == null) {
            return null;
        }
        return ProfissionalResponseDTO.valueOf(profissional);
    }

    @Override
    public List<ProfissionalResponseDTO> findAll() {
        return profissionalRepository
                .listAll()
                .stream()
                .map(e -> ProfissionalResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ProfissionalResponseDTO> findByNome(String nome) {
        return profissionalRepository.findByName(nome).stream()
                .map(e -> ProfissionalResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ProfissionalResponseDTO> findByFormacao(String formacao) {
        return profissionalRepository.findByFormacao(Formacao.value(formacao)).stream()
                .map(e -> ProfissionalResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ProfissionalResponseDTO> findByEspecialidade(String especialidade) {
        return profissionalRepository.findByEspecialidade(especialidade).stream()
                .map(e -> ProfissionalResponseDTO.valueOf(e)).toList();
    }
    
}
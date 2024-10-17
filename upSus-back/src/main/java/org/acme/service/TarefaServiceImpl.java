package org.acme.service;

import java.util.List;

import org.acme.DTO.TarefaDTO;
import org.acme.DTO.TarefaResponseDTO;
import org.acme.model.StatusTarefa;
import org.acme.model.Tarefa;
import org.acme.repository.TarefaRepository;
import org.acme.util.Error;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class TarefaServiceImpl implements TarefaService {

    @Inject
    public TarefaRepository tarefaRepository;

    @Override
    @Transactional
    public TarefaResponseDTO create(@Valid TarefaDTO dto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setNome(dto.nome());
        tarefa.setDescricao(dto.descricao());
        tarefa.setStatus(StatusTarefa.valueOf(dto.status()));
        tarefaRepository.persist(tarefa);
        return TarefaResponseDTO.valueOf(tarefa);
    }

    @SuppressWarnings("resource")
    public void validarId(long id) {
        if (tarefaRepository.findById(id) == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity(new Error("404", "Tarefa não encontrada para o ID fornecido: " + id))
                    .build());
        }
    }

    @Override
    @Transactional
    public void update(Long id, TarefaDTO dto) {
        validarId(id);
        Tarefa tarefaBanco = tarefaRepository.findById(id);

        tarefaBanco.setNome(dto.nome());
        tarefaBanco.setDescricao(dto.descricao());
        tarefaBanco.setStatus(StatusTarefa.valueOf(dto.status()));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        validarId(id);
        tarefaRepository.deleteById(id);
    }

    @Override
    public TarefaResponseDTO findById(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id);
        if (tarefa == null) {
            return null;
        }
        return TarefaResponseDTO.valueOf(tarefa);
    }

    @Override
    public List<TarefaResponseDTO> findAll() {
        return tarefaRepository
                .listAll()
                .stream()
                .map(e -> TarefaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<TarefaResponseDTO> findByNome(String nome) {
        return tarefaRepository.findByNome(nome).stream()
                .map(e -> TarefaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<TarefaResponseDTO> findByDescricao(String descricao) {
        return tarefaRepository.findByDescricao(descricao).stream()
                .map(e -> TarefaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<TarefaResponseDTO> findByStatus(String status) {
        return tarefaRepository.findByStatus(StatusTarefa.value(status)).stream()
                .map(e -> TarefaResponseDTO.valueOf(e)).toList();
    }
}

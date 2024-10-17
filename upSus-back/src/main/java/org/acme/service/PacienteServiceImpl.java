package org.acme.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.acme.DTO.PacienteDTO;
import org.acme.DTO.PacienteResponseDTO;
import org.acme.model.Condicao;
import org.acme.model.Endereco;
import org.acme.model.Paciente;
import org.acme.model.Telefone;
import org.acme.repository.PacienteRepository;
import org.acme.repository.TarefaRepository;
import org.acme.util.Error;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
public class PacienteServiceImpl implements PacienteService {
    @Inject
    PacienteRepository pacienteRepository;

    @Inject
    TarefaRepository tarefaRepository;

    public static String DATE_FORMAT_INPUT = "ddMMyyyy";

    @Override
    @Transactional
    public PacienteResponseDTO create(@Valid PacienteDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setNome(dto.nome());
        paciente.setNomeMae(dto.nomeMae());
        paciente.setDataNascimento(convert(dto.dataNascimento()));
        paciente.setCpf(dto.cpf());
        paciente.setAnotacao(dto.anotacao());
        paciente.setEmail(dto.email());
        Telefone telefone = new Telefone();
        telefone.setCodigoArea(dto.telefone().getCodigoArea());
        telefone.setNumero(dto.telefone().getNumero());
        paciente.setTelefone(telefone);

        Endereco endereco = new Endereco();
        endereco.setCep(dto.endereco().getCep());
        endereco.setBairro(dto.endereco().getBairro());
        endereco.setCidade(dto.endereco().getCidade());
        endereco.setComplemento(dto.endereco().getComplemento());
        endereco.setCidade(dto.endereco().getCidade());
        endereco.setNumero(dto.endereco().getNumero());
        paciente.setEndereco(endereco);

        paciente.setCartaoSus(dto.cartaoSus());
        paciente.setSexo(dto.sexo());
        paciente.setObs(dto.obs());
        paciente.setDataUltimaConsulta(convert(dto.dataUltimaConsulta()));
        paciente.setDataNascimento(convert(dto.dataNascimento()));
        pacienteRepository.persist(paciente);
        paciente.setCondicoes(dto.condicaoIds().stream()
            .map(Condicao::value)
            .collect(Collectors.toList()));
        return PacienteResponseDTO.valueOf(paciente);

    }

    @SuppressWarnings("resource")
    public void validarId(long id) {
        if (pacienteRepository.findById(id) == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity(new Error("404", "Paciente não encontrado para o ID fornecido: " + id))
                    .build());
        }
    }

    @Override
    @Transactional
    public void update(Long id, PacienteDTO dto) {
        validarId(id);
        Paciente paciente = pacienteRepository.findById(id);
        paciente.setNome(dto.nome());
        paciente.setNomeMae(dto.nomeMae());
        paciente.setDataNascimento(convert(dto.dataNascimento()));
        paciente.setCpf(dto.cpf());
        paciente.setAnotacao(dto.anotacao());
        paciente.setEmail(dto.email());

        Telefone telefone = new Telefone();
        telefone.setCodigoArea(dto.telefone().getCodigoArea());
        telefone.setNumero(dto.telefone().getNumero());
        paciente.setTelefone(telefone);

        Endereco endereco = new Endereco();
        endereco.setCep(dto.endereco().getCep());
        endereco.setBairro(dto.endereco().getBairro());
        endereco.setCidade(dto.endereco().getCidade());
        endereco.setComplemento(dto.endereco().getComplemento());
        endereco.setCidade(dto.endereco().getCidade());
        endereco.setNumero(dto.endereco().getNumero());
        paciente.setEndereco(endereco);

        paciente.setCartaoSus(dto.cartaoSus());
        paciente.setSexo(dto.sexo());
        paciente.setObs(dto.obs());
        paciente.setDataUltimaConsulta(convert(dto.dataUltimaConsulta()));
        paciente.setDataNascimento(convert(dto.dataNascimento()));
        paciente.setCondicoes(dto.condicaoIds().stream()
            .map(Condicao::value)
            .collect(Collectors.toList()));
        pacienteRepository.persist(paciente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        validarId(id);
        pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteResponseDTO findById(Long id) {
        Paciente paciente = pacienteRepository.findById(id);
        if (paciente == null) {
            return null;
        }
        return PacienteResponseDTO.valueOf(paciente);
    }

    @Override
    public List<PacienteResponseDTO> findAll() {
        return pacienteRepository
                .listAll()
                .stream()
                .map(e -> PacienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PacienteResponseDTO> findByNome(String nome) {
        return pacienteRepository.findByNome(nome).stream()
                .map(e -> PacienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PacienteResponseDTO> findByNomeMae(String nomeMae) {
        return pacienteRepository.findByNomeMae(nomeMae).stream()
                .map(e -> PacienteResponseDTO.valueOf(e)).toList();
    }

    public static LocalDate convert(String dateStr) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(DATE_FORMAT_INPUT));
    }

    @Override
    public List<PacienteResponseDTO> findByDataNascimento(String dataInicio, String dataFim) {

        return pacienteRepository.findByBirth(convert(dataInicio), convert(dataFim)).stream()
                .map(e -> PacienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PacienteResponseDTO> findByLastConsult(String dataInicio, String dataFim) {
        return pacienteRepository.findByLastConsult(convert(dataInicio), convert(dataFim)).stream()
                .map(e -> PacienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public PacienteResponseDTO findByCartaoSus(String cartaoSus) {
        Paciente paciente = pacienteRepository.findByCartaoSus(cartaoSus);
        if (paciente == null) {
            return null;
        }
        return PacienteResponseDTO.valueOf(paciente);
    }

    @Override
    public PacienteResponseDTO findByCpf(String cpf) {
        Paciente paciente = pacienteRepository.findByCpf(cpf);
        if (paciente == null) {
            return null;
        }
        return PacienteResponseDTO.valueOf(paciente);
    }

    @Override
    public List<PacienteResponseDTO> findBySexo(boolean sexo) {
        return pacienteRepository.findBySexo(sexo).stream()
                .map(e -> PacienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PacienteResponseDTO> findByObs(String obs) {
        return pacienteRepository.findByObs(obs).stream()
                .map(e -> PacienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    @Transactional
    public void adicionarTarefa(Long id, Long idTarefa) {
        Paciente paciente = pacienteRepository.findById(id);
        paciente.getTarefas().add(tarefaRepository.findById(idTarefa));
    }

}

package org.acme.DTO;

import java.time.LocalDate;

import org.acme.model.Endereco;
import org.acme.model.Telefone;

public record PacienteDTO(
    String nome,
    String cpf,
    String email,
    String nomeMae,
    String anotacao,
    LocalDate dataNascimento,
    String cartaoSus,
    String obs,
    boolean sexo,
    Telefone telefone,
    Endereco endereco,
    LocalDate dataUltimaConsulta
) {
}
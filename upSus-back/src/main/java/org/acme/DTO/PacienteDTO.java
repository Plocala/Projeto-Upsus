package org.acme.DTO;

import java.time.LocalDate;

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
    LocalDate dataUltimaConsulta
) {
}
package org.acme.DTO;

import org.acme.model.Endereco;
import org.acme.model.Telefone;
import java.util.List;

public record PacienteDTO(
    String nome,
    String cpf,
    String email,
    String nomeMae,
    String anotacao,
    String dataNascimento,
    String cartaoSus,
    String obs,
    boolean sexo,
    Telefone telefone,
    Endereco endereco,
    String dataUltimaConsulta,
    List<Integer> condicaoIds
) {
}
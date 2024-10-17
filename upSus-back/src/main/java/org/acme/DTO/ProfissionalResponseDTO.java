package org.acme.DTO;

import org.acme.model.Profissional;
import org.acme.model.Exame;
import java.util.List;

public record ProfissionalResponseDTO(
    Long id,
    String especialidade,
    String formacao,
    String nome,
    String cpf,
    String email,
    String telefone,
    List<ExameResponseDTOSimple> exames
) { public static ProfissionalResponseDTO valueOf(Profissional profissional){
    List<ExameResponseDTOSimple> exames = profissional.getExames().stream().map(ExameResponseDTOSimple::valueOf).toList();
        return new ProfissionalResponseDTO(
            profissional.getId(),
            profissional.getEspecialidade(),
            profissional.getFormacao().getDescricao(),
            profissional.getNome(),
            profissional.getCpf(),
            profissional.getEmail(),
            profissional.getTelefone().getNumero(),
            exames
        );
    }
    
}

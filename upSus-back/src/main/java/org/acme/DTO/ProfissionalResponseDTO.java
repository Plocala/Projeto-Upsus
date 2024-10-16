package org.acme.DTO;

import org.acme.model.Profissional;

public record ProfissionalResponseDTO(
    Long id,
    String especialidade,
    String formacao,
    String nome,
    String cpf,
    String email,
    String telefone
) { public static ProfissionalResponseDTO valueOf(Profissional profissional){
        return new ProfissionalResponseDTO(
            profissional.getId(),
            profissional.getEspecialidade(),
            profissional.getFormacao().getDescricao(),
            profissional.getNome(),
            profissional.getCpf(),
            profissional.getEmail(),
            profissional.getTelefone().getNumero()
        );
    }
    
}

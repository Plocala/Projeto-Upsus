package org.acme.DTO;

import java.util.List;

import org.acme.model.Exame;

public record ExameResponseDTO(
    Long id,
    String resultado,
    String tipo,
    String anotacao,
    String momento,
    Long paciente,
    List<ProfissionalResponseDTO> profissionais
) { public static ExameResponseDTO valueOf(Exame exame){
        List<ProfissionalResponseDTO> profissionais = exame.getProfissional().stream().map(ProfissionalResponseDTO::valueOf).toList();
        return new ExameResponseDTO(
            exame.getId(),
            exame.getResultado(),
            exame.getTipo(),
            exame.getAnotacao(),
            exame.getMomento().toString(),
            exame.getPaciente().getId(),
            profissionais
            
        );
    }
    
}

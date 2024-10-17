package org.acme.DTO;

import java.util.List;

import org.acme.model.Exame;

public record ExameResponseDTO(
    Long id,
    String resultado,
    String tipo,
    String anotacao,
    String momento,
    PacienteResponseDTO paciente,
    ProfissionalResponseDTO profissionais
) { public static ExameResponseDTO valueOf(Exame exame){
        return new ExameResponseDTO(
            exame.getId(),
            exame.getResultado(),
            exame.getTipo(),
            exame.getAnotacao(),
            exame.getMomento().toString(),
            PacienteResponseDTO.valueOf(exame.getPaciente()),
            ProfissionalResponseDTO.valueOf(exame.getProfissional())
            
        );
    }
    
}

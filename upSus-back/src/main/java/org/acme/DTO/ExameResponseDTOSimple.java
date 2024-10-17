package org.acme.DTO;

import org.acme.model.Exame;

public record ExameResponseDTOSimple(
    Long id,
    String tipo,
    String resultado,
    String anotacao,
    String nomePaciente,
    String nomeProfissional
) {
    public static ExameResponseDTOSimple valueOf(Exame exame) {
        return new ExameResponseDTOSimple(
            exame.getId(),
            exame.getTipo(),
            exame.getResultado(),
            exame.getAnotacao(),
            exame.getPaciente().getNome(),
            exame.getProfissional().getNome()
        );
    }
    
}

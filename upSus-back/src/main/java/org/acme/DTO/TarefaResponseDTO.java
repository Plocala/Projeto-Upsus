package org.acme.DTO;

import org.acme.model.Tarefa;

public record TarefaResponseDTO(
    Long id,
    String descricao,
    String data,
    String hora,
    String status
) {
    public static TarefaResponseDTO valueOf(Tarefa tarefa){
        return new TarefaResponseDTO(
            tarefa.getId(),
            tarefa.getDescricao(),
            tarefa.getData().toString(),
            tarefa.getHora().toString(),
            tarefa.getStatus().getDescricao()
        );
    }
}

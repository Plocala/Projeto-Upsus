package org.acme.DTO;

import org.acme.model.Tarefa;

public record TarefaResponseDTO(
    Long id,
    String nome,
    String descricao,
    String status
) {
    public static TarefaResponseDTO valueOf(Tarefa tarefa){
        return new TarefaResponseDTO(
            tarefa.getId(),
            tarefa.getNome(),
            tarefa.getDescricao(),
            tarefa.getStatus().getDescricao()
        );
    }
}

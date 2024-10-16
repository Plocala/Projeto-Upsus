package org.acme.DTO;

public record TarefaDTO(
    Long id,
    String descricao,
    String data,
    String hora,
    String status
) {
} 
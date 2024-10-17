package org.acme.DTO;

import java.time.LocalDateTime;
import java.util.List;

public record ExameDTO(
    LocalDateTime momento,
    String resultado,
    String tipo,
    String anotacao,
    Long paciente,
    Long idProfissional
) {
}
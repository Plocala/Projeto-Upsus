package org.acme.DTO;

public record Exame {
    LocalDateTime momento, 
    String resultado, 
    String tipo, 
    String anotacao, 
    Paciente paciente
}
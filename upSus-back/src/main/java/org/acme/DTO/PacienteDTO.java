package org.acme.DTO;

public record Paciente {
    String nomeMae, 
    String anotacao, 
    LocalDate dataNascimento, 
    String cartaoSus, 
    boolean sexo, 
    LocalDate dataUltimaConsulta, 
    List<Exame> exames = new ArrayList<>()
}
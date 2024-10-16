package org.acme.DTO;

import org.acme.model.Paciente;

public record PacienteResponseDTO(
    String nome,
    String cpf,
    String email,
    String nomeMae,
    String anotacao,
    String dataNascimento,
    String cartaoSus,
    String obs,
    boolean sexo,
    String dataUltimaConsulta
) {
    public static PacienteResponseDTO valueOf(Paciente paciente){
        return new PacienteResponseDTO(
            paciente.getNome(),
            paciente.getCpf(),
            paciente.getEmail(),
            paciente.getNomeMae(),
            paciente.getAnotacao(),
            paciente.getDataNascimento().toString(),
            paciente.getCartaoSus(),
            paciente.getObs(),
            paciente.isSexo(),
            paciente.getDataUltimaConsulta().toString()
        );
    }
    
}

package org.acme.DTO;

import org.acme.model.Condicao;
import org.acme.model.Paciente;
import java.util.List;
public record PacienteResponseDTO(
    Long id,
    String nome,
    String cpf,
    String email,
    String nomeMae,
    String anotacao,
    String dataNascimento,
    String cartaoSus,
    String obs,
    boolean sexo,
    String dataUltimaConsulta,
    List<TarefaResponseDTO> tarefas,
    List<Condicao> condicoes
) {
    public static PacienteResponseDTO valueOf(Paciente paciente){
        List<TarefaResponseDTO> tarefas = paciente.getTarefas().stream().map(TarefaResponseDTO::valueOf).toList();
        return new PacienteResponseDTO(
            paciente.getId(),
            paciente.getNome(),
            paciente.getCpf(),
            paciente.getEmail(),
            paciente.getNomeMae(),
            paciente.getAnotacao(),
            paciente.getDataNascimento().toString(),
            paciente.getCartaoSus(),
            paciente.getObs(),
            paciente.isSexo(),
            paciente.getDataUltimaConsulta().toString(),
            tarefas,
            paciente.getCondicoes()
        );
    }
    
}

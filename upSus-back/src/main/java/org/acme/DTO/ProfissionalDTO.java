package org.acme.DTO;

import org.acme.model.Endereco;
import org.acme.model.Telefone;


public record ProfissionalDTO (
    String senha, 
    String especialidade, 
    String formacao,
    String nome,
    String cpf,
    String email,
    Telefone telefone,
    Endereco endereco
    ){
    
}
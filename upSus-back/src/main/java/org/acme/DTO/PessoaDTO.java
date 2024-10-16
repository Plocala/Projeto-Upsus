package org.acme.DTO;

public record Pessoa {
    String nome, 
    String cpf, 
    String email, 
    Telefone telefone, 
    Endereco endereco, 
    String obs
}
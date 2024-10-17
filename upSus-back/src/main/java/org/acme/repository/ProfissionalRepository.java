package org.acme.repository;

import java.util.List;

import org.acme.model.Formacao;
import org.acme.model.Profissional;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ProfissionalRepository implements PanacheRepository<Profissional> {
    
    public List<Profissional> findByName(String name) {
        return find("UPPER(nome) LIKE ?1", "%" + name + "%").list();
    }

    public Profissional findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public Profissional findByCpf(String cpf) {
        return find("cpf", cpf).firstResult();
    }

    public Profissional findByCpfAndSenha(String cpf, String senha) {
        return find("cpf = ?1 and senha = ?2", cpf, senha).firstResult();
    }

    public List<Profissional> findByFormacao(Formacao formacao) {
        return find("formacao", formacao).list();
    }
    public List<Profissional> findByEspecialidade(String especialidade) {
        return find("UPPER(especialidade) = like?1", "%"+especialidade+"%").list();
    }
    
}
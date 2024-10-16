package org.acme.repository;

import java.util.List;

import org.acme.model.Pessoa;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa> {
    
}
package org.acme.repository;

import org.acme.model.Exame;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ExameRepository implements PanacheRepository<Exame> {
    
}
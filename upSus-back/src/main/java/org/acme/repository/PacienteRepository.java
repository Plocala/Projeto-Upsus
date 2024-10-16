package org.acme.repository;

import java.util.List;

import org.acme.model.Paciente;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class PacienteRepository implements PanacheRepository<Paciente> {
    
}
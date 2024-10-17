package org.acme.repository;

import java.util.List;

import org.acme.model.Paciente;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;


@ApplicationScoped
public class PacienteRepository implements PanacheRepository<Paciente> {
    
    public List<Paciente> findByNome(String nome) {
        return find("UPPER(nome) LIKE ?1", "%" + nome + "%").list();
    }

    public Paciente findByEmail(String email) {
        return find("email", email).firstResult();
    }

    public List<Paciente> findByNomeMae(String nomeMae) {
        return find("UPPER(nomeMae) LIKE ?1", "%" + nomeMae + "%").list();
    }

    public Paciente findByCpf(String cpf) {
        return find("cpf", cpf).firstResult();
    }

    public Paciente findByCartaoSus(String cartaoSus) {
        return find("cartaoSus", cartaoSus).firstResult();
    }

    public List<Paciente> findBySexo(boolean sexo) {
        return find("sexo", sexo).list();
    }

    public List<Paciente> findByBirth(LocalDate dataInicial, LocalDate dataFinal) {
        return find("dataNascimento BETWEEN ?1 AND ?2", dataInicial, dataFinal).list();
    }

    public List<Paciente> findByLastConsult(LocalDate dataInicial, LocalDate dataFinal) {
        return find("dataUltimaConsulta BETWEEN ?1 AND ?2", dataInicial, dataFinal).list();
    }
    
    public List<Paciente> findByObs(String obs) {
        return find("UPPER(obs) = ?1", "%" + obs + "%").list();
    }
    
}
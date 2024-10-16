package br.unitins.topicos1.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import br.unitins.topicos1.model.Profissional;

@ApplicationScoped
public class ProfissionalRepository implements PanacheRepository<Profissional> {
    public List<Telefone> findByName(String name) {
        return find("UPPER(nome) LIKE ?1", "%" + name + "%").list();
    }
}
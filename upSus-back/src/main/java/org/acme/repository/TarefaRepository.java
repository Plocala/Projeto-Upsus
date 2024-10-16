package org.acme.repository;

import org.acme.model.Tarefa;
import java.util.List;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TarefaRepository implements PanacheRepository<Tarefa> {
    public Tarefa findByNome(String nome) {
        return find("nome", nome).firstResult();
    }
    public List<Tarefa> findByDescricao(String descricao) {
        return find("descricao", descricao).list();
    }

}

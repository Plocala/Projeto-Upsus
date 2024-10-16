package org.acme.repository;

import org.acme.model.StatusTarefa;
import org.acme.model.Tarefa;
import java.util.List;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TarefaRepository implements PanacheRepository<Tarefa> {
    public List<Tarefa> findByNome(String nome) {
        return find("Upper(nome) =like?1", nome).list();
    }
    public List<Tarefa> findByDescricao(String descricao) {
        return find(" Upper(descricao) = like?1", descricao).list();
    }
    public List<Tarefa> findByStatus(StatusTarefa status) {
        return find(" status = ?1", status).list();
    }
}

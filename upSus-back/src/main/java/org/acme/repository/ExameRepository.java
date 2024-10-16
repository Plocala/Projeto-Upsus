package org.acme.repository;

import org.acme.model.Exame;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class ExameRepository implements PanacheRepository<Exame> {
    public List<Exame> findByNome(String nome) {
        return find("UPPER(nome)= like ?1", nome).list();
    }
    public List<Exame> findByDescricao(String descricao) {
        return find("UPPER(descricao)= like?1", descricao).list();
    }
    public List<Exame> findByResultado(String resultado) {
        return find("UPPER(resultado)=like?1", resultado).list();
    }
    public List<Exame> findByPaciente(String paciente) {
        return find("paciente", paciente).list();
    }
    
}
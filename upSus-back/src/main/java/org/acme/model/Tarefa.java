package org.acme.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Tarefa extends DefaultEntity {
    @Column(length = 50, nullable = false)
    private String nome;
    @Column(length = 200, nullable = false)
    private String descricao;
    @Column(nullable = false)
    private StatusTarefa status;

    @Column(length = 50, nullable = false)
    private String data;

    @Column(length = 50, nullable = false)
    private String hora;
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }
    public StatusTarefa getStatus() {
        return status;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

}

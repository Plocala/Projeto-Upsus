package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusTarefa {
    EMANDAMENTO(1, "Em andamento"),
    CONCLUIDA(2, "Concluída"),
    CANCELADA(3, "Cancelada"),
    AGUARDANDO(4, "Aguardando");

    private int id;
    private String descricao;

    StatusTarefa(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusTarefa value(Integer id) {
        if (id == null) {
            return null;
        }

        for (StatusTarefa x : StatusTarefa.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new WebApplicationException("Id inválido: " + id, Response.Status.BAD_REQUEST);
    }

    public static StatusTarefa value(String descricao) {
        if (descricao == null) {
            return null;
        }

        for (StatusTarefa x : StatusTarefa.values()) {
            if (descricao.equals(x.getDescricao())) {
                return x;
            }
        }

        throw new WebApplicationException("Descrição inválida: " + descricao, Response.Status.BAD_REQUEST);
    }
}

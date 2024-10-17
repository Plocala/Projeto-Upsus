package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Condicao {
    GRAVIDAS(1, "Grávidas"),
    FUMANTES(2, "Fumantes"),
    IDOSOS(3, "Idosos"),
    DIABETICOS(4, "Diabéticos");

    private int id;
    private String descricao;

    Condicao(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Condicao value(Integer id) {
        if (id == null) {
            return null;
        }

        for (Condicao x : Condicao.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new WebApplicationException("Id inválido: " + id, Response.Status.BAD_REQUEST);
    }

    public static Condicao value(String descricao) {
        if (descricao == null) {
            return null;
        }

        for (Condicao x : Condicao.values()) {
            if (descricao.equals(x.getDescricao())) {
                return x;
            }
        }

        throw new WebApplicationException("Descrição inválida: " + descricao, Response.Status.BAD_REQUEST);
    }

}
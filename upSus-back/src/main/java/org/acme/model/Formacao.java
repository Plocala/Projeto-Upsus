package org.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Formacao {
    ENFERMEIRO(1, "Enfermagem"),
    TECENFERMAGEM(2, "Técnico de Enfermagem"),
    AUXENFERMAGEM(3, "Auxiliar de Enfermagem"),
    MEDICINA(4, "Medicina"),
    AGENTE(5, "Agente de Saúde"),
    DENTISTA(6, "Dentista"),;

    private int id;
    private String descricao;

    Formacao(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Formacao value(Integer id) {
        if (id == null) {
            return null;
        }

        for (Formacao x : Formacao.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }

        throw new WebApplicationException("Id inválido: " + id, Response.Status.BAD_REQUEST);
    }

    public static Formacao value(String descricao) {
        if (descricao == null) {
            return null;
        }

        for (Formacao x : Formacao.values()) {
            if (descricao.equals(x.getDescricao())) {
                return x;
            }
        }

        throw new WebApplicationException("Descrição inválida: " + descricao, Response.Status.BAD_REQUEST);
    }
}

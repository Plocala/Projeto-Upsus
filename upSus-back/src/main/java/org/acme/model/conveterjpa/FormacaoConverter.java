package org.acme.model.conveterjpa;


import org.acme.model.Formacao;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FormacaoConverter implements AttributeConverter<Formacao, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Formacao formacao) {
        if (formacao == null) {
            return null;
        }
        return formacao.getId();
    }

    @Override
    public Formacao convertToEntityAttribute(Integer id) {
        if (id == null) {
            return null;
        }
        for (Formacao formacao : Formacao.values()) {
            if (formacao.getId() == id) {
                return formacao;
            }
        }
        throw new IllegalArgumentException("Formacao not found for ID: " + id);
    }
}
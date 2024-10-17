package org.acme.model.conveterjpa;

import org.acme.model.Condicao;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CondicaoConverter implements AttributeConverter<Condicao, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Condicao condicao) {
        if (condicao == null) {
            return null;
        }
        return condicao.getId();
    }

    @Override
    public Condicao convertToEntityAttribute(Integer id) {
        if (id == null) {
            return null;
        }
        return Condicao.value(id);
    }
}
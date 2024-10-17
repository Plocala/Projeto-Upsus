package org.acme.model.conveterjpa;


import org.acme.model.StatusTarefa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@Converter(autoApply = true)
public class StatusTarefaConverter implements AttributeConverter<StatusTarefa, Integer> {

    @Override
    public Integer convertToDatabaseColumn(StatusTarefa statusTarefa) {
        if (statusTarefa == null) {
            return null;
        }
        return statusTarefa.getId();
    }

    @Override
    public StatusTarefa convertToEntityAttribute(Integer id) {
        if (id == null) {
            return null;
        }
        for (StatusTarefa status : StatusTarefa.values()) {
            if (status.getId() == id) {
                return status;
            }
        }
        throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                .entity("StatusTarefa not found for ID: " + id)
                .build());
    }
}
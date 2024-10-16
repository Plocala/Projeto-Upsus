package org.acme.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Telefone {
    String codigoArea;
    String numero;
    
    public String getCodigoArea() {
        return codigoArea;
    }
    public String getNumero() {
        return numero;
    }
    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
}
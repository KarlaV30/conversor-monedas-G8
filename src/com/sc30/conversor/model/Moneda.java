package com.sc30.conversor.model;

public class Moneda {
    private String nombre;
    private String codigo;
    private double tazaDeCambio;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getTazaDeCambio() {
        return tazaDeCambio;
    }

    public void setTazaDeCambio(double tazaDeCambio) {
        this.tazaDeCambio = tazaDeCambio;
    }
}

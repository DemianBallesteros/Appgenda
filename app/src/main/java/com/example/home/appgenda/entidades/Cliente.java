package com.example.home.appgenda.entidades;

/**
 * Created by Home on 06/04/2018.
 */

public class Cliente {

    private Integer id;
    private String nombre;
    private String telefono;
    private String informacion;

    public Cliente(Integer id, String nombre, String telefono, String informacion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.informacion = informacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}

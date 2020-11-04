package com.proyect.SalaMedica.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Document(collection = "Cliente")
public class Cliente {

    @Id
    private String id = new ObjectId().toString();

    private String identificacion;

    private  String nombre;

    private String telefono;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date fecha = new Date();

    private List<HistorialClinico> historialClinico = new ArrayList<>();

    public Cliente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<HistorialClinico> getHistorialClinico() {
        return historialClinico;
    }

    public void setHistorialClinico(List<HistorialClinico> historialClinico) {
        this.historialClinico = historialClinico;
    }
}

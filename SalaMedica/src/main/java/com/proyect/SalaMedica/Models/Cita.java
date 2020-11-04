package com.proyect.SalaMedica.Models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class Cita {

    @Id
    private String id = new ObjectId().toString();

    private String identificacionCliente;

    private String identificacionEmpleado;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date fecha = new Date();

    private String horaIni;

    private Date fechaCita = new Date();

    private String tipoCita;

    private String descripcionCita;

    public Cita() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    public String getIdentificacionEmpleado() {
        return identificacionEmpleado;
    }

    public void setIdentificacionEmpleado(String identificacionEmpleado) {
        this.identificacionEmpleado = identificacionEmpleado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(String tipoCita) {
        this.tipoCita = tipoCita;
    }

    public String getDescripcionCita() {
        return descripcionCita;
    }

    public void setDescripcionCita(String descripcionCita) {
        this.descripcionCita = descripcionCita;
    }
}

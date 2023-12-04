package com.example.luci;

public class Usuarios {
    String rut, nombre, fechaNacimiento, correoElectronico, direccion, planSalud, pass;
    String telefono;

    public Usuarios(){

    }

    public Usuarios(String rut, String nombre, String fechaNacimiento, String correoElectronico, String direccion, String planSalud, String telefono, String pass) {
        this.rut = rut;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.planSalud = planSalud;
        this.telefono = "" +telefono;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPlanSalud() {
        return planSalud;
    }

    public void setPlanSalud(String planSalud) {
        this.planSalud = planSalud;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = ""+telefono;
    }
}


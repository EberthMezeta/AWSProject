package mzt.awsproject.Models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class Profesor {

    @PositiveOrZero
    @NotNull
    private long id;

    @PositiveOrZero
    @NotNull
    private int numeroEmpleado;

    @NotEmpty(message = "No debe ser vacio")
    private String nombres;

    @NotEmpty(message = "No debe ser vacio")
    private String apellidos;

    @PositiveOrZero
    @NotNull
    private int horasClase;

    public Profesor(int numeroEmpleado, String nombres, String apellidos, int horasClase) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horasClase = horasClase;
    }

    public Profesor(long id, int numeroEmpleado, String nombres, String apellidos, int horasClase) {
        this.id = id;
        this.numeroEmpleado = numeroEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horasClase = horasClase;
    }

    public Profesor(){

    }

    public long getId() {
        return id;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id:" + id +
                ", numeroEmpleado:" + numeroEmpleado +
                ", nombres:'" + nombres + '\'' +
                ", apellidos:'" + apellidos + '\'' +
                ", horasClase:'" + horasClase + '\'' +
                '}';
    }
}

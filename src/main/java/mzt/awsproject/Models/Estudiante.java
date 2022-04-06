package mzt.awsproject.Models;

import org.hibernate.validator.constraints.Email;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Negative;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;


public class Estudiante {

    @PositiveOrZero
    @NotNull
    private long id;

    @NotEmpty(message = "No debe ser vacio")
    private String matricula;

    @NotEmpty(message = "No debe ser vacio")
    private String nombres;

    @NotEmpty(message = "No debe ser vacio")
    private String apellidos;

    @PositiveOrZero
    @NotNull
    private double promedio;

    public Estudiante(String matricula, String nombres, String apellidos, double promedio) {
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.promedio = promedio;
    }

    public Estudiante(long id, String matricula, String nombres, String apellidos, double promedio) {
        this.id = id;
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.promedio = promedio;
    }
    public Estudiante() {

    }



    public long getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id:" + id +
                ", matricula:" + matricula +
                ", nombres:" + nombres + '\'' +
                ", apellidos:" + apellidos + '\'' +
                ", promedio:" + promedio +
                '}';
    }
}

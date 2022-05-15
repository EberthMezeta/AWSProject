package mzt.awsproject.Models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Entity
@Table(name = "estudiante")
public class Estudiante implements Serializable {



    private static final long serialVersionUID = 1L;

    @PositiveOrZero
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante")
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

    private String fotoPerfilUrl;



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

    public String getFotoPerfilUrl() {
        return fotoPerfilUrl;
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


    public void setFotoPerfilUrl(String fotoPerfilUrl) {
        this.fotoPerfilUrl = fotoPerfilUrl;
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

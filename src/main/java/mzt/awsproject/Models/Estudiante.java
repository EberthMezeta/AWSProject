package mzt.awsproject.Models;

public class Estudiante {
    private long id;
    private long matricula;
    private String nombres;
    private String apellidos;
    private int promedio;

    public Estudiante(long matricula, String nombres, String apellidos, int promedio) {
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.promedio = promedio;
    }

    public Estudiante(long id, long matricula, String nombres, String apellidos, int promedio) {
        this.id = id;
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.promedio = promedio;
    }

    public long getId() {
        return id;
    }

    public long getMatricula() {
        return matricula;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getPromedio() {
        return promedio;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id:" + id +
                ", matricula:" + matricula +
                ", nombres:" + nombres + '\'' +
                ", apellidos:'" + apellidos + '\'' +
                ", promedio:" + promedio +
                '}';
    }
}

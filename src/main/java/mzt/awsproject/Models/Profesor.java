package mzt.awsproject.Models;

public class Profesor {
    private long id;
    private long numeroEmpleado;
    private String nombres;
    private String apellidos;
    private String horasClase;

    public Profesor(long numeroEmpleado, String nombres, String apellidos, String horasClase) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horasClase = horasClase;
    }

    public Profesor(long id, long numeroEmpleado, String nombres, String apellidos, String horasClase) {
        this.id = id;
        this.numeroEmpleado = numeroEmpleado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horasClase = horasClase;
    }

    public long getId() {
        return id;
    }

    public long getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getHorasClase() {
        return horasClase;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumeroEmpleado(long numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setHorasClase(String horasClase) {
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

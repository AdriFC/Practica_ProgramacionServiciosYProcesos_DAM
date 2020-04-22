package server;

public class Tarea {
    //Atributos
    private String descripción;
    private String estado;

    //Constructor vacío
    public Tarea(){
        descripción = "";
        estado = "";
    }

    //Getters y setters
    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //ToString
    @Override
    public String toString() {
        return "Tarea{" +
                "descripción='" + descripción + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}



package server;

public class Tarea {
    //Atributos
    private String description;
    private String estado;

    //Constructor vacío
    public Tarea(){
        description = "";
        estado = "";
    }

    //Getters y setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                "descripción='" + description +
                ", estado='" + estado +
                "}";
    }
}



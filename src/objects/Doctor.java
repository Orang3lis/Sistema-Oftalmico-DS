package objects;

public class Doctor {

//Anelis
    private String id;
    private String nombre;
    private String especialidad;
    private boolean disponible;

    public Doctor(String id, String nombre, String especialidad, boolean disponible) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.disponible = disponible;
    }

    //GETTERS
    public String getId() {return id;}
    
    public String getNombre() {return nombre;}

    public String getEspecialidad() {return especialidad;}

    public boolean isDisponible() {return disponible;}

    //SETTERS
    public String setId(String id) {this.id = id;}
    
    public String setNombre(String nombre) {this.nombre = nombre;}

    public String setEspecialidad(String especialidad) {this.especialidad = especialidad;}

    public boolean setDisponible(boolean disponible) {this.disponible = disponible;}

    @Override
    public String toString() {
        String estado = disponible ? "Disponible" : "No disponible";
        return "Doctor [ID: " + id + " | Nombre: " + nombre +
               " | Especialidad: " + especialidad + " | Estado: " + estado + "]";
    }
}
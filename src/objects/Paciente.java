package objects;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
    private String id;
    private String nombre;
    private int prioridad;
    private List<String> historialClinico;

    public Paciente(String id, String nombre, int prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.historialClinico = new ArrayList<>();
    }

    //GETTERS
    public String getId() {return id;}

    public String getNombre() {return nombre;}

    public int getPrioridad() {return prioridad;}

    public List<String> getHistorialClinico() {return historialClinico;}

    //SETTERS
    public void setId(String id) {this.id = id;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public void setPrioridad(int prioridad) {this.prioridad = prioridad;}

    public void agregarVisitaHistorial(String visita) {
        if (visita != null && !visita.isBlank()) {
            this.historialClinico.add(visita);
        }
    }

    @Override
    public String toString() {
        return "Paciente [ID: " + id + " | Nombre: " + nombre +
               " | Prioridad: " + prioridad +
               " | Visitas: " + historialClinico.size() + "]";
    }
    
}
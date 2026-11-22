package objects;

public class Empleado {
    private String id;
    private String nombre;
    private String rol; 
    private boolean activo;

    public Empleado(String id, String nombre, String rol, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.activo = activo;
    }

    //GETTERS
    public String getId() {return id;}

    public String getNombre() {return nombre;}
    
    public String getRol() {return rol;}
    
    public boolean isActivo() {return activo;}
   
    //SETTERS
    public void setId(String id) {this.id = id;}

    public void setNombre(String nombre) {this.nombre = nombre;}


    public void setRol(String rol) {this.rol = rol;}
    
    public void setActivo(boolean activo) {this.activo = activo;}

    @Override
    public String toString() {
        String estado = activo ? "Activo" : "Inactivo";
        return "Empleado [ID: " + id + " | Nombre: " + nombre +
               " | Rol: " + rol + " | Estado: " + estado + "]";
    }
    
}
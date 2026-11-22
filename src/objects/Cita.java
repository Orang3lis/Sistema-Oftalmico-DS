package objects;

//Anelis
public class Cita {
    private String idCita;
    private String idPaciente;
    private String idDoctor;
    private String fechaHora;
    private String signosVitales;
    private String notasVisita;
    private String estado; 

    public Cita(String idCita, String idPaciente, String idDoctor, String fechaHora, String estado) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.idDoctor = idDoctor;
        this.fechaHora = fechaHora;
        this.signosVitales = "Pendiente";
        this.notasVisita = "";
        this.estado = estado;
    }

    //GETTERS
    public String getIdCita() {return idCita;}

    public String getIdPaciente() {return idPaciente;}

    public String getIdDoctor() {return idDoctor;}

    public String getFechaHora() {return fechaHora;}

    public String getSignosVitales() {return signosVitales;}

    public String getNotasVisita() {return notasVisita;}

    public String getEstado() {return estado;}

    //SETTERS
    public void setIdCita(String idCita) {this.idCita = idCita;}

    public void setIdPaciente(String idPaciente) {this.idPaciente = idPaciente;}

    public void setIdDoctor(String idDoctor) {this.idDoctor = idDoctor;}

    public void setFechaHora(String fechaHora) {this.fechaHora = fechaHora;}

    public void setSignosVitales(String signosVitales) {this.signosVitales = signosVitales;}

    public void setNotasVisita(String notasVisita) {this.notasVisita = notasVisita;}

    public void setEstado(String estado) {this.estado = estado;}

    @Override
    public String toString() {
        return "Cita [ID: " + idCita + " | Paciente: " + idPaciente +
               " | Doctor: " + idDoctor + " | Fecha/Hora: " + fechaHora +
               " | Estado: " + estado + "]";
    }
    
}
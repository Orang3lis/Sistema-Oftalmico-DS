package methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import objects.Cita;
import objects.Doctor;
import objects.Empleado;
import objects.Paciente;

public class ClinicManager {
    
    private Map<String, Doctor> doctoresPorId;
    private Map<String, Empleado> empleadosPorId;

    
    private Map<String, Paciente> pacientesPorId;
    private Queue<Paciente> filaEsperaNormal;
    private PriorityQueue<Paciente> filaEmergencias;
    private List<Cita> citasProgramadas;
    private Stack<Cita> citasCompletadasRecientes;

    public ClinicManager() {
        this.doctoresPorId = new HashMap<>();
        this.empleadosPorId = new HashMap<>();
        this.pacientesPorId = new HashMap<>();
        this.filaEsperaNormal = new LinkedList<>();
        this.filaEmergencias = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.getPrioridad(), p1.getPrioridad()));
        this.citasProgramadas = new ArrayList<>();
        this.citasCompletadasRecientes = new Stack<>();
    }

//Anelis

    public boolean registrarEmpleado(Empleado empleado) {
        if (empleado == null || empleado.getId() == null || empleado.getId().isBlank()) {
            return false;
        }
        if (empleadosPorId.containsKey(empleado.getId())) {
            return false; // Evita duplicados por ID
        }
        empleadosPorId.put(empleado.getId(), empleado);
        return true;
    }

    public Empleado buscarEmpleadoPorId(String id) {
        if (id == null) {
            return null;
        }
        return empleadosPorId.get(id);
    }

    public boolean agregarDoctor(Doctor doctor) {
        if (doctor == null || doctor.getId() == null || doctor.getId().isBlank()) {
            return false;
        }
        if (doctoresPorId.containsKey(doctor.getId())) {
            return false;
        }
        doctoresPorId.put(doctor.getId(), doctor);
        return true;
    }

    public boolean eliminarDoctor(String idDoctor) {
        if (idDoctor == null) {
            return false;
        }
        return doctoresPorId.remove(idDoctor) != null;
    }

    public Doctor buscarDoctorPorId(String idDoctor) {
        if (idDoctor == null) {
            return null;
        }
        return doctoresPorId.get(idDoctor);
    }

    public List<Doctor> buscarDoctoresPorEspecialidad(String especialidad) {
        List<Doctor> resultados = new ArrayList<>();
        if (especialidad == null || especialidad.isBlank()) {
            return resultados;
        }
        for (Doctor doc : doctoresPorId.values()) {
            if (doc.getEspecialidad() != null &&
                doc.getEspecialidad().equalsIgnoreCase(especialidad.trim())) {
                resultados.add(doc);
            }
        }
        return resultados;
    }

    public List<Doctor> obtenerDoctoresDisponibles() {
        List<Doctor> disponibles = new ArrayList<>();
        for (Doctor doc : doctoresPorId.values()) {
            if (doc.isDisponible()) {
                disponibles.add(doc);
            }
        }
        return disponibles;
    }

    // ==========================================
    // BLOQUE 2: PACIENTES Y FILAS (COMPANERO/A 2)
    // ==========================================
    // TODO:
    // - registrarPaciente(Paciente paciente) evitando duplicados
    // - buscarPacientePorId(String id)
    // - agregarAFilaEspera(Paciente paciente)
    // - verFilaEspera()
    // - atenderEmergencia() [Bono]

    // ==========================================
    // BLOQUE 3: CITAS E HISTORIAL (COMPANERO/A 3)
    // ==========================================
    // TODO:
    // - concertarCita(Cita cita)
    // - cancelarCita(String idCita)
    // - verCitasDeHoy(String fechaHoy)
    // - asignarPacienteADoctor(String idPaciente, String idDoctor)
    // - registrarVisita(String idCita, String signosVitales, String notas)
    // - verHistorialClinico(String idPaciente) y verCitasCompletadasRecientes()
}
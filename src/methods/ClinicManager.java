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
    private Map<String, String> doctorPorPacienteAsignado;

    public ClinicManager() {
        this.doctoresPorId = new HashMap<>();
        this.empleadosPorId = new HashMap<>();
        this.pacientesPorId = new HashMap<>();
        this.filaEsperaNormal = new LinkedList<>();
        this.filaEmergencias = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p2.getPrioridad(), p1.getPrioridad())
        );
        this.citasProgramadas = new ArrayList<>();
        this.citasCompletadasRecientes = new Stack<>();
        this.doctorPorPacienteAsignado = new HashMap<>();
    }

    // Anelis

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

    // Dereck

    public boolean registrarPaciente(Paciente paciente) {
        if (paciente == null || paciente.getId() == null || paciente.getId().isBlank()) {
            return false;
        }
        return pacientesPorId.putIfAbsent(paciente.getId(), paciente) == null;
    }

    public Paciente buscarPacientePorId(String id) {
        return pacientesPorId.get(id);
    }

    public boolean agregarAFilaEspera(Paciente paciente) {
        Paciente registrado = paciente == null ? null : buscarPacientePorId(paciente.getId());
        return registrado != null && filaEsperaNormal.offer(registrado);
    }

    public List<Paciente> verFilaEspera() {
        // Copia la fila para que el menú pueda mostrarla sin modificarla.
        return new ArrayList<>(filaEsperaNormal);
    }

    public Paciente atenderSiguientePaciente() {
        return filaEsperaNormal.poll();
    }

    public boolean agregarAFilaEmergencias(Paciente paciente) {
        Paciente registrado = paciente == null ? null : buscarPacientePorId(paciente.getId());
        return registrado != null && filaEmergencias.offer(registrado);
    }

    public Paciente atenderEmergencia() {
        return filaEmergencias.poll();
    }

    //Xoralys

    public Cita buscarCitaPorId(String idCita) {
        if (idCita == null || idCita.isBlank()) {
            return null;
        }
        for (Cita cita : citasProgramadas) {
            if (cita.getIdCita().equals(idCita)) {
                return cita;
            }
        }
        return null;
    }

    public boolean concertarCita(Cita cita) {
        if (cita == null || cita.getIdCita() == null || cita.getIdCita().isBlank()) {
            return false; // Validación básica de la cita y su ID
        }
        if (buscarCitaPorId(cita.getIdCita()) != null) {
            return false;  // Evita duplicaciones por ID
        }
        if (buscarPacientePorId(cita.getIdPaciente()) == null) {
            return false;  // Verifica que el paciente exista
        }
        if (buscarDoctorPorId(cita.getIdDoctor()) == null) {
            return false;  // Verifica que el doctor exista
        }
        if(cita.getFechaHora() == null || cita.getFechaHora().isBlank()) {
            return false;  // Verifica que tenga fecha y hora 
        }

        for (Cita existente : citasProgramadas) {
            if (!"Cancelada".equals(existente.getEstado()) && 
            cita.getFechaHora().equals(existente.getFechaHora()) &&
            (cita.getIdDoctor().equals(existente.getIdDoctor()) || 
             cita.getIdPaciente().equals(existente.getIdPaciente()))) {
                return false; 
            }
        } // Evita citas simultaneas para un mismo doctor o paciente
        cita.setEstado("Programada");
        citasProgramadas.add(cita);
        return true;
    }

    public boolean cancelarCita(String idCita) {
        Cita cita = buscarCitaPorId(idCita);

        if (cita == null) {
            return false; // cita no existe 
        }
        if (!"Programada".equalsIgnoreCase(cita.getEstado())) {
            return false; // no se puede cancelar            
        }
        cita.setEstado("Cancelada");
        return true;
    }

    public List<Cita> verCitasDeHoy(String fechaHoy) {
        List<Cita> resultados = new ArrayList<>();

        if (fechaHoy == null || fechaHoy.isBlank()) {
            return resultados; // fecha invalida
        } 

        for (Cita cita: citasProgramadas) {
            if (cita.getFechaHora() != null &&
                cita.getFechaHora().startsWith(fechaHoy) &&
                "Programada".equalsIgnoreCase(cita.getEstado())) {
                resultados.add(cita);
            }
        }
        return resultados;
    }

    public boolean asignarPacienteADoctor(String idPaciente, String idDoctor) {
        Paciente paciente = buscarPacientePorId(idPaciente);
        Doctor doctor = buscarDoctorPorId(idDoctor);

        if (paciente == null || doctor == null) {
            return false; // paciente o doctor no existen
        }
        if (!doctor.isDisponible()) {
            return false; // doctor no disponible
        }
        if (doctorPorPacienteAsignado.containsKey(idPaciente)) {
            return false; //paciente ya tiene doctor asignado
        }

        doctorPorPacienteAsignado.put(idPaciente, idDoctor);
        doctor.setDisponible(false); 
        return true;
    }    

    public boolean registrarVisita(String idCita, String signosVitales, String notas) {
        Cita cita = buscarCitaPorId(idCita);

        if (cita == null) {
            return false; // cita no existe
        }
        if (!"Programada".equalsIgnoreCase(cita.getEstado())) {
            return false; // cita no esta programada
        }   

        Paciente paciente = buscarPacientePorId(cita.getIdPaciente());
        Doctor doctor = buscarDoctorPorId(cita.getIdDoctor());

        if (paciente == null || doctor == null) {
            return false; // paciente o doctor no existen
        }
        if (signosVitales == null || signosVitales.isBlank() || notas == null) {
            return false; // signos vitales o notas invalidas
        }
        if (!cita.getIdDoctor().equals(doctorPorPacienteAsignado.get(cita.getIdPaciente()))) {
            return false; // paciente no asignado a este doctor
        }

        cita.setSignosVitales(signosVitales);
        cita.setNotasVisita(notas);
        cita.setEstado("Completada");

        String visita = "Cita: " + cita.getIdCita() + 
                        " | Fecha: " + cita.getFechaHora() +
                        " | Doctor: " + cita.getIdDoctor() +
                        " | Signos Vitales: " + signosVitales +
                        " | Notas: " + notas;

        paciente.agregarVisitaHistorial(visita); 
        citasCompletadasRecientes.push(cita);
        doctorPorPacienteAsignado.remove(cita.getIdPaciente());
        doctor.setDisponible(true);
        return true;

    }

    public List<String> verHistorialClinico(String idPaciente) {
        List<String> resultados = new ArrayList<>();
        Paciente paciente = buscarPacientePorId(idPaciente);

        if (paciente == null) {
            return resultados; // paciente no existe
        }

        List<String> historial = paciente.getHistorialClinico();

        for (int i = historial.size() - 1; i >= 0; i--) {
            resultados.add(historial.get(i));
        }
        return resultados;
    }

    public List<Cita> verCitasCompletadasRecientes() {
        List<Cita> resultados = new ArrayList<>();

        for (int i = citasCompletadasRecientes.size() - 1; i >= 0; i--) {
            resultados.add(citasCompletadasRecientes.get(i));
        }
        return resultados;
    }
}
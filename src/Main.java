<<<<<<< Updated upstream
=======
import java.util.Scanner;
import methods.ClinicManager;
import objects.Paciente;
import objects.Doctor;
import objects.Empleado;
import objects.Cita;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClinicManager manager = new ClinicManager();

        String option;

        do {
            mostrarMenu();
            System.out.print("Seleccione una opcion: ");
            option = scanner.nextLine();

            switch (option) {

                case "1": {
                    System.out.print("ID del empleado: ");
                    String id = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Rol: ");
                    String rol = scanner.nextLine();

                    Empleado empleado = new Empleado(id, nombre, rol, true);

                    if (manager.registrarEmpleado(empleado)) {
                        System.out.println("Empleado registrado exitosamente.");
                        System.out.println("================================");
                    } else {
                        System.out.println("No se pudo registrar el empleado.");
                        System.out.println("================================");
                    }
                    break;
                }
                
                case "2": {
                    System.out.print("ID del empleado: ");
                    String id = scanner.nextLine();

                    Empleado empleado = manager.buscarEmpleadoPorId(id);

                    if (empleado != null) {
                        System.out.println(empleado);
                    } else {
                        System.out.println("Empleado no encontrado.");
                        System.out.println("================================");
                    }
                    break;
                }

                case "3":{
                    System.out.print("ID del doctor: ");
                    String id = scanner.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Especialidad: ");
                    String especialidad = scanner.nextLine();

                    Doctor doctor = new Doctor(id, nombre, especialidad, true);

                    if (manager.agregarDoctor(doctor)) {
                        System.out.println("Doctor registrado exitosamente.");
                        System.out.println("================================");
                    } else {
                        System.out.println("No se pudo registrar el doctor.");
                        System.out.println("================================");
                    }
                    break;
                }

                case "4":{
                    System.out.print("ID del doctor: ");
                    String id = scanner.nextLine();

                    if (manager.eliminarDoctor(id)) {
                        System.out.println("Doctor eliminado exitosamente.");
                        System.out.println("================================");
                    } else {
                        System.out.println("Doctor no encontrado.");
                        System.out.println("================================");
                    }
                    break;
                }

                case "5": {
                    System.out.print("ID del doctor: ");
                    String id = scanner.nextLine();

                    Doctor doctor = manager.buscarDoctorPorId(id);

                    if (doctor != null) {
                        System.out.println(doctor);
                    } else {
                        System.out.println("Doctor no encontrado.");
                        System.out.println("================================");
                    }
                    break;
                }

                case "6": {
                    System.out.print("Especialidad: ");
                    String especialidad = scanner.nextLine();
                    System.out.println(manager.buscarDoctoresPorEspecialidad(especialidad));
                    System.out.println("================================");
                    break;
                }

                case "7": {
                    System.out.println(manager.obtenerDoctoresDisponibles());
                    System.out.println("================================");
                    break;
                }

                case "8": {
                    System.out.print("ID del paciente: ");
                    String id = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Prioridad: ");
                    int prioridad;

                    try {
                        prioridad = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Prioridad invalida.");
                        break;
                    }

                    Paciente paciente = new Paciente(id, nombre, prioridad);

                    if (manager.registrarPaciente(paciente)) {
                        System.out.println("Paciente registrado exitosamente.");
                        System.out.println("================================");
                    } else {
                        System.out.println("No se pudo registrar el paciente.");
                        System.out.println("================================");
                    }
                    break;
                }

                case "9": {
                        System.out.print("ID del paciente: ");
                        String id = scanner.nextLine();

                        Paciente paciente = manager.buscarPacientePorId(id);

                        if (paciente != null) {
                            System.out.println(paciente);
                        } else {
                            System.out.println("Paciente no encontrado.");
                            System.out.println("================================");
                        }
                        break;
                }

                case "10": {
                    System.out.print("ID del paciente: ");
                    String id = scanner.nextLine();

                    Paciente paciente = manager.buscarPacientePorId(id);

                    if (manager.agregarAFilaEspera(paciente)) {
                        System.out.println("Paciente agregado a la fila de espera.");
                        System.out.println("================================");
                    } else {
                        System.out.println("No se pudo agregar el paciente.");
                        System.out.println("================================");
                    }
                    break;
                }

                case "11": {
                    System.out.println(manager.verFilaEspera());
                    System.out.println("================================");
                    break;
                }

                case "12": {
                    Paciente paciente = manager.atenderSiguientePaciente();

                    if (paciente != null) {
                        System.out.println("Atendiendo: " + paciente);
                        System.out.println("================================");
                    } else {
                        System.out.println("No hay pacientes en espera.");
                        System.out.println("================================");
                    }
                    break;
                }

                case "13": {
                    System.out.print("ID del paciente: ");
                    String id = scanner.nextLine();

                    Paciente paciente = manager.buscarPacientePorId(id);

                    if (manager.agregarAFilaEmergencias(paciente)) {
                        System.out.println("Paciente agregado a emergencias.");
                        System.out.println("================================");
                    } else {
                        System.out.println("No se pudo agregar el paciente.");
                        System.out.println("================================");
                    }
                    break;
                }

                case "14": {
                    Paciente paciente = manager.atenderEmergencia();

                    if (paciente != null) {
                        System.out.println("Atendiendo emergencia: " + paciente);
                        System.out.println("================================");
                    } else {
                        System.out.println("No hay pacientes en emergencias.");
                        System.out.println("================================");
                    }
                    break;
                }

                case "15": {
                    System.out.print("ID de la cita: ");
                    String idCita = scanner.nextLine();

                    System.out.print("ID del paciente: ");
                    String idPaciente = scanner.nextLine();

                    System.out.print("ID del doctor: ");
                    String idDoctor = scanner.nextLine();

                    System.out.print("Fecha y hora (YYYY-MM-DD HH:MM): ");
                    String fechaHora = scanner.nextLine();

                    Cita cita = new Cita(idCita, idPaciente, idDoctor, fechaHora, "Programada");

                    if (manager.concertarCita(cita)) {
                        System.out.println("Cita concertada exitosamente.");
                        System.out.println("================================");
                    } else {
                        System.out.println("No se pudo concertar la cita.");
                        System.out.println("================================");
                    }
                    break;
                }

                case "16": {
                    System.out.print("ID de la cita: ");
                    String idCita = scanner.nextLine();

                    if (manager.cancelarCita(idCita)) {
                        System.out.println("Cita cancelada exitosamente.");
                        System.out.println("================================");
                    } else {
                        System.out.println("No se pudo cancelar la cita.");
                        System.out.println("================================");
                    }
                    break;
                }

                case "17": {
                    String fechaHoy = java.time.LocalDate.now().toString();

                    System.out.println(manager.verCitasDeHoy(fechaHoy));
                    System.out.println("================================");
                    break;
                }

                case "18": {
                    System.out.print("ID del paciente: ");
                    String idPaciente = scanner.nextLine();

                    System.out.print("ID del doctor: ");
                    String idDoctor = scanner.nextLine();

                    if (manager.asignarPacienteADoctor(idPaciente, idDoctor)) {
                        System.out.println("Doctor asignado exitosamente.");
                        System.out.println("================================");
                    } else {
                        System.out.println("No se pudo asignar el doctor.");
                        System.out.println("================================");
                    }
                    break;
                }    

                case "19": {
                    System.out.print("ID de la cita: ");
                    String idCita = scanner.nextLine();

                    System.out.print("Signos vitales: ");
                    String signosVitales = scanner.nextLine();

                    System.out.print("Notas de la visita: ");
                    String notas = scanner.nextLine();

                    if (manager.registrarVisita(idCita, signosVitales, notas)) {
                        System.out.println("Visita registrada exitosamente.");
                        System.out.println("================================");
                    } else {
                        System.out.println("No se pudo registrar la visita.");
                        System.out.println("================================");
                    }
                    break;
                }

                case "20": {
                    System.out.print("ID del paciente: ");
                    String idPaciente = scanner.nextLine();

                    System.out.println(manager.verHistorialClinico(idPaciente));
                    System.out.println("================================");
                    break;
                }

                case "21": {
                    System.out.println(manager.verCitasCompletadasRecientes());
                    System.out.println("================================");
                    break;
                }

                case "0":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    System.out.println("================================");
                    break;
            }

        } while (!option.equals("0"));

        scanner.close();
    }

    public static void mostrarMenu() {

        System.out.println("================================");
        System.out.println("=== Clínica Oftálmica ===");
        System.out.println("================================");
        System.out.println("1. Registrar empleado");
        System.out.println("2. Buscar empleado");
        System.out.println("3. Agregar doctor");
        System.out.println("4. Eliminar doctor");
        System.out.println("5. Buscar doctor por ID");
        System.out.println("6. Buscar doctores por especialidad");
        System.out.println("7. Ver doctores disponibles");
        System.out.println("8. Registrar paciente");
        System.out.println("9. Buscar paciente");
        System.out.println("10. Agregar paciente a fila de espera");
        System.out.println("11. Ver fila de espera");
        System.out.println("12. Atender siguiente paciente");
        System.out.println("13. Agregar paciente a emergencias");
        System.out.println("14. Atender emergencia");
        System.out.println("15. Concertar cita");
        System.out.println("16. Cancelar cita");
        System.out.println("17. Ver citas de hoy");
        System.out.println("18. Asignar paciente a doctor");
        System.out.println("19. Registrar visita");
        System.out.println("20. Ver historial clinico");
        System.out.println("21. Ver citas completadas recientes");
        System.out.println("0. Salir");

        System.out.println("================================");
    }
}
>>>>>>> Stashed changes

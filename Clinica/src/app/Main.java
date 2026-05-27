package app;

import java.util.Scanner;
import modelo.*;
import servicio.EmpleadoServicio;
import util.Validador;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static EmpleadoServicio servicio = new EmpleadoServicio();

    public static void main(String[] args) {

        int opcion = 0;

        do {
            try {
                System.out.println("\n===== CLÍNICA SALUD TOTAL =====");
                System.out.println("1. Registrar médico");
                System.out.println("2. Registrar administrativo");
                System.out.println("3. Mostrar empleados");
                System.out.println("4. Buscar por cédula");
                System.out.println("5. Reemplazar información");
                System.out.println("6. Eliminar registro");
                System.out.println("7. Calcular pagos");
                System.out.println("8. Mostrar estadísticas");
                System.out.println("9. Salir");
                System.out.print("Opción: ");

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1 -> registrarMedico();
                    case 2 -> registrarAdministrativo();
                    case 3 -> servicio.mostrar();
                    case 4 -> buscar();
                    case 5 -> reemplazar();
                    case 6 -> eliminar();
                    case 7 -> calcularPagos();
                    case 8 -> servicio.estadisticas();
                    case 9 -> System.out.println("Saliendo...");
                    default -> System.out.println("Error: opción inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: opción inválida.");
            }
        } while (opcion != 9);
    }

    // ---------------- REGISTROS ----------------

    public static void registrarMedico() {
        try {

            System.out.print("Cédula: ");
            String cedula = sc.nextLine();

            if (servicio.existeCedula(cedula)) {
                System.out.println("Error: cédula duplicada.");
                return;
            }

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());
            if (!Validador.esEdadValida(edad)) {
                System.out.println("Edad inválida.");
                return;
            }

            System.out.print("Teléfono: ");
            String telefono = sc.nextLine();
            if (!Validador.esNumero(telefono)) {
                System.out.println("Teléfono inválido.");
                return;
            }

            System.out.print("Correo: ");
            String correo = sc.nextLine();
            if (!Validador.esCorreoValido(correo)) {
                System.out.println("Correo inválido.");
                return;
            }

            System.out.print("Especialidad: ");
            String especialidad = sc.nextLine();

            System.out.print("Pacientes atendidos: ");
            int pacientes = Integer.parseInt(sc.nextLine());
            if (!Validador.esPositivo(pacientes)) {
                System.out.println("Debe ser mayor a cero.");
                return;
            }

            System.out.print("Valor consulta: ");
            double valor = Double.parseDouble(sc.nextLine());
            if (!Validador.esPositivo(valor)) {
                System.out.println("Debe ser mayor a cero.");
                return;
            }

            servicio.registrar(new Medico(cedula, nombre, edad, telefono, correo,
                    especialidad, pacientes, valor));

        } catch (Exception e) {
            System.out.println("Error en los datos.");
        }
    }

    public static void registrarAdministrativo() {
        try {

            System.out.print("Cédula: ");
            String cedula = sc.nextLine();
            if (servicio.existeCedula(cedula)) {
                System.out.println("Error: cédula duplicada.");
                return;
            }

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());
            if (!Validador.esEdadValida(edad)) {
                System.out.println("Edad inválida.");
                return;
            }

            System.out.print("Teléfono: ");
            String telefono = sc.nextLine();
            if (!Validador.esNumero(telefono)) {
                System.out.println("Teléfono inválido.");
                return;
            }

            System.out.print("Correo: ");
            String correo = sc.nextLine();
            if (!Validador.esCorreoValido(correo)) {
                System.out.println("Correo inválido.");
                return;
            }

            System.out.print("Departamento: ");
            String departamento = sc.nextLine();

            System.out.print("Horas trabajadas: ");
            int horas = Integer.parseInt(sc.nextLine());
            if (!Validador.esPositivo(horas)) {
                System.out.println("Debe ser mayor a cero.");
                return;
            }

            System.out.print("Valor por hora: ");
            double valor = Double.parseDouble(sc.nextLine());
            if (!Validador.esPositivo(valor)) {
                System.out.println("Debe ser mayor a cero.");
                return;
            }

            servicio.registrar(new Administrativo(cedula, nombre, edad, telefono, correo,
                    departamento, horas, valor));

        } catch (Exception e) {
            System.out.println("Error en los datos.");
        }
    }

    // ---------------- UTILIDADES ----------------

    public static void buscar() {
        System.out.print("Cédula a buscar: ");
        String cedula = sc.nextLine();
        Empleado e = servicio.buscar(cedula);

        if (e == null)
            System.out.println("Registro no encontrado.");
        else
            e.mostrarInformacion();
    }

    public static void reemplazar() {
        System.out.print("Cédula a reemplazar: ");
        String cedula = sc.nextLine();

        if (!servicio.existeCedula(cedula)) {
            System.out.println("Registro no existe.");
            return;
        }

        System.out.println("Debe registrar nuevamente los datos.");
        registrarAdministrativo(); // O registrarMedico, según el caso
    }

    public static void eliminar() {
        System.out.print("Cédula a eliminar: ");
        String cedula = sc.nextLine();

        if (servicio.eliminar(cedula))
            System.out.println("Eliminado con éxito.");
        else
            System.out.println("Registro no encontrado.");
    }

    public static void calcularPagos() {
        System.out.print("Cédula: ");
        String cedula = sc.nextLine();
        Empleado e = servicio.buscar(cedula);

        if (e == null) {
            System.out.println("Registro no encontrado.");
        } else {
            System.out.println("Pago total: " + e.calcularPago());
        }
    }
}
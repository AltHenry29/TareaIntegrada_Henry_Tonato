package servicio;

import java.util.ArrayList;
import modelo.*;
import util.Validador;

public class EmpleadoServicio {

    private ArrayList<Empleado> lista = new ArrayList<>();

    public boolean existeCedula(String cedula) {
        for (Empleado e : lista) {
            if (e.getCedula().equals(cedula)) return true;
        }
        return false;
    }

    public void registrar(Empleado e) {
        lista.add(e);
        System.out.println("Registro añadido con éxito.");
    }

    public void mostrar() {
        if (lista.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return;
        }
        for (Empleado e : lista) {
            e.mostrarInformacion();
        }
    }

    public Empleado buscar(String cedula) {
        for (Empleado e : lista) {
            if (e.getCedula().equals(cedula)) return e;
        }
        return null;
    }

    public boolean eliminar(String cedula) {
        Empleado e = buscar(cedula);
        if (e != null) {
            lista.remove(e);
            return true;
        }
        return false;
    }

    public void reemplazar(String cedula, Empleado nuevo) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula().equals(cedula)) {
                lista.set(i, nuevo);
                System.out.println("Información reemplazada con éxito.");
                return;
            }
        }
    }

    public void estadisticas() {
        int medicos = 0, admin = 0;
        double pagoMedicos = 0, pagoAdmin = 0;
        Empleado mayorIngreso = null;

        for (Empleado e : lista) {
            double pago = e.calcularPago();

            if (e instanceof Medico) {
                medicos++;
                pagoMedicos += pago;
            } else {
                admin++;
                pagoAdmin += pago;
            }

            if (mayorIngreso == null || pago > mayorIngreso.calcularPago()) {
                mayorIngreso = e;
            }
        }

        System.out.println("\n===== ESTADÍSTICAS =====");
        System.out.println("Total médicos: " + medicos);
        System.out.println("Total administrativos: " + admin);
        System.out.println("Total empleados: " + lista.size());
        System.out.println("Pago total médicos: " + pagoMedicos);
        System.out.println("Pago total administrativos: " + pagoAdmin);

        if (mayorIngreso != null) {
            System.out.println("Empleado con mayor ingreso:");
            mayorIngreso.mostrarInformacion();
        }
    }
}
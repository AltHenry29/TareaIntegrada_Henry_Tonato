Sistema de Gestión de Personal – Clínica Salud Total

Proyecto en Java | POO | CRUD | Validaciones | Excepciones

Este sistema permite gestionar médicos y personal administrativo de una clínica privada, implementando principios de Programación Orientada a Objetos y cumpliendo con los requerimientos funcionales establecidos.

Estructura del Proyecto

src/

│
├── modelo/
│   ├── Empleado.java
│   ├── Medico.java
│   └── Administrativo.java
│

├── servicio/
│   └── EmpleadoServicio.java
│

├── util/
│   └── Validador.java
│

└── app/
    └── Main.java
Descripción del Sistema

El sistema permite ejecutar las siguientes operaciones:

Registrar médicos y administrativos
Mostrar todos los empleados
Buscar por cédula
Reemplazar información
Eliminar registros
Calcular pagos
Mostrar estadísticas
Realizar validaciones estrictas
Manejar excepciones
Utilizar polimorfismo con ArrayList<Empleado>

Diagrama UML
classDiagram
    class Empleado {
        -String cedula
        -String nombre
        -int edad
        -String telefono
        -String correo
        +mostrarInformacion()
        +calcularPago()
    }

    class Medico {
        -String especialidad
        -int numeroPacientesAtendidos
        -double valorConsulta
        +calcularPago()
    }

    class Administrativo {
        -String departamento
        -int horasTrabajadas
        -double valorHora
        +calcularPago()
    }

    class EmpleadoServicio {
        +registrarEmpleado()
        +mostrarEmpleados()
        +buscarPorCedula()
        +reemplazarInformacion()
        +eliminarRegistro()
        +calcularPagos()
        +estadisticas()
    }

    class Validador {
        +validarEntero()
        +validarDouble()
        +validarCedulaDuplicada()
        +validarTextoNoVacio()
        +validarCorreo()
        +validarTelefono()
    }

    class Main {
        +main()
    }

    Empleado <|-- Medico
    Empleado <|-- Administrativo
    EmpleadoServicio --> Empleado
    Main --> EmpleadoServicio
    
Conceptos Aplicados de Programación Orientada a Objetos
Herencia

Se implementa una clase padre Empleado que contiene atributos y métodos comunes para todo el personal de la clínica.

Las clases hijas Medico y Administrativo heredan de Empleado y añaden sus propios atributos y comportamientos específicos.

Esto permite reutilizar código, reducir duplicación y mejorar la organización del sistema.

Encapsulamiento

Todos los atributos de las clases están declarados como privados.
El acceso se realiza mediante getters y setters.

Beneficios:

Protección de datos
Control de acceso
Integridad de los objetos
Polimorfismo

Se aplica usando:

ArrayList<Empleado> lista = new ArrayList<>();

Permite almacenar tanto médicos como administrativos en la misma colección y llamar métodos como:

calcularPago()
mostrarInformacion()

Cada clase hija implementa su propia versión del método (sobrescritura).

Manejo de Excepciones

El proyecto utiliza bloques try-catch para capturar errores comunes como:

Ingreso de letras en lugar de números
Conversión inválida (NumberFormatException)
Datos fuera de rango
Búsqueda de cédulas inexistentes

Ejemplo:

try {
    int opcion = Integer.parseInt(sc.nextLine());
} catch (NumberFormatException e) {
    System.out.println("Error: opción inválida.");
}
Conversiones

Se usan conversiones obligatorias para procesar datos numéricos ingresados como texto:

Integer.parseInt()
Double.parseDouble()
Validaciones

Las validaciones fueron implementadas en la clase Validador:

Valores numéricos mayores a cero
Edad válida (1–149)
Cédula no duplicada
Campos obligatorios no vacíos
Correo con formato correcto (@ y .)
Teléfono compuesto solo por números
Opción válida en el menú

Estas validaciones aseguran robustez y evitan fallas en tiempo de ejecución.

Estadísticas del Sistema

El módulo de estadísticas muestra:

Total de médicos
Total de administrativos
Total de empleados
Pago total a médicos
Pago total a administrativos
Empleado con mayor ingreso
Ejecución

Compilación:

javac src/**/*.java

Ejecución:

java src/app/Main

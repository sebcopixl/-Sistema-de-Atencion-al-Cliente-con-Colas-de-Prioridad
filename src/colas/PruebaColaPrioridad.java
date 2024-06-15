package colas;

import java.util.Scanner;

public class PruebaColaPrioridad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidadPrioridadAlta, cantidadPrioridadMedia, cantidadPrioridadBaja;

        System.out.println("Bienvenido al Sistema de Atención al Cliente");

        cantidadPrioridadAlta = obtenerCantidadClientes(scanner, "prioridad alta");
        cantidadPrioridadMedia = obtenerCantidadClientes(scanner, "prioridad media");
        cantidadPrioridadBaja = obtenerCantidadClientes(scanner, "prioridad baja");

        ColaDePrioridad<Cliente> cola = generarColaClientes(cantidadPrioridadAlta, cantidadPrioridadMedia, cantidadPrioridadBaja);

        int opcion;

        do {
            System.out.println("______________________________________________________________");
            System.out.println("1. Atender siguiente cliente");
            System.out.println("2. Mostrar cola de espera");
            System.out.println("3. Agregar nuevos clientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Cliente cliente = cola.desencolar();
                    if (cliente != null) {
                        System.out.println("Atendiendo a " + cliente);
                    } else {
                        System.out.println("No hay clientes por atender.");
                    }
                    break;
                case 2:
                    System.out.println("Cola de espera:");
                    cola.mostrarEstadoColas();
                    break;
                case 3:
                    agregarClientes(scanner, cola);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static int obtenerCantidadClientes(Scanner scanner, String prioridad) {
        int cantidad;
        while (true) {
            System.out.println("Ingrese la cantidad de clientes en la " + prioridad + ":");
            if (scanner.hasNextInt()) {
                cantidad = scanner.nextInt();
                break;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Clear the invalid input
            }
        }
        return cantidad;
    }
    //ColaDePrioridad<Cliente> se encarga de generar la cola de prioridad de clientes segun la cantidad de clientes en cada nivel de prioridad ingresada, esto con el fin de probar el programa
    private static ColaDePrioridad<Cliente> generarColaClientes(int cantidadPrioridadAlta, int cantidadPrioridadMedia, int cantidadPrioridadBaja) {
        ColaDePrioridad<Cliente> cola = new ColaDePrioridad<>();
        for (int i = 0; i < cantidadPrioridadAlta; i++) {
            cola.encolar(new Cliente("A", i + 1));
        }
        for (int i = 0; i < cantidadPrioridadMedia; i++) {
            cola.encolar(new Cliente("M", i + 1));
        }
        for (int i = 0; i < cantidadPrioridadBaja; i++) {
            cola.encolar(new Cliente("B", i + 1));
        }
        return cola;
    }
//Segun el documento del examen se solicita lo siguiente:
//llegadaCliente(nombre, nivelPrioridad): A ̃nade un nuevo cliente a la cola de prioridad. El cliente se anade a la cola de prioridad correspondiente segun su nivel de prioridad
//en este caso le llame agregarClientes(Scanner scanner, ColaDePrioridad<Cliente> cola) y se encarga de agregar clientes a la cola de prioridad segun su nivel de prioridad
    private static void agregarClientes(Scanner scanner, ColaDePrioridad<Cliente> cola) {
        int prioridad;
        //En este while se encarga de validar que la prioridad ingresada sea valida
        while (true) {
            System.out.println("¿A qué cola desea agregar clientes?");
            System.out.println("1. Prioridad Alta");
            System.out.println("2. Prioridad Media");
            System.out.println("3. Prioridad Baja");
            System.out.print("Seleccione una opción: ");
            if (scanner.hasNextInt()) {
                prioridad = scanner.nextInt();
                if (prioridad < 1 || prioridad > 3) {
                    System.out.println("Opción no válida. Intente de nuevo.");
                } else {
                    break;
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // esta parte se encarga de limpiar el buffer de entradas invalidas
            }
        }
        //el cantidadClientes se encarga de almacenar la cantidad de clientes a agregar a la cola de prioridad
        int cantidadClientes;
        while (true) {
            System.out.println("Ingrese la cantidad de clientes a agregar:");
            if (scanner.hasNextInt()) {
                cantidadClientes = scanner.nextInt();
                break;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next(); // Aca limpiamos la entrada invalida de la cantidad de clientes
            }
        }

        scanner.nextLine(); // Aca limpiamos el buffer de la entrada de la cantidad de clientes para poder leer los apellidos
        for (int i = 0; i < cantidadClientes; i++) {
            int apellido;
            while (true) {
                System.out.print("Ingrese el apellido del cliente " + (i + 1) + ": ");
                if (scanner.hasNextInt()) {
                    apellido = scanner.nextInt();
                    scanner.nextLine(); // Acá limpiamos el buffer de la entrada del apellido para poder leer la siguiente prioridad
                    break;
                } else {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                    scanner.next(); // Aca limpiamos la entrada invalida del apellido
                }
            }
            //el switch se encarga de agregar el cliente a la cola de prioridad correspondiente segun su nivel de prioridad
            switch (prioridad) {
                case 1:
                    cola.encolar(new Cliente("A", apellido));
                    break;
                case 2:
                    cola.encolar(new Cliente("M", apellido));
                    break;
                case 3:
                    cola.encolar(new Cliente("B", apellido));
                    break;
            }
        }
    }
}

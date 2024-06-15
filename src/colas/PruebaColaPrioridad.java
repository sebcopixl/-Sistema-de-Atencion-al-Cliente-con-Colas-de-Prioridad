package colas;

import java.util.Scanner;

public class PruebaColaPrioridad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidadPrioridadAlta = 0, cantidadPrioridadMedia = 0, cantidadPrioridadBaja = 0;

        System.out.println("Bienvenido al Sistema de Atención al Cliente");

        cantidadPrioridadAlta = obtenerCantidadClientes(scanner, "prioridad alta");
        cantidadPrioridadMedia = obtenerCantidadClientes(scanner, "prioridad media");
        cantidadPrioridadBaja = obtenerCantidadClientes(scanner, "prioridad baja");

        ColaDePrioridad<String> cola = generarColaClientes(cantidadPrioridadAlta, cantidadPrioridadMedia, cantidadPrioridadBaja);

        int opcion;

        do {
            System.out.println("______________________________________________________________");
            System.out.println("1. Atender siguiente cliente");
            System.out.println("2. Mostrar cola de espera");
            System.out.println("3. Agregar nuevos clientes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            while (true) {
                String entrada = scanner.nextLine();
                if (esNumero(entrada)) {
                    opcion = Integer.parseInt(entrada);
                    break;
                } else {
                    System.out.println("Entrada no válida. Por favor, ingrese un número.");
                }
            }

            switch (opcion) {
                case 1:
                    String cliente = cola.desencolar();
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
            String entrada = scanner.nextLine();
            if (esNumero(entrada)) {
                cantidad = Integer.parseInt(entrada);
                break;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }
        return cantidad;
    }

    private static ColaDePrioridad<String> generarColaClientes(int cantidadPrioridadAlta, int cantidadPrioridadMedia, int cantidadPrioridadBaja) {
        ColaDePrioridad<String> cola = new ColaDePrioridad<>();
        for (int i = 0; i < cantidadPrioridadAlta; i++) {
            cola.encolar("A" + (i + 1), ColaDePrioridad.ALTA);
        }
        for (int i = 0; i < cantidadPrioridadMedia; i++) {
            cola.encolar("M" + (i + 1), ColaDePrioridad.MEDIA);
        }
        for (int i = 0; i < cantidadPrioridadBaja; i++) {
            cola.encolar("B" + (i + 1), ColaDePrioridad.BAJA);
        }
        return cola;
    }

    private static void agregarClientes(Scanner scanner, ColaDePrioridad<String> cola) {
        int prioridad;
        while (true) {
            System.out.println("¿A qué cola desea agregar clientes?");
            System.out.println("1. Prioridad Alta");
            System.out.println("2. Prioridad Media");
            System.out.println("3. Prioridad Baja");
            System.out.print("Seleccione una opción: ");
            String entrada = scanner.nextLine();
            if (esNumero(entrada)) {
                prioridad = Integer.parseInt(entrada);
                if (prioridad >= 1 && prioridad <= 3) {
                    break;
                } else {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }

        int cantidadClientes = 0;
        while (true) {
            System.out.println("Ingrese la cantidad de clientes a agregar:");
            String entrada = scanner.nextLine();
            if (esNumero(entrada)) {
                cantidadClientes = Integer.parseInt(entrada);
                break;
            } else {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
            }
        }

        for (int i = 0; i < cantidadClientes; i++) {
            System.out.print("Ingrese el nombre del cliente " + (i + 1) + ": ");
            String nombreCliente = scanner.nextLine();
            switch (prioridad) {
                case 1:
                    cola.encolar(nombreCliente, ColaDePrioridad.ALTA);
                    break;
                case 2:
                    cola.encolar(nombreCliente, ColaDePrioridad.MEDIA);
                    break;
                case 3:
                    cola.encolar(nombreCliente, ColaDePrioridad.BAJA);
                    break;
            }
        }
    }

    private static boolean esNumero(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

package colas;

import java.util.Scanner;

public class PruebaColaPrioridad {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidadPrioridadAlta, cantidadPrioridadMedia, cantidadPrioridadBaja;

        System.out.println("Bienvenido al Sistema de Atención al Cliente");
        System.out.println("Ingrese la cantidad de clientes en la prioridad alta:");
        cantidadPrioridadAlta = scanner.nextInt();
        System.out.println("Ingrese la cantidad de clientes en la prioridad media:");
        cantidadPrioridadMedia = scanner.nextInt();
        System.out.println("Ingrese la cantidad de clientes en la prioridad baja:");
        cantidadPrioridadBaja = scanner.nextInt();

        ColaDePrioridad<String> cola = generarColaClientes(cantidadPrioridadAlta, cantidadPrioridadMedia, cantidadPrioridadBaja);

        int opcion;

        do {
            System.out.println("______________________________________________________________");
            System.out.println("1. Atender siguiente cliente");
            System.out.println("2. Mostrar cola de espera");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

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
                    System.out.println("Saliendo del sistema. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 3);

        scanner.close();
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
}

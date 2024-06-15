package colas;

public class Cliente {
    private String prioridad;
    private int apellido;
    private String nombre;

    public Cliente(String prioridad, int apellido) {
        this.prioridad = prioridad;
        this.apellido = apellido;
        this.nombre = prioridad + apellido;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public int getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
/*
Segun lo indicado en el documento del examen, se solicita lo siguiente:
Cliente: Una clase que representa a un cliente con los siguientes atributos:
        • nombre: El nombre del cliente.
        • nivelPrioridad: El nivel de prioridad del cliente (un n ́umero entero).
        por cuestiones logica  establecida en mi metdodo desencolar() me tome la libertad de modificar un poco esta clase,
        para que el nombre sea la concatenacion de la prioridad y el apellido el cual es un integer, esto con el fin de que
        probar el programa en si sea mas practico y facil de entender los diferentes niveles de prioridad y casos.
        */

# Examen a ser calificado - Rama `seb_exam1`

El examen a ser calificado se encuentra en la rama `seb_exam1`. A continuación se detallan los archivos y las modificaciones realizadas en cada uno:

## Archivos actualizados y utilizados

### PruebaColaPrioridad.java

- Se ha actualizado para interactuar con el usuario y gestionar el sistema de atención al cliente.
- Contiene métodos para atender al siguiente cliente, mostrar la cola de espera y agregar nuevos clientes.

### ColaDePrioridad.java

- Define la clase `ColaDePrioridad`, que implementa la lógica de la cola de prioridad.
- Métodos para encolar, desencolar y mostrar el estado de las colas.

### Cliente.java

- Define la clase `Cliente`, que representa a un cliente con sus atributos.
- Modificado para que el nombre sea la concatenación de la prioridad y el apellido.

### Cola.java

- Implementa la interfaz `InterfazCola` que define las operaciones básicas de una cola.

## Métodos relevantes

- **obtenerCantidadClientes**: Obtiene la cantidad de clientes en cada nivel de prioridad.
- **generarColaClientes**: Genera la cola de clientes según la cantidad en cada nivel de prioridad.
- **agregarClientes**: Agrega nuevos clientes a la cola según su nivel de prioridad.

## Método innecesario

El método `desencolarComoCadena()` no se utiliza ya que la funcionalidad de convertir un cliente a cadena ya está implementada en el método `toString()` de la clase `Cliente`.

## Estado del examen

El examen ha sido completado y se encuentra listo para su revisión en la rama `seb_exam1`.

---

Este README ha sido generado utilizando GPT para proporcionar una descripción clara y concisa de los archivos y modificaciones realizadas. GPT también se ha utilizado para manejar casos especiales en el uso del programa, como entradas inválidas y otros escenarios que requieren validación.
El documento que hay que hacer correr para ejecutar el programa es: `PruebaColaPrioridad.java`.

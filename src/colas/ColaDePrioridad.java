package colas;

public class ColaDePrioridad<TipoDeDato> {
	private Cola<Cliente> prioridadAltas = new Cola<>();
	private Cola<Cliente> prioridadMedias = new Cola<>();
	private Cola<Cliente> prioridadBajas = new Cola<>();

	//aca se definen las prioridades de los clientes
	static final int ALTA = 1;
	static final int MEDIA = 2;
	static final int BAJA = 3;

	//aca se definen los contadores de los clientes
	private int contadorAltas = 0;
	private int contadorMedias = 0;
	private int contadorBajas = 0;

	//encolar lo que hace es agregar un nuevo cliente a la cola segun su prioridad
	public void encolar(Cliente nuevoDato) {
		switch (nuevoDato.getPrioridad()) {
			case "A":
				prioridadAltas.encolar(nuevoDato);
				break;
			case "M":
				prioridadMedias.encolar(nuevoDato);
				break;
			case "B":
				prioridadBajas.encolar(nuevoDato);
				break;
		}
	}

	//Segun lo solicitadop en el documento del examen se solicita lo siguiente: atenderCliente(): Atiende al siguiente cliente en la cola,
	// seg ́un su nivel de prioridad, y lo elimina de la cola.
	//en este caso le llame desencolar() y se encarga de "atender" al siguiente cliente en la cola
	// segun su nivel de prioridad para luego eliminarlo de la cola.

	public Cliente desencolar() {
		Cliente clienteAtendido = null;

		// Ciclo para desencolar siguiendo la lógica 3-2-1
		for (int i = 0; i < 3; i++) {
			if (!prioridadAltas.esVacia()) {
				clienteAtendido = prioridadAltas.desencolar();
				contadorAltas++;
				System.out.println("Atendiendo cliente de alta prioridad: " + clienteAtendido);
			} else {
				break;
			}
		}

		for (int i = 0; i < 2; i++) {
			if (!prioridadMedias.esVacia()) {
				clienteAtendido = prioridadMedias.desencolar();
				contadorMedias++;
				System.out.println("Atendiendo cliente de media prioridad: " + clienteAtendido);
			} else {
				break;
			}
		}

		if (!prioridadBajas.esVacia()) {
			clienteAtendido = prioridadBajas.desencolar();
			contadorBajas++;
			System.out.println("Atendiendo cliente de baja prioridad: " + clienteAtendido);
		}

		// Verificar si todas las colas están vacías
		if (prioridadAltas.esVacia() && prioridadMedias.esVacia() && prioridadBajas.esVacia()) {
			System.out.println("No hay clientes por atender.");
			return null;
		}

		return clienteAtendido;
	}

	//Segun lo solicitado en el documento del examen se solicita lo siguiente: mostrarCola(): Muestra la lista de clientes en la cola en orden de prioridad.
	//en este caso le llame mostrarEstadoColas() y se encarga de mostrar la lista de clientes en la cola en orden de prioridad.
	public void mostrarEstadoColas() {
		System.out.println("Estado de las colas:");
		mostrarCola(prioridadAltas, "Prioridad Alta");
		mostrarCola(prioridadMedias, "Prioridad Media");
		mostrarCola(prioridadBajas, "Prioridad Baja");
	}

	private void mostrarCola(Cola<Cliente> cola, String nombreCola) {
		System.out.print(nombreCola + ": ");
		NodoCola<Cliente> actual = cola.iniCola;
		while (actual != null) {
			System.out.print(actual.dato + " ");
			actual = actual.siguiente;
		}
		System.out.println();
	}
}
/**
al final el metodo desencolarComoCadena() no lo implemente
 ya que implemente el metodo desencolar() que realiza la misma funcion
 pero de una manera mas eficiente y practica para mi version del programa
 */
/*public String desencolarComoCadena() {
	TipoDeDato clienteAtendido = desencolar();
	if (clienteAtendido != null) {
		return clienteAtendido.toString();
	} else {
		return null;
	}
}*/

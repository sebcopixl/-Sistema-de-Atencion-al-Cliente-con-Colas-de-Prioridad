package colas;

/**
 * Clase que implementa una Cola de Prioridad mediante {@link Cola} internas.
 * Para evitar tener una version de esta clase por cada tipo de dato, se utiliza
 * Generics de Java para generalizar y parametrizar el tipo de dato a almacenar.
 *
 * @param <TipoDeDato> Tipo de Dato a almacenar dentro de la cola
 */
public class ColaDePrioridad<TipoDeDato> {
	private Cola<TipoDeDato> prioridadAltas = new Cola<>();
	private Cola<TipoDeDato> prioridadMedias = new Cola<>();
	private Cola<TipoDeDato> prioridadBajas = new Cola<>();

	static final int ALTA = 1;
	static final int MEDIA = 2;
	static final int BAJA = 3;

	private int contadorAltas = 0;
	private int contadorMedias = 0;
	private int contadorBajas = 0;

	public void encolar(TipoDeDato nuevoDato, int prioridad) {
		switch (prioridad) {
			case ALTA:
				prioridadAltas.encolar(nuevoDato);
				break;
			case MEDIA:
				prioridadMedias.encolar(nuevoDato);
				break;
			case BAJA:
				prioridadBajas.encolar(nuevoDato);
				break;
			default:
				throw new IllegalArgumentException("Prioridad no válida: " + prioridad);
		}
	}

	public TipoDeDato desencolar() {
		TipoDeDato clienteAtendido = null;
		boolean atendido = false;

		// Ciclo para desencolar siguiendo la lógica 3-2-1
		for (int i = 0; i < 3; i++) {
			if (!prioridadAltas.esVacia()) {
				clienteAtendido = prioridadAltas.desencolar();
				contadorAltas++;
				atendido = true;
				System.out.println("Atendiendo cliente de alta prioridad: " + clienteAtendido);
			} else {
				break;
			}
		}

		for (int i = 0; i < 2; i++) {
			if (!prioridadMedias.esVacia()) {
				clienteAtendido = prioridadMedias.desencolar();
				contadorMedias++;
				atendido = true;
				System.out.println("Atendiendo cliente de media prioridad: " + clienteAtendido);
			} else {
				break;
			}
		}

		if (!prioridadBajas.esVacia()) {
			clienteAtendido = prioridadBajas.desencolar();
			contadorBajas++;
			atendido = true;
			System.out.println("Atendiendo cliente de baja prioridad: " + clienteAtendido);
		}

		// Verificar si todas las colas están vacías
		if (prioridadAltas.esVacia() && prioridadMedias.esVacia() && prioridadBajas.esVacia()) {
			System.out.println("No hay clientes por atender.");
			return null;
		}

		// Verificar si no se atendió a ningún cliente y resetear contadores
		if (!atendido) {
			contadorAltas = 0;
			contadorMedias = 0;
			contadorBajas = 0;
		}

		return clienteAtendido;
	}

	public void mostrarEstadoColas() {
		System.out.println("Estado de las colas:");
		mostrarCola(prioridadAltas, "Prioridad Alta");
		mostrarCola(prioridadMedias, "Prioridad Media");
		mostrarCola(prioridadBajas, "Prioridad Baja");
	}

	private void mostrarCola(Cola<TipoDeDato> cola, String nombreCola) {
		System.out.print(nombreCola + ": ");
		NodoCola<TipoDeDato> actual = cola.iniCola;
		while (actual != null) {
			System.out.print(actual.dato + " ");
			actual = actual.siguiente;
		}
		System.out.println();
	}
}

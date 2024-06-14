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
			case 1:
				prioridadAltas.encolar(nuevoDato);
				break;
			case 2:
				prioridadMedias.encolar(nuevoDato);
				break;
			case 3:
				prioridadBajas.encolar(nuevoDato);
				break;
		}
	}

	public TipoDeDato desencolar() {
		TipoDeDato clienteAtendido = null;

		// Atender clientes con prioridad alta
		if (contadorAltas < 3 && !prioridadAltas.esVacia()) {
			clienteAtendido = prioridadAltas.desencolar();
			contadorAltas++;
		} else if (contadorMedias < 2 && !prioridadMedias.esVacia()) {
			clienteAtendido = prioridadMedias.desencolar();
			contadorMedias++;
		} else if (contadorBajas < 1 && !prioridadBajas.esVacia()) {
			clienteAtendido = prioridadBajas.desencolar();
			contadorBajas++;
		} else {
			// Reiniciar los contadores y verificar si hay clientes en alguna de las filas
			contadorAltas = 0;
			contadorMedias = 0;
			contadorBajas = 0;

			// Verificar si hay clientes en alguna de las filas
			if (!prioridadAltas.esVacia() || !prioridadMedias.esVacia() || !prioridadBajas.esVacia()) {
				// Verificar si hay clientes en la prioridad alta
				if (!prioridadAltas.esVacia()) {
					clienteAtendido = prioridadAltas.desencolar();
					contadorAltas++;
				}
				// Verificar si hay clientes en la prioridad media
				else if (!prioridadMedias.esVacia()) {
					clienteAtendido = prioridadMedias.desencolar();
					contadorMedias++;
				}
				// Verificar si hay clientes en la prioridad baja
				else if (!prioridadBajas.esVacia()) {
					clienteAtendido = prioridadBajas.desencolar();
					contadorBajas++;
				}
			} else {
				System.out.println("No hay clientes por atender.");
			}
		}

		return clienteAtendido;
	}









	public String desencolarComoCadena() {
		TipoDeDato clienteAtendido = desencolar();
		if (clienteAtendido != null) {
			return clienteAtendido.toString();
		} else {
			return null;
		}
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

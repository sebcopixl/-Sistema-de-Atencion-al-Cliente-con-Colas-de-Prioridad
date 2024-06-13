package colas;

/**
 * Clase que implementa una Cola de Prioridad mediante {@link Cola} internas.
 * <p>
 * Para evitar tener una version de esta clase por cada tipo de dato, se utiliza
 * Generics de Java para generalizar y parametrizar el tipo de dato a almacenar.
 *
 * @param <TipoDeDato> Tipo de Dato a almacenar dentro de la cola
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public class ColaDePrioridad<TipoDeDato> {

	private Cola<TipoDeDato> prioridadAltas = new Cola<>();
	private Cola<TipoDeDato> prioridadMedia = new Cola<>();
	private Cola<TipoDeDato> prioridadBaja = new Cola<>();

	public void encolar(TipoDeDato nuevoDato, Integer prioridad) {

		switch (prioridad) {
		case 1:
			prioridadAltas.encolar(nuevoDato);
		case 2:
			prioridadMedia.encolar(nuevoDato);
			default:
				prioridadBaja.encolar(nuevoDato);
		}

	}

	public TipoDeDato desencolar() {
		TipoDeDato ret = null;

		//Por cada 3 pacientes desencoladas, se desencola 2 pacientes de prioridad media y finalmente 1 paciente de prioridad baja

		if (!prioridadAltas.esVacia()) {
			ret = prioridadAltas.desencolar();
		} else if (!prioridadMedia.esVacia()) {
			ret = prioridadMedia.desencolar();
		} else {
			ret = prioridadBaja.desencolar();
		}

		return ret;
	}
	//desencolarComoCadena() retorna un String con la prioridad del paciente y su nombre, basicamnete es igual al metodo desencolar() pero con un formato de salida diferente, la misma logica de desencolar() se debe aplicar aca
	public String desencolarComoCadena() {
		TipoDeDato ret;
		String out = null;

		if (!prioridadAltas.esVacia()) {
			ret = prioridadAltas.desencolar();
			out = "[ALTA] " + ret.toString();
		} else if (!prioridadMedia.esVacia()) {
			ret = prioridadMedia.desencolar();
			out = "[MEDIA] " + ret.toString();
		} else if (!prioridadBaja.esVacia()) {
			ret = prioridadBaja.desencolar();
			out = "[BAJA] " + ret.toString();
		} else {
			System.out.println("*** Colas vacías *** ");
		}

		return out;
	}

}

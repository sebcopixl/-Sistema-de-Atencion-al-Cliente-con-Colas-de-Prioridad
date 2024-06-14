package colas;

/**
 * Clase que implementa una Cola mediante Referencias ("punteros").
 * Para asegurarnos de que se defina minimamente lo especificado por la {@link InterfazCola},
 * esta clase implementa dicha Interfaz.
 * <p>
 * Para evitar tener una version de esta clase por cada tipo de dato, se utiliza
 * Generics de Java para generalizar y parametrizar el tipo de dato a almacenar.
 *
 * @param <TipoDeDato> Tipo de Dato a almacenar dentro de la cola
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public class Cola<TipoDeDato> implements InterfazCola<TipoDeDato> {

    NodoCola<TipoDeDato> iniCola;
    private NodoCola<TipoDeDato> finCola;
    private int tamanoCola;

    /**
     * Constructor de la clase, se inicializa la cola
     */
    public Cola() {
        tamanoCola = 0;
        iniCola = null;
        finCola = null;
    }

    @Override
    public void encolar(TipoDeDato nuevoDato) {
        NodoCola<TipoDeDato> nuevoNodo = new NodoCola<>();
        nuevoNodo.dato = nuevoDato;
        nuevoNodo.siguiente = null;

        if (esVacia()) {
            iniCola = nuevoNodo;
            finCola = nuevoNodo;
        } else {
            finCola.siguiente = nuevoNodo;
            finCola = nuevoNodo;
        }

        tamanoCola = tamanoCola + 1;
    }

    @Override
    public TipoDeDato desencolar() {
        TipoDeDato ret = null;
        if (!esVacia()) {
            ret = iniCola.dato;
            iniCola = iniCola.siguiente;
            tamanoCola = tamanoCola - 1;
        }
        return ret;
    }

    @Override
    public TipoDeDato obtenerFrente() {
        TipoDeDato ret = null;
        if (!esVacia()) {
            ret = iniCola.dato;
        }
        return ret;
    }

    @Override
    public void anular() {
        tamanoCola = 0;
        iniCola = null;
        finCola = null;
    }

    @Override
    public int tamanoCola() {
        return tamanoCola;
    }

    @Override
    public boolean esVacia() {
        return tamanoCola == 0;
    }
}

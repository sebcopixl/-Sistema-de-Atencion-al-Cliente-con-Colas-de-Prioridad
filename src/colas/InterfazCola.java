package colas;

/**
 * Interfaz que define las operaciones de una Cola
 *
 * @param <TipoDeDato> Tipo de Dato a almacenar dentro de la cola
 * @author Prof. Derlis Zarate (profderliszarate@gmail.com)
 * @author Prof. Saúl Zalimben (szalimben93@gmail.com)
 */
public interface InterfazCola<TipoDeDato> {
        
    void encolar(TipoDeDato dato);
    
    TipoDeDato desencolar();
    
    TipoDeDato obtenerFrente();
    
    void anular();
    
    int tamanoCola();
        
    boolean esVacia();
    
}

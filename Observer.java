/**
 * Observer. Es una interfaz que sera muy util para todas las clases para poder definir ciertas acciones a partir de cierto evento a ocurrir.
 * 
 * @author Victor Manuel Gómez Solis 
 */
public interface Observer{
    /**
     * eventOcurred. Esta firma de método sera aplicada en las clases que implementen esta interfaz.
     */
    void eventOcurred();
}

package modello;

/**
 * Una generica eccezione che pu˜ verificarsi
 * @author Giuseppe Restivo
 *
 */
public class MessaggioEccezione extends Exception {

	private static final long serialVersionUID = 1L;

	public MessaggioEccezione(String message) {
		super(message);
	}
}

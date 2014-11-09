package modello.service;

import grafica.FrameCartellaCondivisione;

import java.util.Observable;

import modello.Servizio;

/**
 * Pattern Proxy per cambiare a run-time la tipologia di servizio. In
 * {@link FrameCartellaCondivisione} il cambiamento sarˆ visualizzabile con lo
 * scadere del timer impostato.
 * 
 * @author Giuseppe Restivo
 * 
 */
public class ProxyServizio extends Observable implements Servizio {

	private Servizio service;

	public ProxyServizio(Servizio service) {
		super();
		this.service = service;
	}

	public void setService(Servizio service) {
		this.service = service;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modello.Servizio#service()
	 */
	@Override
	public void service() {
		service.service();
	}

}

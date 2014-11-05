package modello;

/**
 * Patter Proxy per cambiare a run-time la tipologia di servizio.
 * 
 * @author Giuseppe Restivo
 * 
 */
public class ProxyServizio implements Servizio {

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

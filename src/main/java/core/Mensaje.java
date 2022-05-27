package core;

/**
 * Mensaje para encapsulacion de datos mail y elemento
 *
 */
public class Mensaje {

	private String fecha;
	private String interes;
	private String resumen;
	private String noticia;

	/**
	 * Constructor de una noticia a partir de una fecha nivel de inter�s,
	 * descripci�n corta y descipci�n larga
	 * 
	 * @param fecha   cadena que representa la fecha
	 * @param interes cadena que representa el interes
	 * @param resumen cadena que representa la descripci�n corta de la noticia
	 * @param noticia cadena que representa la descripci�n larga de la noticia
	 */
	public Mensaje(String fecha, String interes, String resumen, String noticia) {
		this.fecha = fecha;
		this.interes = interes;
		this.resumen = resumen;
		this.noticia = noticia;

	}

	/**
	 * Constructor copia
	 * 
	 * @param nuevo mensaje fuente
	 */
	public Mensaje(Mensaje nuevo) {
		this.fecha = nuevo.fecha;
		this.interes = nuevo.interes;
		this.resumen = nuevo.resumen;
		this.noticia = nuevo.noticia;
	}

	/**
	 * Obtener fecha
	 * 
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Establecer fecha
	 * 
	 * @param fecha cadena que representa la fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtener interes
	 * 
	 * @return interes
	 */
	public String getInteres() {
		return interes;
	}

	/**
	 * Establecer interes
	 * 
	 * @param interes cadena que representa el interes
	 */
	public void setInteres(String interes) {
		this.interes = interes;
	}

	/**
	 * Obtener resumen
	 * 
	 * @return resumen
	 */
	public String getResumen() {
		return resumen;
	}

	/**
	 * Establecer resumen
	 * 
	 * @param resumen cadena que representa la descripci�n corta de la noticia
	 */
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	/**
	 * Obtener noticia
	 * 
	 * @return noticia
	 */
	public String getNoticia() {
		return noticia;
	}

	/**
	 * Establecer noticia
	 * 
	 * @param noticia cadena que representa la descripci�n larga de la noticia
	 */
	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}
}

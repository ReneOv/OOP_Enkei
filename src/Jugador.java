/*
 * Clase Jugador define la nave que el usuario utilizará, así como las orillas con las que hará colisión con otras naves
 * Es subclase de Nave.
 * 
 * @author Oswaldo y Rene
 * @ve
 * */

import java.awt.Rectangle;

public class Jugador extends Nave{
	private int velFuego;

	public int getVelFuego() {
		return velFuego;
	}
	public void setVelFuego(int velFuego) {
		this.velFuego = velFuego;
	}
	/* Constructor de la clase Jugador
	 * @param vel: define la cantidad de pixeles que avanza Jugador
	 * @param x: define posición horizontal de Jugador
	 * @param y: define la posición vertical de Jugador
	 * @param g: define la dirección angular de Jugador
	 * @param ancho: ancho de Jugador
	 * @param alto: alto de Jugador
	 * @param s: define el sprite que utiliza el jugador
	 * @param velFuego: define cada cuántos frames disparará la nave (actualmente en desuso, la nave dispara con cada clic)
	 */
	public Jugador(int vel, double x, double y, double g, int s, int alto, int ancho, int velFuego) {
		super(vel, x, y, g, s, alto, ancho);
		this.velFuego = velFuego;
	}
	/* GetOrillas: método que calcula el área rectangular que ocupa Jugador en la pantalla para usarse en colisiones
	 * 
	 */
	public Rectangle getOrillas() {
		return new Rectangle ((int)x, (int)y, alto, ancho);
	}
}

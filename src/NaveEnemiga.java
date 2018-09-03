/*La clase NaveEnemiga es una subclase de Nave. En �sta se encuentran los m�todos para obtener orillas para las colisiones,
 * el m�todo para restar Vida, y el de direcci�n.
 * 
 * @author Oswaldo y Rene
 * @ve
 * */


import java.awt.Rectangle;

public class NaveEnemiga extends Nave{
	private int vida;

	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	
	/* Constructor de la clase NaveEnemiga
	 * @param vel: define la cantidad de pixeles que avanza NaveEnemiga
	 * @param x: define posici�n horizontal de NaveEnemiga
	 * @param y: define la posici�n vertical de NaveEnemiga
	 * @param g: define la direcci�n angular de NaveEnemiga
	 * @param ancho: ancho de NaveEnemiga
	 * @param alto: alto de NaveEnemiga
	 * @param s: define el sprite de NaveEnemiga
	 * @param vida: define la cantidad de disparos que requiere NaveEnemiga para desaparecer
	 */
	public NaveEnemiga(int vel, double x, double y, double g, int s, int alto, int ancho, int vida) {
		super(vel,x,y,g,s,alto,ancho);
		this.vida=vida;
	}
	/*Double direcci�n: regrresa el �ngulo de direcci�n en el que se desplazar� NaveEnemiga para perseguir al jugador
	 * @param xP: posici�n en x del jugador
	 * @param yP: posici�n en y del jugador
	 */
	public double dir(double xP, double yP) {
		gradosRot=Math.atan2( (y+alto/2)-(yP+15), (x+ancho/2)-(xP+15))- Math.PI/2;
		return gradosRot;
	}
	/* M�todo redSalud: Reduce el par�metro de vida de la NaveEnemiga que ha sido impactada por una Bala
	 * @param s: da�o que causa Bala
	 */
	public void redSalud(int s) {
		vida-=s;
	}
	/* GetOrillas: m�todo que calcula el �rea rectangular que ocupa cada NaveEnemiga en la pantalla para usarse en colisiones
	 * 
	 */
	public Rectangle getOrillas() {
		return new Rectangle ((int)x, (int)y, alto, ancho);
	}
}

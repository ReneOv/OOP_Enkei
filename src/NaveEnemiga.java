/*La clase NaveEnemiga es una subclase de Nave. En ésta se encuentran los métodos para obtener orillas para las colisiones,
 * el método para restar Vida, y el de dirección.
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
	 * @param x: define posición horizontal de NaveEnemiga
	 * @param y: define la posición vertical de NaveEnemiga
	 * @param g: define la dirección angular de NaveEnemiga
	 * @param ancho: ancho de NaveEnemiga
	 * @param alto: alto de NaveEnemiga
	 * @param s: define el sprite de NaveEnemiga
	 * @param vida: define la cantidad de disparos que requiere NaveEnemiga para desaparecer
	 */
	public NaveEnemiga(int vel, double x, double y, double g, int s, int alto, int ancho, int vida) {
		super(vel,x,y,g,s,alto,ancho);
		this.vida=vida;
	}
	/*Double dirección: regrresa el ángulo de dirección en el que se desplazará NaveEnemiga para perseguir al jugador
	 * @param xP: posición en x del jugador
	 * @param yP: posición en y del jugador
	 */
	public double dir(double xP, double yP) {
		gradosRot=Math.atan2( (y+alto/2)-(yP+15), (x+ancho/2)-(xP+15))- Math.PI/2;
		return gradosRot;
	}
	/* Método redSalud: Reduce el parámetro de vida de la NaveEnemiga que ha sido impactada por una Bala
	 * @param s: daño que causa Bala
	 */
	public void redSalud(int s) {
		vida-=s;
	}
	/* GetOrillas: método que calcula el área rectangular que ocupa cada NaveEnemiga en la pantalla para usarse en colisiones
	 * 
	 */
	public Rectangle getOrillas() {
		return new Rectangle ((int)x, (int)y, alto, ancho);
	}
}

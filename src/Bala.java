/*
 * Clase Bala describe los metodos y parametros, junto con los metodos de Paint y para las colisiones.
 * @author Oswaldo y Rene
 * @version 0.1
 * */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bala {
	private double x, y, gradosRot;
	private int alto, ancho, dano,velocidad;
	private Color color;
	
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getGradosRot() {
		return gradosRot;
	}
	public void setGradosRot(double gradotRot) {
		this.gradosRot = gradotRot;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
	/* Constructor de la clase Bala
	 * @param velocidad : define la cantidad de pixeles que avanza Bala
	 * @param x: define posición horizontal de Bala
	 * @param y: define la posición vertical de Bala
	 * @param gradosRot: define la dirección angular de Bala
	 * @param ancho: ancho de Bala
	 * @param alto: alto de Bala
	 * @param dano: define el daño que realiza Bala a cada NaveEnemiga
	 * @param color: define el color de Bala
	 */
	public Bala(int velocidad, double x, double y, double gradotRot, int alto, int ancho, int dano, Color color) {
		this.velocidad = velocidad;
		this.x = x;
		this.y = y;
		this.gradosRot = gradotRot;
		this.alto = alto;
		this.ancho = ancho;
		this.dano = dano;
		this.color = color;
	}
	/*
	 * paint: método para pintar los gráficos de Bala
	 * @param g: se utiliza para rellenar la figura y darle color
	 */
	public void paint(Graphics g) {
		g.fillOval((int)x,(int)y , 3, 3);
		g.setColor(Color.CYAN);
	}
	/* GetOrillas: método que calcula el área rectangular que ocupa cada bala en la pantalla para usarse en colisiones
	 * 
	 */
	public Rectangle getOrillas() {
		return new Rectangle ((int)x, (int)y, 3, 3);
	}
}

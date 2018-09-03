/*La superclase de Nave es la encargada de definir todos los parámetros que utilizan, como su ubicación, velocidad, tamaño, 
 * dirección, etc. Contiene el constructor y el método de paint.
 * 
 * @author Oswaldo y Rene
 * @ve
 * */

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Nave {
	protected int velocidad, sprite;
	protected double x, y;
	protected int alto, ancho;
	protected double gradosRot;
	protected BufferedImage img;
	
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
	public void setGradosRot(double gradosRot) {
		this.gradosRot = gradosRot;
	}
	
	/* Constructor de la clase Nave
	 * @param vel : define la cantidad de pixeles que avanza Nave
	 * @param x: define posición horizontal de Nave
	 * @param y: define la posición vertical de Nave
	 * @param g: define la dirección angular de Nave
	 * @param ancho: ancho de Nave
	 * @param alto: alto de Nave
	 * @param s: define el sprite de Nave con un número entero
	 */
	public Nave(int vel, double x, double y, double g, int s, int alto, int ancho) {
		velocidad=vel;
		this.x=x;
		this.y=y;
		gradosRot=g;
		sprite=s;
		this.alto=alto;
		this.ancho=ancho;
		//Comienzo de lectura de gif
		String nImg = "sprites/Player.gif";
		switch(sprite) {
			case 1: nImg = "sprites/Tank.gif";
			break;
			case 2: nImg = "sprites/Big.gif";
			break;
			case 3: nImg = "sprites/Small.gif";
			break;
			case 4: nImg = "sprites/Medium.gif";
			break;
		}
		File archImagen = new File(nImg);
		try {
			img = ImageIO.read(archImagen);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	/* Método paint: define el color de Nave
	 * @param g: gráfico de Nave
	 */
	public void paint(Graphics g) {
		g.drawImage(img, (int)x, (int)y, alto, ancho,null);
	}
}

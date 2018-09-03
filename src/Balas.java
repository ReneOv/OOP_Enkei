/*
 * Clase Balas crea un arreglo de elementos Bala, define dónde aparecen y la dirección que van a seguir a determinada velocidad
 * @author Oswaldo y Rene
 * @ve
 * */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ListIterator;

public class Balas {
	private ArrayList <Bala> rafaga;
	private Bala b;
	private double gradosRot;
	
	/* Constructor de la clase Balas: ArrayList de Bala. Genera un arreglo de 10 espacios para elementos Bala
	 * 
	 */
	public Balas() {
		rafaga = new ArrayList <Bala> (10);
	}
	
	/* Método paint: Revisa todas las Bala existentes en el arreglo y las dibuja
	 * @param g: utilización de gráficos
	 */
	public void paint(Graphics g) {
		ListIterator <Bala> apt = rafaga.listIterator();
		while(apt.hasNext()) {
			Bala aux = apt.next();
			aux.paint(g);
		}
	}
	
	/* Método agregar: Se basa en la posición del mouse y del jugador para crear una bala. Se crea desde el centro del jugador en
	 * dirección hacia el mouse.
	 * @param e: Para obtener coordenadas del mouse
	 * @param j: Jugador del cual se obtienen sus coordenadas
	 */
	public void agregar(MouseEvent e, Jugador j) {
		gradosRot=Math.atan2( (j.getY()+15)-(e.getY()), (j.getX()+15)-(e.getX()))- Math.PI/2;
		b = new Bala(18, j.getX()+15, j.getY()+15, gradosRot, 3, 3, 1, Color.CYAN);
		rafaga.add(b);
	}
	/* Entero getTam: Llama al arreglo de Bala para obtener la cantidad de elementos que tiene
	 * 
	 */
	public int getTam() {
		return rafaga.size();
	}
	/* Bala get: Regresa la Bala que está en la posición p
	 * @param p: Posición del arreglo de Bala
	 */
	public Bala get(int p) {
		return rafaga.get(p);
	}
	/*
	 * Método borrar: Elimina una Bala determinada
	 * @param b; Bala en cuestión
	 */
	public void borrar(Bala b) {
		rafaga.remove(b);
	}
	/*
	 * Método avanzar: Llama al arreglo de Bala para mover cada una desde su anterior posición a una nueva
	 */
	public void avanzar() {
		ListIterator <Bala> apt = rafaga.listIterator();
		while(apt.hasNext()) {
			Bala aux = apt.next();
			aux.setX(aux.getX()+Math.cos(aux.getGradosRot()-Math.PI/2)*aux.getVelocidad());
			aux.setY(aux.getY()+Math.sin(aux.getGradosRot()-Math.PI/2)*aux.getVelocidad());	
		}
	}
}

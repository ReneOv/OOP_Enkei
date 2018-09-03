/*La clase de NavesE es una colección de tipo ArrayList de NaveEnemiga. En esta se encuentran los métodos para
 * aparecer los enemigos en el Canvas, eliminarlos, y hacerlos moverse.
 * 
 * @author Oswaldo y Rene
 * @ve
 * */

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class NavesE {
	private ArrayList <NaveEnemiga> naves;
	private Random r;
	private static final int[] vel= {1,3,7,4}, alt= {55,41,23,29}, anc= {55,41,23,29}, vida= {6,4,1,3};
	
	/* Constructor de la clase NavesE: ArrayList de NaveEnemiga. Genera un arreglo de 10 espacios para elementos NaveEnemiga
	 * 
	 */
	public NavesE() {
		naves = new ArrayList <NaveEnemiga>(10);
		r=new Random();
	}
	/* Método paint: Revisa todas las NaveEnemiga existentes en el arreglo y las dibuja
	 * @param g: utilización de gráficos
	 */
	public void paint(Graphics g) {
		ListIterator <NaveEnemiga> apt=naves.listIterator();
		while(apt.hasNext()) {
			NaveEnemiga aux=apt.next();
			aux.paint(g);	
		}
	}
	/* Método agregar: Aparece una NaveEnemiga fuera de la pantalla
	 * @param pantalla: MiCanvas del cual se obtienen sus dimensiones
	 */
	public void agregar(MiCanvas pantalla) {
		int p = r.nextInt(4);
		int q = r.nextInt(4);
		int x1, y1;
		NaveEnemiga e;
		switch(p) {
			case 0:
				x1=-55;
				y1=r.nextInt(pantalla.getHeight()+2*alt[q]+1)-alt[q];
				e = new NaveEnemiga(vel[q],x1,y1, 0, q+1, alt[q], anc[q], vida[q]);
				naves.add(e);
				break;
			case 1:
				y1=-55;
				x1=r.nextInt(pantalla.getWidth()+2*anc[q]+1)-anc[q];
				e = new NaveEnemiga(vel[q],x1,y1, 0, q+1, alt[q], anc[q], vida[q]);
				naves.add(e);
				break;
			case 2:
				x1=800;
				y1=r.nextInt(pantalla.getHeight()-2*alt[q]+1)+alt[q];
				e = new NaveEnemiga(vel[q],x1,y1, 0, q+1, alt[q], anc[q], vida[q]);
				naves.add(e);
				break;
			case 3:
				y1=600;
				x1=r.nextInt(pantalla.getWidth()+2*anc[q]+1)-anc[q];
				e = new NaveEnemiga(vel[q],x1,y1, 0, q+1, alt[q], anc[q], vida[q]);
				naves.add(e);
				break;
		}
	}
	/*
	 * Método borrar: Elimina una NaveEnemiga determinada
	 * @param e; NaveEnemiga en cuestión
	 */
	public void borrar(NaveEnemiga e) {
		naves.remove(e);
	}
	/* Entero getTam: Llama al arreglo de NaveEnemiga para obtener la cantidad de elementos que tiene
	 * 
	 */
	public int getTam() {
		return naves.size();
	}
	/* NaveEnemiga get: Regresa la NaveEnemiga que está en la posición p
	 * @param p: Posición del arreglo de NaveEnemiga
	 */
	public NaveEnemiga get(int p) {
		return naves.get(p);
	}
	 /* Método avanzar: Llama al arreglo de NaveEnemiga para mover cada una desde su anterior posición a una que lo acerque
	  * más al jugador
	  * @param jugador: Jugador, de él se obtienen sus coordenadas
	 */
	public void avanzar(Jugador jugador) {
		ListIterator <NaveEnemiga> apt = naves.listIterator();
		while(apt.hasNext()) {
			NaveEnemiga aux = apt.next();
			aux.setX(aux.getX()+Math.cos(aux.dir(jugador.getX(),jugador.getY())-Math.PI/2)*aux.getVelocidad());
			aux.setY(aux.getY()+Math.sin(aux.dir(jugador.getX(),jugador.getY())-Math.PI/2)*aux.getVelocidad());
		}
	}
}

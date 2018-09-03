/*
 * Clase MiCanvas es donde funciona la logica y union de las clases que interactuan para el Gameplay. Tienes las funciones de generar el
 * canvas, actualizar todos los gráficos, mover las naves y balas asi como generarlas, y calculos de colisiones.
 * @author Oswaldo y Rene
 * @ve
 * */

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Timer;


public class MiCanvas extends Canvas implements ActionListener,MouseListener,MouseMotionListener,KeyListener{
	private static final long serialVersionUID = 1L;
	private NavesE naves;
	private Timer reloj;
	private BufferedImage imagen, fondo;
	private Jugador jugador;
	private int sec = 0;
	private Balas rafaga;
	private int score=0;
	private boolean wPressed = false,aPressed=false,sPressed=false,dPressed=false;
	
	/* Constructor de la clase MiCanvas: Crea los arreglos de Bala y NaveEnemiga, crea la nave jugador, inicializa el Timer,
	 * crea la imagen que evita el flickering y añade los listeners del Mouse y Teclado
	 * 
	 */
	public MiCanvas() {
		super();
		rafaga = new Balas();
		jugador = new Jugador(6, 380, 280, 90, 0, 29, 29, 3);
		naves = new NavesE();
		reloj = new Timer(25, this);
		imagen = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		reloj.start();
		this.addMouseListener(this);
		this.addKeyListener(this);
		File archImagen = new File("sprites/Fondo.png");
		try {
			fondo = ImageIO.read(archImagen);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

/* Método colisiones: Busca intersecciones entre balas y naves, al igual que enemigos con el jugador.
 * También es el encargado de desaparecer las balas al chocar, reducir la salud de las naves impactadas y desaparecerlas
 * cuando su salud es menor a 1.
 */
	
	public boolean colisiones() {
		int i, j;
		for(i=0;i<naves.getTam();i++) {
			if(naves.get(i).getOrillas().intersects(jugador.getOrillas()))
			{
				return true;
			}
			for(j=0;j<rafaga.getTam();j++) {
				if(naves!=null) {
					if(rafaga.get(j).getOrillas().intersects(naves.get(i).getOrillas())) {
						naves.get(i).redSalud(rafaga.get(j).getDano());
						if(naves.get(i).getVida()<1) {
							naves.borrar(naves.get(i));
							score++;
						}
						rafaga.borrar(rafaga.get(j));	
					}
				}
			}
		}
		return false;
	}
	
/* Método actionPerformed: actualiza toda la escena en cuanto a movimiento, coliciones, y aparecer/desaparecer los elementos.
 * @param e: Utiliza la cantidad de segundos definida en el constructor MiCanvas para que cada itervalo de tiempo realice los
 * métodos que se le definieron
 */
	
	public void actionPerformed(ActionEvent e) {
		if(sec%35==0) naves.agregar(this);
		sec++;
		naves.avanzar(jugador);
		rafaga.avanzar();
		if(!this.colisiones())
			this.moverse();
		this.colisiones();
		repaint();
	}
	
/* Método Paint: Pone todos los gráficos en una imagen.
 * @param g: gráfico donde serán dibujados todos los objetos
 */
	
	public void paint(Graphics g) {
		Graphics gra = imagen.createGraphics();
		if (naves!=null && jugador!=null && rafaga!=null) {
			gra.drawImage(fondo, 0, 0, 800, 600,null);
			gra.setColor(Color.WHITE);
			gra.drawString("Score: "+score, 10, 20);
			naves.paint(gra);
			jugador.paint(gra);
			rafaga.paint(gra);
			
			if(this.colisiones())
			{
				gra.setColor(Color.BLACK);
				gra.fillRect(0,0,800,600);
				gra.setColor(Color.WHITE);
				gra.drawString("GAME OVER", 250, 200);
				gra.drawString("Score: "+score, 250, 250);
			}
		}
		g.drawImage(imagen, 0, 0, null);
	}
	/* Método update: dibuja la imagen generada en el método paint
	 * @param g: imagen a dibujar
	 */
	public void update(Graphics g) {
		paint(g);
	}
	
	public void mouseMoved(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	/* Método mouse Pressed: Aparece una nueva Bala cada vez que se haga clic en la pantalla 
	 * @param e: evento clic del mouse
	 */
	public void mousePressed(MouseEvent e) {
		rafaga.agregar(e,jugador);
		}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void keyTyped(KeyEvent e) {}
	/*método keyPressed: Funciona para definir un booleano que funciona para saber si una tecla está siendo presionada.
	 * @param e: Recibe un keyEvent del teclado siendo usado.
	 */
	public void keyPressed(KeyEvent e) {
		press(e.getKeyCode(),true);
	}
	/*método keyReleased: Funciona para definir un booleano que funciona para saber si una tecla fue soltada.
	 * @param e: Recibe un keyEvent del teclado siendo usado.
	 */
	public void keyReleased(KeyEvent e) {
		press(e.getKeyCode(),false);
	}
	/*método press: 
	 * @param keyCode: Recibe el código identificador de la tecla presionada.
	 * @param pressed: Recibe un booleano de verdadero o falso, dependiendo de qué fue lo último que se uso.
	 */
	public void press(int keyCode, boolean pressed)
	{
		switch (keyCode) {
        case KeyEvent.VK_W:
            wPressed = pressed;
            break;

        case KeyEvent.VK_S:
            sPressed = pressed;
            break;

        case KeyEvent.VK_A:
            aPressed = pressed;
            break;

        case KeyEvent.VK_D:
            dPressed = pressed;
            break;
		}
	}
	/*método moverse: Utiliza los cambios de valor booleanos para cambiar la posición del jugador, dependiendo de su velocidad.
	 * */
	public void moverse()
	{
		if(wPressed)
			jugador.setY(jugador.getY()-jugador.getVelocidad());
		if(sPressed)
			jugador.setY(jugador.getY()+jugador.getVelocidad());
		if(aPressed)
			jugador.setX(jugador.getX()-jugador.getVelocidad());
		if(dPressed)
			jugador.setX(jugador.getX()+jugador.getVelocidad());
		
		if(jugador.getX()<0)
			jugador.setX(1);
		if(jugador.getX()>754)
			jugador.setX(754);
		if(jugador.getY()<1)
			jugador.setY(1);
		if(jugador.getY()>532)
			jugador.setY(532);
	}
}

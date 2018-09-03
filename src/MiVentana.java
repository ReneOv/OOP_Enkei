/*Clase MiVentana crea la ventana donde se ubicará el Canvas.
 * 
 * @author Oswaldo y Rene
 * @ve
 * */

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiVentana extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	
	/* Constructor de la clase MiVentana: Define su tamaño, visibilidad y posición en la pantalla del equipo
	 * 
	 */
	public MiVentana(){
		super("Figura");
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		this.getContentPane().add(panel);
		MiCanvas canvas = new MiCanvas();
		panel.add(canvas);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
}

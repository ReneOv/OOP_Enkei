//Oswaldo David Garc�a Rodr�guez, A01206725
//Ren� Ojeda Vega, A01702860

/* *
 * Clase Main declara la ventana que incluir� el Canvas
 * @author Oswaldo y Ren�
 * @version 0.1
 * */

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		MiVentana mv = new MiVentana();		
		mv.setVisible(true);
		mv.setFocusable(true);
		mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
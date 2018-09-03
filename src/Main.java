//Oswaldo David García Rodríguez, A01206725
//René Ojeda Vega, A01702860

/* *
 * Clase Main declara la ventana que incluirá el Canvas
 * @author Oswaldo y René
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
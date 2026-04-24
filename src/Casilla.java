import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Casilla {
	private JButton boton = new JButton();
	private int[] posicion;

	public Casilla() {

	}

	public Casilla(int[] posicion) {
		setPosicion(posicion);
		this.boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
			}
		});
	}

	public JButton getBoton() {
		return this.boton;
	}

	public void setBotonName(String token) {
		this.boton.setText(token);
	}

	public int[] getPosicion() {
		return this.posicion;
	}

	public void setPosicion(int[] posicion) {
		if (posicion.length == 2 && posicion[0] <= 3 && posicion[1] <= 3) {
			this.posicion = posicion;
		}
	}
}

import javax.swing.JButton;

public class Casilla {
	private JButton boton = new JButton();
	private boolean used = false;

	public Casilla() {

	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public JButton getBoton() {
		return this.boton;
	}

	public void setBotonName(String token) {
		this.boton.setText(token);
		
	}

	
}

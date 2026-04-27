import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.*;
import java.util.Iterator;

public class Screen {
	private JFrame ventana = new JFrame("Tres en Ralla");
	private JTextField turno = new JTextField();
	private JTextField mensajes= new JTextField();
	private JPanel panelTablero = new JPanel(new GridLayout(3, 3));
	private Match match;
	public Screen() {
        this.match = new Match(this);
        ventana.setLayout(new BorderLayout());
        
        // Add buttons from Board to the panel
        Board b = match.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panelTablero.add(b.getCasillasPosition(i, j).getBoton());
            }
        }

        ventana.add(turno, BorderLayout.NORTH);
        ventana.add(panelTablero, BorderLayout.CENTER);
        ventana.add(mensajes, BorderLayout.SOUTH);
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);

	}
	public JTextField getMensajes() {
		return mensajes;
	}
	public void setMensajes(String mensajes) {
		this.mensajes.setText(mensajes); 
	}
	public JPanel getPanelTablero() {
		return panelTablero;
	}
	public void disablePanel() {
		Component[] comp = panelTablero.getComponents();
		for (Component c: comp) {
			c.setEnabled(false);
		}
	}
}

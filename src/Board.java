import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board {
	
	private String voidToken = " ";
	private Casilla[][] casillas = new Casilla[3][3];
	private int[][] magicSquare = { { 2, 7, 6 }, {9, 5, 1 }, { 4, 3, 8 } };
	
	public Board(Match cMatch) {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				final int r = i;
				final int c = j;
				int[] posicion = {i,j};
				casillas[r][c] = new Casilla();
				casillas[r][c].getBoton().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cMatch.changeBoard(posicion);
					}
				});
			}
			
		}
	}
	
	public Casilla[][] getCasillas() {
		return this.casillas;
	}
	public Casilla getCasillasPosition(int p1, int p2) {
		return this.casillas[p1][p2];
	}

	public int[][] getMagicSquare() {
		return this.magicSquare;
	}
	public int getMagicSquareValue(int p1, int p2) {
		return this.magicSquare[p1][p2];
	}
	public String getVoidToken() {
		return this.voidToken;
	}
	public void resetCasilla(int p1, int p2) {
		this.casillas[p1][p2].setBotonName(voidToken);
		this.casillas[p1][p2].setUsed(false);
	}
	public boolean changeBoard(String token, int[] position) {
		if (casillas[position[0]][position[1]].isUsed()) {
			return (false);
		} else {
			this.casillas[position[0]][position[1]].setBotonName(token);
			this.casillas[position[0]][position[1]].setUsed(true);
			return (true);
		}
	}
}

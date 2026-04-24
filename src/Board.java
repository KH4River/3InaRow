public class Board {
	
	private String voidToken = " ";
	private Casilla[][] casillas = new Casilla[3][3];
	private int[][] magicSquare = { { 2, 7, 6 }, {9, 5, 1 }, { 4, 3, 8 } };
	
	public Board() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas.length; j++) {
				int[] posicion = {i,j};
				casillas[i][j] = new Casilla(posicion);
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
		this.getCasillasPosition(p1, p2).setBotonName(voidToken);
	}
	public void changeBoard(String token, int p1, int p2) {
		this.getCasillasPosition(p1, p2).setBotonName(token);
	}
}

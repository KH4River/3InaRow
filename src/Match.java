import java.util.Vector;

public class Match {
	// variable is here to be sure every time i want to use '-' gets the same
	// character
	private Board board;
	private Screen screen;
	private int nMoves = 0;
	private int round = 0;
	private Vector<Integer> movesP1;
	private Vector<Integer> movesP2;

	public Match(Screen screen) {
		this.movesP1 = new Vector<>();
		this.movesP2 = new Vector<>();
		this.screen = screen;
		this.board = new Board(this);

	}

	public int getNMoves() {
		return nMoves;
	}

	public void setNMoves(int moves) {
		this.nMoves = moves;
	}

	public Vector<Integer> getMovesP1() {
		return movesP1;
	}

	public Vector<Integer> getMovesP2() {
		return movesP2;
	}

	public int getRound() {
		return round;
	}

	public void addRound() {
		this.round = this.round + 1;
	}

	public Board getBoard() {
		// TODO Auto-generated method stub
		return this.board;
	}
	public Screen getScreen() {
		return this.screen;
	}

	/**
	 * function checks for the round and if its round3 or earlier it saves the move
	 * in the corresponding position, if its a later round it moves all the current
	 * moves one position "lower" and in the last position saves the newest move
	 * 
	 * @param move : the last move made by the player
	 */
	public void saveMoves(int[] move) {
		if (nMoves % 2 != 0) {
			movesP2.add(move[0]);
			movesP2.add(move[1]);
			if (movesP2.size() > 6) {
				erraseOldestMove(movesP2);
				movesP2.removeFirst();
				movesP2.removeFirst();
			}
		} else {
			movesP1.add(move[0]);
			movesP1.add(move[1]);
			
			if (movesP1.size() > 6) {
				erraseOldestMove(movesP1);
				movesP1.removeFirst();
				movesP1.removeFirst();
			}
		}
		setNMoves(getNMoves() + 1);
	}

	public void changeBoard(int[] posicion) {
		boolean whatPlayer = (nMoves % 2 == 0);
		String token = whatPlayer ? "O" : "X";
		if (board.changeBoard(token, posicion)) {
			saveMoves(posicion);
			if (nMoves == 5) {
				didSomeoneWin(movesP1);
			} else if (nMoves > 5) {
				didSomeoneWin(movesP1);
				didSomeoneWin(movesP2);
			}
		} else {
			screen.setMensajes("no puedes elegir una casilla y elegida");
		}
		
	}

	/**
	 * changes the board so the oldest token of the player is errased
	 * 
	 * @param board : the game board
	 * @param moves : the saved moves of the player
	 */
	public void erraseOldestMove(Vector<Integer> pMoves) {
		board.resetCasilla(pMoves.getFirst(), pMoves.get(1));
	}

	/**
	 * uses for loops to check if any line and column of the board has been
	 * completed with matching sets of tokens
	 * 
	 * @param bo:  is the game board
	 * @param tok: the token it needs to check, (normally the one associated with
	 *             the last player that moved)
	 * @return
	 */
	public boolean didSomeoneWin(Vector<Integer> pMoves) {
		int eval = board.getMagicSquareValue(pMoves.get(0), pMoves.get(1))
				+ board.getMagicSquareValue(pMoves.get(2), pMoves.get(3))
				+ board.getMagicSquareValue(pMoves.get(4), pMoves.get(5));
		if (eval == 15) {
			boolean whatPlayer = (nMoves % 2 == 0);
			String player = whatPlayer ? "J2" : "J1";
			screen.setMensajes(player + " ha ganado");
			screen.disablePanel();
		}
		return (false);
	}
}

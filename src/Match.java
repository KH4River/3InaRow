import java.util.Vector;

public class Match {
	// variable is here to be sure every time i want to use '-' gets the same
	// character
	private Board board;
	private int nMoves = 0;
	private Vector<Integer> movesP1;
	private Vector<Integer> movesP2;

	public Match() {

	}

	public int getNMoves() {
		return nMoves;
	}

	public Vector<Integer> getMovesP1() {
		return movesP1;
	}

	public Vector<Integer> getMovesP2() {
		return movesP2;
	}

	/**
	 * function checks for the round and if its round3 or earlier it saves the move
	 * in the corresponding position, if its a later round it moves all the current
	 * moves one position "lower" and in the last position saves the newest move
	 * 
	 * @param move : the last move made by the player
	 */
	public void saveMoves(int[] move) {
		if (nMoves % 2 == 0) {
			movesP2.add(move[0]);
			movesP2.add(move[1]);
		} else {
			movesP1.add(move[0]);
			movesP1.add(move[1]);
		}

		if (movesP2.capacity() < 6) {
			erraseOldestMove(movesP2);
			movesP2.removeFirst();
			movesP2.removeFirst();
		}
		if (movesP1.capacity() < 6) {
			erraseOldestMove(movesP1);
			movesP1.removeFirst();
			movesP1.removeFirst();
		}
	}

	/**
	 * changes the board so the oldest token of the player is errased
	 * 
	 * @param board : the game board
	 * @param moves : the saved moves of the player
	 */
	public void erraseOldestMove(Vector<Integer> pMoves) {
		board.resetCasilla(pMoves.getFirst(),pMoves.get(1));
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
		int eval = board.getMagicSquareValue(pMoves.get(0),pMoves.get(1))
				+ board.getMagicSquareValue(pMoves.get(2),pMoves.get(3))
				+ board.getMagicSquareValue(pMoves.get(4),pMoves.get(5));
		if (eval == 15) {
			return (true);
		}
		return (false);
	}
}

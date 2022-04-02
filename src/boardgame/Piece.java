package boardgame;

import java.util.Arrays;

public abstract class Piece {
    protected Position positon;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        this.positon = null;
    }

    protected Board getBoard() {
        return board;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return possibleMoves()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPsossibleMove(){
        boolean mat[][] = possibleMoves();
        for (int i = 0; i < mat.length ; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j]) {
                    return true;
                }
            }

        }
        return false;
    }
}

package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        if (getColor() == Color.WHITE){
            p.setValues(positon.getRow() - 1, positon.getColumn());
            if (getBoard().positionExits(p) && !getBoard().thereIsAPoece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(positon.getRow() - 2, positon.getColumn());
            Position p2 = new Position(positon.getRow() - 1, positon.getColumn());
            if (getBoard().positionExits(p) && !getBoard().thereIsAPoece(p) && getBoard().positionExits(p2) && !getBoard().thereIsAPoece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(positon.getRow() - 1, positon.getColumn() -1);
            if (getBoard().positionExits(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(positon.getRow() - 1, positon.getColumn() +1);
            if (getBoard().positionExits(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            //#specialmove en passant white
            if (positon.getRow() == 3) {
                Position left = new Position(positon.getRow(), positon.getColumn() - 1);
                if (getBoard().positionExits(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[left.getRow() - 1][left.getColumn()] = true;
                }
                Position right = new Position(positon.getRow(), positon.getColumn() + 1);
                if (getBoard().positionExits(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    mat[right.getRow() - 1][right.getColumn()] = true;
                }
            }
        }

        else {
            p.setValues(positon.getRow() + 1, positon.getColumn());
            if (getBoard().positionExits(p) && !getBoard().thereIsAPoece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(positon.getRow() + 2, positon.getColumn());
            Position p2 = new Position(positon.getRow() + 1, positon.getColumn());
            if (getBoard().positionExits(p) && !getBoard().thereIsAPoece(p) && getBoard().positionExits(p2) && !getBoard().thereIsAPoece(p2) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(positon.getRow() + 1, positon.getColumn() -1);
            if (getBoard().positionExits(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(positon.getRow() + 1, positon.getColumn() +1);
            if (getBoard().positionExits(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            //#specialmove en passant black
            if (positon.getRow() == 4) {
                Position left = new Position(positon.getRow(), positon.getColumn() - 1);
                if (getBoard().positionExits(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[left.getRow() + 1][left.getColumn()] = true;
                }
                Position right = new Position(positon.getRow(), positon.getColumn() + 1);
                if (getBoard().positionExits(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    mat[right.getRow() + 1][right.getColumn()] = true;
                }
            }
        }
        return mat;
    }

    @Override
    public String toString(){
    return "P";
    }
}

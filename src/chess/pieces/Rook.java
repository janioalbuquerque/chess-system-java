package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //aboce
        p.setValues(positon.getRow() -1, positon.getColumn());
        while (getBoard().positionExits(p) && !getBoard().thereIsAPoece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() - 1);
        }
        if (getBoard().positionExits(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //left
        p.setValues(positon.getRow(), positon.getColumn() -1);
        while (getBoard().positionExits(p) && !getBoard().thereIsAPoece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() -1);
        }
        if (getBoard().positionExits(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //right
        p.setValues(positon.getRow(), positon.getColumn() +1);
        while (getBoard().positionExits(p) && !getBoard().thereIsAPoece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn() +1);
        }
        if (getBoard().positionExits(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below
        p.setValues(positon.getRow() +1, positon.getColumn());
        while (getBoard().positionExits(p) && !getBoard().thereIsAPoece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow() +1);
        }
        if (getBoard().positionExits(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
    }
}

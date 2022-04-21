package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class Knight extends ChessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "N";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        p.setValues(positon.getRow() -1,positon.getColumn() -2);
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(positon.getRow() -2,positon.getColumn() -1);
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(positon.getRow() -2,positon.getColumn() +1);
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(positon.getRow() -1,positon.getColumn() +2);
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(positon.getRow() +1,positon.getColumn() +2 );
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(positon.getRow() +2,positon.getColumn() +1 );
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(positon.getRow() +2,positon.getColumn() -1 );
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(positon.getRow() +1,positon.getColumn() -2 );
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
    }
}

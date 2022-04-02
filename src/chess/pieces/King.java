package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class King extends ChessPiece {
    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //above
        p.setValues(positon.getRow() -1,positon.getColumn());
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //left
        p.setValues(positon.getRow(),positon.getColumn() -1);
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //right
        p.setValues(positon.getRow(),positon.getColumn() +1);
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below
        p.setValues(positon.getRow() +1,positon.getColumn());
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //nw
        p.setValues(positon.getRow() -1,positon.getColumn() -1 );
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //ne
        p.setValues(positon.getRow() -1,positon.getColumn() +1 );
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //sq
        p.setValues(positon.getRow() +1,positon.getColumn() -1 );
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        //se
        p.setValues(positon.getRow() +1,positon.getColumn() +1 );
        if (getBoard().positionExits(p) && canMove(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
    }
}

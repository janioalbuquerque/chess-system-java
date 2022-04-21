package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString(){
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p instanceof  Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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

        // #SpecilaMove casttling
        if (getMoveCount() == 0 && !chessMatch.getCheck()){
            //#SpecialMove castling kingside rook
            Position posT1 = new Position(positon.getRow(), positon.getColumn() +3);
            if (testRookCastling(posT1)){
                Position p1 = new Position(positon.getRow(), positon.getColumn() +1);
                Position p2 = new Position(positon.getRow(), positon.getColumn() +2);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    mat[positon.getRow()][positon.getColumn() +2] = true;
                }
            }

            //#SpecialMove castling queenside rook
            Position posT2 = new Position(positon.getRow(), positon.getColumn() -4);
            if (testRookCastling(posT2)){
                Position p1 = new Position(positon.getRow(), positon.getColumn() -1);
                Position p2 = new Position(positon.getRow(), positon.getColumn() -2);
                Position p3 = new Position(positon.getRow(), positon.getColumn() -3);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    mat[positon.getRow()][positon.getColumn() -2] = true;
                }
            }
        }
        return mat;
    }
}

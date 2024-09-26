package exercicio09.chess.pieces.entities;

import exercicio09.board.Board;
import exercicio09.board.Position;
import exercicio09.chess.enums.Color;
import exercicio09.chess.pieces.ChessPiece;

public class Rook extends ChessPiece {
	public Rook( Board board, Color color ) {
		super( board, color );
	}

	@Override
	public String toString( ) {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves( ) {
		boolean[][] mat = new boolean[ getBoard( ).getRows( ) ][ getBoard( ).getColumns( ) ];

		Position p = new Position( 0,0 );
		toAbove( p, mat );
		toLeft( p, mat );
		toBellow( p, mat );
		toRight( p, mat );
		return mat;
	}

	private void toRight( Position p, boolean[][] mat ) {
		// right
		p.setValues( position.getRow(), position.getColumn() +1);
		while(getBoard().positionExists( position ) && ! getBoard( ).thereIsAPiece( position)){
			mat[position.getRow()][position.getColumn()] = true;
			p.setColumn( position.getColumn() + 1 );
		}
		if( getBoard( ).positionExists( position) && isThereOpponentPiece( position ) ){
			mat[position.getRow()][position.getColumn()] = true;
		}
	}

	private void toBellow( Position p, boolean[][] mat ) {
		// bellow
		p.setValues( position.getRow() + 1, position.getColumn() );
		while(getBoard().positionExists( position ) && ! getBoard( ).thereIsAPiece( position)){
			mat[position.getRow()][position.getColumn()] = true;
			p.setRow( position.getRow() + 1 );
		}
		if( getBoard( ).positionExists( position) && isThereOpponentPiece( position ) ){
			mat[position.getRow()][position.getColumn()] = true;
		}
	}

	private void toLeft( Position p, boolean[][] mat ) {
		// left
		p.setValues( position.getRow(), position.getColumn() -1);
		while(getBoard().positionExists( position ) && ! getBoard( ).thereIsAPiece( position)){
			mat[position.getRow()][position.getColumn()] = true;
			p.setColumn( position.getColumn() - 1 );
		}
		if( getBoard( ).positionExists( position) && isThereOpponentPiece( position ) ){
			mat[position.getRow()][position.getColumn()] = true;
		}
	}

	private void toAbove( Position p, boolean[][] mat ) {
		// above
		p.setValues( position.getRow() - 1, position.getColumn() );
		while(getBoard().positionExists( position ) && ! getBoard( ).thereIsAPiece( position)){
			mat[position.getRow()][position.getColumn()] = true;
			p.setRow( position.getRow() - 1 );
		}
		if( getBoard( ).positionExists( position) && isThereOpponentPiece( position ) ){
			mat[position.getRow()][position.getColumn()] = true;
		}
	}
}

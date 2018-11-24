package net.ddns.gingerpi.chessboardnetCommon;
import java.util.ArrayList;

public class Rook extends ChessPiece
{
	public Rook(boolean color)
	{
		super(color);
	}

	public Rook(boolean color,int moveCount, int killCount)
	{
		super(color,moveCount,killCount);
	}

	@Override
        public ArrayList<Integer> getLegalMoves(int position,ChessBoard chessBoard)
	{
		int i;
		int stopAt;
		final ArrayList<Integer> returnme=new ArrayList<Integer>();

		//down
		i=position;
		while(i<64)
		{
			i+=010;
			if(!chessBoard.addMoveToList(returnme,i,color))
				break;
		}

		//right
		i=position;
		stopAt=position/8;
		stopAt=position*8;
		stopAt+=8;
		while(i<stopAt)
		{
			i+=001;
			if(!chessBoard.addMoveToList(returnme,i,color))
				break;
		}

		//up
		i=position;
		while(i>0)
		{
			i-=010;
			if(!chessBoard.addMoveToList(returnme,i,color))
				break;
		}

		//left
		i=position;
		stopAt=position/8;
		stopAt=position*8;
		while(i>0)
		{
			i-=001;
			if(!chessBoard.addMoveToList(returnme,i,color))
				break;
		}

		return returnme;
	}


	@Override
	public boolean checkLegal(int chessMove,boolean attacking)
	{
		int origin=chessMove/64;
		int destination=chessMove%64;

		return ((origin/8) == (destination/8)) || ((origin%8) == (destination%8));
	}
}
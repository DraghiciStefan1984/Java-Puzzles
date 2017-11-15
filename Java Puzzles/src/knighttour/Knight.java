package knighttour;

import java.util.Random;

public class Knight
{
	private static Random rand=new Random();
	private int currentH;
	private int currentV;
	private Board board;
	private boolean isFullTour=false;
	private boolean isEndTour=false;
	private static int bestScore=0;
	private static int tourCount=0;
	private int moveCounter;
	
	public Knight()
	{
		board=new Board();
	}
	
	public void move()
	{
		while(!isFullTour)
		{
			currentH=rand.nextInt(Board.SIZE);
			currentV=rand.nextInt(Board.SIZE);
			moveCounter=1;
			board.populateArray(currentH, currentV);
			isEndTour=false;
			
			do
			{
				if(!isMoving())
				{
					getTourResults();
				}
			}
			while(!isEndTour);
		}
	}
	
	public boolean isMoving()
	{
		int[] movesTaken= {0,0,0,0,0,0,0,0};
		boolean allMovesUsed=false;
		
		while(!allMovesUsed)
		{
			int i=rand.nextInt(8);
			
			if(movesTaken[i]==0)
			{
				int hMove=currentH+board.getHorizontal(i);
				int vMove=currentV+board.getVertical(i);
				
				if(hMove>=0 && hMove<Board.SIZE && vMove>=0 && vMove<Board.SIZE && Board.chessBoard[hMove][vMove]==Board.MOVE_SYMBOL)
				{
					currentH=hMove;
					currentV=vMove;
					Board.chessBoard[currentH][currentV]=Board.MOVE_SYMBOL;
					moveCounter++;
					return true;
				}
				movesTaken[i]=1;
			}
			int c=0;
			for(int moves:movesTaken)
			{
				c+=moves;
			}
			if(c==8)
			{
				allMovesUsed=true;
			}
		}
		tourCount++;
		return false;
	}
	
	private void getTourResults()
	{
		isEndTour=true;
		
		if(moveCounter==Board.SIZE*Board.SIZE)
		{
			isFullTour=true;
			board.displayBoard();
			System.out.println("Success. The tour #"+tourCount+" was a complete tour!");
			return;
		}
		
		if(moveCounter==bestScore)
		{
			board.displayBoard();
			System.out.println("No success. The best score is "+bestScore);
		}
		else if(moveCounter>bestScore)
		{
			board.displayBoard();
			System.out.println("Still no success but getting there. The best score is "+bestScore);
		}
	}
}

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
				
			}
			while(!isEndTour);
		}
	}
	
	public boolean isMoving()
	{
		return false;
	}
}

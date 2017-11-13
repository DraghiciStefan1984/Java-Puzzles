package turtle;

import turtle.Directions.TurtleDirections;
import turtle.Pen.PenActions;

public class Turtle
{
	public char turtleSymbol;
	public int positionX;
	public int positionY;
	
	public Turtle()
	{
		turtleSymbol='X';
		positionX=0;
		positionY=0;
	}
	
	public void walk(Directions.TurtleDirections direction, int spaces, Pen.PenActions pen)
	{
		if(validateMove(direction, spaces)) 
		{
			boolean toDraw=(pen==PenActions.DOWN);
			switch (direction)
			{
			case NORTH:
				if(toDraw)
				{
					GameBoard.updateBoardX(positionX, spaces, -1, positionY);
					positionX-=1;
				}
				break;
			case SOUTH:
				if(toDraw)
				{
					GameBoard.updateBoardX(positionX, spaces, 1, positionY);
					positionX+=1;
				}
				break;
			case EAST:
				if(toDraw)
				{
					GameBoard.updateBoardY(positionY, spaces, 1, positionX);
					positionY+=1;
				}
				break;
			case WEST:
				if(toDraw)
				{
					GameBoard.updateBoardY(positionY, spaces, -1, positionX);
					positionY-=1;
				}
				break;
			}
		}
	}
	
	private boolean validateMove(Directions.TurtleDirections direction, int spaces)
	{
		if(direction==TurtleDirections.NORTH && (positionX-spaces)<0)
		{
			Messages.invalidMove(direction, positionX);
			return false;
		}
		if(direction==TurtleDirections.EAST && (positionY+spaces)>GameBoard.GAME_BOARD_SIZE-1)
		{
			Messages.invalidMove(direction, GameBoard.GAME_BOARD_SIZE-positionY-1);
			return false;
		}
		if(direction==TurtleDirections.SOUTH && (positionX+spaces)>GameBoard.GAME_BOARD_SIZE-1)
		{
			Messages.invalidMove(direction, GameBoard.GAME_BOARD_SIZE-positionX-1);
			return false;
		}
		if(direction==TurtleDirections.WEST && (positionY-spaces)<0)
		{
			Messages.invalidMove(direction, positionY);
			return false;
		}
		return true;
	}
}

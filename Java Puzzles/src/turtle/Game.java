package turtle;

import java.util.Scanner;

import turtle.Pen.PenActions;

public class Game
{
	private Pen.PenActions pen;
	private Directions.TurtleDirections direction;
	private Turtle turtle;
	private GameBoard gameBoard;
	private boolean quit;
	private int option;
	private Scanner scanner;
	
	public Game()
	{
		turtle=new Turtle();
		gameBoard=new GameBoard();
		quit=false;
		scanner=new Scanner(System.in);
		pen=PenActions.UP;
		direction=Directions.TurtleDirections.SOUTH;
	}
	
	public void gameLoop()
	{
		gameBoard.initGameBoard();
		
		do
		{
			System.out.println(Messages.errorMessage);
			Messages.errorMessage="";
			gameBoard.drawGameBoard(turtle.positionX, turtle.positionY, turtle.turtleSymbol);
			Messages.instructions();
			System.out.println("Pen is: "+(pen==PenActions.UP ? "NOT DRAWING" : "DRAWING"));
			System.out.println("Turtle is moving "+direction.toString());
			System.out.println("Select your option: ");
			option=Integer.parseInt(scanner.nextLine());
			if(option==1)
			{
				pen=Pen.PenActions.UP;
			}
			else if(option==2)
			{
				pen=Pen.PenActions.DOWN;
			}
			else if(option==3)
			{
				direction=Directions.TurtleDirections.NORTH;
			}
			else if(option==4)
			{
				direction=Directions.TurtleDirections.EAST;
			}
			else if(option==5)
			{
				direction=Directions.TurtleDirections.SOUTH;
			}
			else if(option==6)
			{
				direction=Directions.TurtleDirections.WEST;
			}
			else if(option==7)
			{
				quit=true;
			}
			else
			{
				Messages.invalidInput();
			}
			if(option==3 || option==4 || option==5 || option==6)
			{
				System.out.println("Turtle is moving "+direction.toString());
				System.out.println("Enter num of spaces to move: ");
				int spaces=Integer.parseInt(scanner.nextLine());
			}
		}
		while(!quit);
	}
}

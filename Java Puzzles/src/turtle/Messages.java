package turtle;

public final class Messages
{
	public static String errorMessage="";
	
	public static void instructions()
	{
		System.out.println("Type your commands to type on the game board.");
		System.out.println("1=pen up; 2=pen down.");
		System.out.println("3=north; 4=east; 5=south; 6=west.");
		System.out.println("7=quit.");
	}
	
	public static void invalidInput()
	{
		errorMessage="\n Invalid input, Input must be an integer between 1 and 7\n";
	}
	
	public static void invalidMove(Directions.TurtleDirections direction, int spaces)
	{
		errorMessage="\n Invalid move, You can only move "+spaces+" spaces to the "+direction+".\n";
	}
}

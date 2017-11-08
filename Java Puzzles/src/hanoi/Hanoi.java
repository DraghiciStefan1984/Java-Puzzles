package hanoi;

import java.util.Scanner;

public class Hanoi 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		scanner.close();
		hanoi(n, 1, 2, 3);
	}
	
	private static void hanoi(int n, int sourcePeg, int destinationPeg, int sparePeg)
	{
		if(n==1)
		{
			System.out.println(sourcePeg+" --> "+destinationPeg);
		}
		else
		{
			hanoi(n-1, sourcePeg, sparePeg, destinationPeg);
			System.out.println(sourcePeg+" --> "+destinationPeg);
			hanoi(n-1, sparePeg, destinationPeg, sourcePeg);
		}
	}
}
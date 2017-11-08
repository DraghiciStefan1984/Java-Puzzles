package factorial;

import java.util.Scanner;

public class Factorial 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		scanner.close();
		
		System.out.println("Factorial loop: "+factorialLoop(n));
		System.out.println("Factorial loop2: "+factorialLoop2(n));
		System.out.println("Factorial recursive: "+factorialRecursive(n));
	}
	
	private static int factorialLoop(int n)
	{
		int factorial=1;
		for (int i=n; i>=1; i--)
		{
			factorial*=i;
		}
		return factorial;
	}
	
	private static int factorialLoop2(int n)
	{
		int factorial=n;
		for(int i=1; i<n; i++)
		{
			factorial*=i;
		}
		return factorial;
	}
	
	private static int factorialRecursive(int n)
	{
		if(n==1)
		{
			return n;
		}
		else
		{
			n*=factorialRecursive(n-1);
		}
		return n;
	}
}

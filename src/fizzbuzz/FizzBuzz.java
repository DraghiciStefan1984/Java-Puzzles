package fizzbuzz;

import java.util.Scanner;

public class FizzBuzz 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		scanner.close();
		fizzBuzzRecursive(n);
	}
	
	private static void fizzBuzzLoop(int n)
	{
		for (int i=1; i<=n; i++)
		{
			if (i%3==0 && i%5==0)
			{
				System.out.println("FizzBuzz");
			}
			else if(i%3==0)
			{
				System.out.println("Fizz");
			}
			else if (i%5==0)
			{
				System.out.println("Buzz");
			}
			else
			{
				System.out.println(i);
			}
		}
	}
	
	private static void fizzBuzzRecursive(int n)
	{
		if(n<1)
		{
			return;
		}
		if (n%3==0 && n%5==0)
		{
			System.out.println("FizzBuzz");
		}
		else if(n%3==0)
		{
			System.out.println("Fizz");
		}
		else if (n%5==0)
		{
			System.out.println("Buzz");
		}
		else
		{
			System.out.println(n);
		}
		fizzBuzzRecursive(n-1);
	}
}

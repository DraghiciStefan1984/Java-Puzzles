package fibonacci;

import java.util.Scanner;

public class Fibonacci 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		int n=Integer.parseInt(scanner.nextLine());
		scanner.close();
		//fiboLoop(n);
		fiboRec(20);
	}
	
	private static void fiboLoop(int n)
	{
		int num1=0;
		int num2=1;
		
		System.out.println(num1);
		System.out.println(num2);
		
		for (int i=0; i<n; i++)
		{
			int next=num1+num2;
			num1=num2;
			num2=next;
			System.out.println(next);
		}
	}
	
	private static int fiboRec(int n)
	{
		int res=0;
		if(n<=1)
		{
			return n;
		}
		else
		{
			for (int i=0; i<n; i++)
			{
				res = fiboRec(n-2)+fiboRec(n-1);
			}
		}
		return res;
	}
}
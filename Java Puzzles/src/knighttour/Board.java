package knighttour;

public class Board
{
	public static final int SIZE=8;
	public static final char BOARD_SYMBOL='.';
	public static final char MOVE_SYMBOL='X';
	
	private int[] horizontal;
	private int[] vertical;
	
	public static char[][] chessBoard;
	
	public Board()
	{
		horizontal=new int[] {2,1,-1,-2,-2,-1,1,2};
		vertical=new int[] {-1,-2,-2,-1,1,2,2,1};
		chessBoard=new char[SIZE][SIZE];
	}
	
	public int getHorizontal(int i)
	{
		return this.horizontal[i];
	}
	
	public int getVertical(int i)
	{
		return this.vertical[i];
	}
	
	public void populateArray(int knightCurrentHPos, int knightCurrentVPos)
	{
		for(int i=0; i<SIZE; i++)
		{
			for(int j=0; j<SIZE; j++)
			{
				chessBoard[i][j]=BOARD_SYMBOL;
			}
		}
		chessBoard[knightCurrentHPos][knightCurrentVPos]=MOVE_SYMBOL;
	}
	
	public void displayBoard()
	{
		System.out.println(" ");
		for(int i=65; i<SIZE+65; i++)
		{
			System.out.print((char)i);
		}
		
		System.out.println("");
		
		for(int r=0; r<SIZE; r++)
		{
			System.out.print(r+1+" ");
			for(int c=0; c<SIZE; c++)
			{
				System.out.print(chessBoard[r][c]);
			}
			System.out.println("");
		}
	}
}

package turtle;

public class GameBoard
{
	public static final int GAME_BOARD_SIZE=20;
	public static final char USED_SPACE='O';
	public static final char GAME_BOARD_SYMBOL='-';
	public static char[][] gameBoardArray;

	public GameBoard()
	{
		gameBoardArray=new char[GAME_BOARD_SIZE][GAME_BOARD_SIZE];
	}
	
	public void initGameBoard()
	{
		for(int i=0; i<GAME_BOARD_SIZE; i++)
		{
			for (int j=0; j<GAME_BOARD_SIZE; j++)
			{
				gameBoardArray[i][j]=GAME_BOARD_SYMBOL;
			}
		}
	}
	
	public void drawGameBoard(int posX, int posY, char turtle)
	{
		for(int i=0; i<GAME_BOARD_SIZE; i++)
		{
			for (int j=0; j<GAME_BOARD_SIZE; j++)
			{
				if(i==posX && j==posY)
				{
					System.out.println(turtle);
				}
				else
				{
					System.out.println(gameBoardArray[i][j]);
				}
			}
			System.out.println("");
		}
	}
	
	public static void updateBoardX(int start, int spacesToMove, int upOrDown, int constantY)
	{
		for (int i=0; i<spacesToMove; i++)
		{
			gameBoardArray[start+(i*upOrDown)][constantY]=USED_SPACE;
		}
	}
	
	public static void updateBoardY(int start, int spacesToMove, int leftOrRight, int constantX)
	{
		for (int i=0; i<spacesToMove; i++)
		{
			gameBoardArray[constantX][start+(i*leftOrRight)]=USED_SPACE;
		}
	}
}

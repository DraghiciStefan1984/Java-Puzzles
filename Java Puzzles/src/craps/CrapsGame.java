package craps;

public class CrapsGame
{
	private enum DiceSum
	{ 
		SNAKE_EYES (2), 
		TREY (3), 
		SEVEN (7), 
		YO_LEVEN (11), 
		BOX_CARS (12);
		
		private int value;
		
		private DiceSum(int value)
		{
			this.value=value;
		}
	};
	
	public enum GameStatus
	{
		WIN, 
		LOSE,
		CONTINUE	
	};
	
	private RollDice roll;
	private GameStatus gameStatus;
	private DiceSum diceSum;
	
	private int numRolls;
	private int sum;
	private int point;
	private Statistics statistics;
	
	public final static int NUM_GAMES=1000;
	
	public CrapsGame()
	{
		roll=new RollDice();
		statistics=new Statistics();
	}
	
	private void evaluateRoll()
	{
		switch (sum)
		{
		case 7:
			diceSum=DiceSum.SEVEN;
			gameStatus=GameStatus.WIN;
			point=0;
			statistics.setStats(numRolls, gameStatus);
			break;
			
		case 11:
			diceSum=DiceSum.YO_LEVEN;
			gameStatus=GameStatus.WIN;
			point=0;
			statistics.setStats(numRolls, gameStatus);
			break;
			
		case 2:
			diceSum=DiceSum.SNAKE_EYES;
			gameStatus=GameStatus.LOSE;
			point=0;
			statistics.setStats(numRolls, gameStatus);
			break;

		case 3:
			diceSum=DiceSum.TREY;
			gameStatus=GameStatus.LOSE;
			point=0;
			statistics.setStats(numRolls, gameStatus);
			break;
			
		case 12:
			diceSum=DiceSum.BOX_CARS;
			gameStatus=GameStatus.LOSE;
			point=0;
			statistics.setStats(numRolls, gameStatus);
			break;
			
		default:
			gameStatus=GameStatus.CONTINUE;
			point=sum;
			break;
		}
	}
	
	private void displayMessage()
	{
		switch (gameStatus)
		{
		case WIN:
			System.out.println(numRolls==1 ? "Congrads, you rolled "+diceSum+". You win!"
										   : "Congrads, you rolled "+sum+". You win!");
			break;
			
		case LOSE:
			System.out.println(numRolls==1 ? "Sorry, you rolled "+diceSum+". You lost!"
										   : "Sorry, you rolled "+sum+". You lost!");
			break;

		default:
			System.out.println("You rolled "+sum+". Keep rolling!");
			break;
		}
	}
	
	private void keepPlaying()
	{
		sum=roll.diceRoll();
		numRolls++;
		
		if(sum==point)
		{
			gameStatus=GameStatus.WIN;
			statistics.setStats(numRolls, gameStatus);
		}
		else if (sum==7)
		{
			gameStatus=GameStatus.LOSE;
			statistics.setStats(numRolls, gameStatus);
		}
		else
		{
			gameStatus=GameStatus.CONTINUE;
		}
	}
	
	public void play()
	{
		for(int i=0; i<NUM_GAMES; i++)
		{
			System.out.println("********************** game #"+(i+1));
			gameStatus=GameStatus.CONTINUE;
			numRolls=0;
			
			sum=roll.diceRoll();
			numRolls++;
			evaluateRoll();
			displayMessage();
			
			while(gameStatus==GameStatus.CONTINUE)
			{
				keepPlaying();
				displayMessage();
			}
		}
		statistics.displayStatistics();
	}
}

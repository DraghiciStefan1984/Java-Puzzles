package tortoisevshare;

public class Tortoise extends Runner
{
	public Tortoise(int currentPosition, int lane, String name)
	{
		this.currentPosition=currentPosition;
		this.lane=lane;
		this.name=name;
		runnerSymbol="T";
		moveDescription=name+ ", Ready, Steday, GO!";
		allRunners.add(this);
	}

	@Override
	public void calculateMove()
	{
		int move=getMoveType();
		
		if(move>=1 && move<=50)
		{
			makeMove(MoveType.FAST_PLOD);
			moveDescription=name+" moved fast plod (+3).";
		}
		else if(move>=51 && move<=70)
		{
			makeMove(MoveType.SLIP);
			moveDescription=name+" slipped (-6).";
		}
		else
		{
			makeMove(MoveType.SLOW_PLOD);
			moveDescription=name+" moved slow plod (+1).";
		}
	}

}

package tortoisevshare;

import java.util.Scanner;

public class Race
{
	private Track track;
	private boolean raceOver;
	
	public Race()
	{
		track=new Track();
		new Tortoise(0, 0, "Tortoise");
		new Hare(0, 1, "Hare");
		raceOver=false;
	}
	
	private void setupRace()
	{
		for(Runner runner:Runner.allRunners)
		{
			track.runnerPosition(runner);
			System.out.println(runner.moveDescription);
		}
		track.displayRaceTrack();
	}
	
	public void getPlace()
	{
		for(Runner runner:Runner.allRunners)
		{
			if(runner.currentPosition==Track.TRACK_LENGTH)
			{
				System.out.println("The winner is: "+runner.name);
			}
		}
	}
	
	public void racing()
	{
		setupRace();
		
		do
		{
			Scanner scanner=new Scanner(System.in);
			scanner.nextLine();
			
			for(Runner runner:Runner.allRunners)
			{
				runner.calculateMove();
				track.runnerPosition(runner);
				System.out.println(runner.moveDescription);
				
				if(runner.isWinner(runner))
				{
					raceOver=true;
				}
			}
			track.displayRaceTrack();
		}
		while(!raceOver);
		getPlace();
	}
}

package tortoisevshare;

public class Track
{
	public static final int TRACK_LENGTH=10;
	public static final int NUM_OF_RUNNERS=2;
	
	public String[][] tracks;
	
	public Track()
	{
		tracks=new String[TRACK_LENGTH+1][NUM_OF_RUNNERS];
	}
	
	public void displayRaceTrack()
	{
		System.out.println("");
		for (int i=0; i<=TRACK_LENGTH; i++)
		{
			System.out.print(i+" | ");
			for (int j=0; j<NUM_OF_RUNNERS; j++)
			{
				if(tracks[i][j]==null)
				{
					System.out.print("  | ");
				}
				else
				{
					System.out.print(tracks[i][j]+" | ");
				}
			}
			System.out.println("");
		}
	}
	
	public void runnerPosition(Runner runner)
	{
		tracks[runner.originalPosition][runner.lane]=null;
		tracks[runner.currentPosition][runner.lane]=runner.runnerSymbol;
	}
}

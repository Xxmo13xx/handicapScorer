import java.util.*;

public class Player {
	private String playerName;
	private float playerHandicap;
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public float getPlayerHandicap() {
		return playerHandicap;
	}

	public void setPlayerHandicap(float playerHandicap) {
		this.playerHandicap = playerHandicap;
	}

	public int getNumberOfRoundsPlayed() {
		return numberOfRoundsPlayed;
	}

	public void setNumberOfRoundsPlayed(int numberOfRoundsPlayed) {
		this.numberOfRoundsPlayed = numberOfRoundsPlayed;
	}

	public ArrayList<Round> getOverallRounds() {
		return overallRounds;
	}

	public void setOverallRounds(ArrayList<Round> overallRounds) {
		this.overallRounds = overallRounds;
	}

	private int numberOfRoundsPlayed;
	private ArrayList<Round> overallRounds;
	
	public Player(String playerName){
		this.playerName = playerName;
		overallRounds = new ArrayList<Round>();
	}
	
	public void createNewRound(Course course, String roundName){
		overallRounds.add(new Round(course, roundName));
	}
	
	
}

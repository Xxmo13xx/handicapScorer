import java.util.ArrayList;
import java.util.Iterator;
import java.util.*;
public class Controller {
	
	private ArrayList<Course> listOfCourses;
	private ArrayList<Player> listOfPlayers;
	
	public Controller(){
		listOfCourses = new ArrayList<Course>();
		listOfPlayers = new ArrayList<Player>();
	}
	
	
	public ArrayList<Course> getListOfCourses() {
		return listOfCourses;
	}


	public void setListOfCourses(ArrayList<Course> listOfCourses) {
		this.listOfCourses = listOfCourses;
	}


	public ArrayList<Player> getListOfPlayers() {
		return listOfPlayers;
	}


	public void setListOfPlayers(ArrayList<Player> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}
	
	public int getNumberOfPlayers(){
		return this.listOfPlayers.size();
	}
	
	public String[] getPlayersNames(){
		String[] playerNames = new String[this.getNumberOfPlayers()];
		Iterator itr = listOfPlayers.iterator();
		int count = 0;
		while (itr.hasNext()){
			Player tempPlayer = (Player)itr.next();
			playerNames[count] = tempPlayer.getPlayerName();
			//System.out.println(tempPlayer.getPlayerName());
			count+=1;
		}
		
		return playerNames;
	}
	public void addNewPlayer(String playerName){
		boolean playerPresent = false;
		Iterator itr = this.listOfPlayers.iterator();
		while(itr.hasNext()){
			Player tempPlayer = (Player)itr.next();
			if (tempPlayer.getPlayerName() == playerName) playerPresent = true;			
		}
		if (!playerPresent){
			Player newPlayer = new Player(playerName);
			this.listOfPlayers.add(newPlayer);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Controller controller = new Controller();
		Course sherwood = new Course("Sherwood", 117, 2000.7);
		controller.listOfCourses.add(sherwood);
		Player player1 = new Player("Willie");
		Player player2 = new Player("Kt");
		controller.listOfPlayers.add(player1);
		controller.listOfPlayers.add(player2);
		controller.listOfPlayers.add(new Player("Eric"));
		controller.addNewPlayer("Cory");
		Gui gui = new Gui(controller);
		
		
		
	}

}

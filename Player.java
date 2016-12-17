import java.util.LinkedList;

public class Player extends Character {//Only one player in the game.
    
	private Location location;//It is a bit ugly to have this parameter here but makes it much easier to read world file
	
	public Player() {
		super("human", "You", 100, null, 10, 1, "This is a replica of you, that you controll.");
		location.setName("farm house");//Spawning point
	}
    /*
    public Player(String animalType, String name, int hitPoints, LinkedList<Item> equipment, int attack, int defence, String description, Location location){
    	super(animalType, name, hitPoints, equipment, attack, defence, description);
        this.location = location;
    }*/
    
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

}

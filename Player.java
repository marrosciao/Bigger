import java.util.LinkedList;

public class Player extends Character {
    
	private Location location;//It is a bit ugly to have this parameter here but makes it much easier to read world file
	
	public Player(String animalType) {
		super(animalType);
		location.setName("farm house");//Spawning point

	}
	
    public Player(String animalType, String name, int hitPoints, LinkedList<Item> equipment, int attack, int defence, String description, Location location){
    	super(animalType, name, hitPoints, equipment, attack, defence, description);
        this.location = location;
    }

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}

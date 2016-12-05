import java.util.LinkedList;

public class NPC extends Character {

	
	private boolean hostile;
	
	public NPC(String animalType) {
		super(animalType);
		
	}
	
    public NPC(String animalType, String name, int hitPoints, LinkedList<Item> equipment, int attack, int defence, String description, boolean hostile){
    	super(animalType, name, hitPoints, equipment, attack, defence, description);
        this.hostile = hostile;
    }

	public boolean getHostile() {
		return hostile;
	}

	public void setHostile(boolean hostile) {
		this.hostile = hostile;
	}

}

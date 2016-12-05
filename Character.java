import java.util.*;

public class Character extends GameObject{
    private String animalType; //T.ex. human, dragon, cat...  
    private int hitPoints;
    //private LinkedList<Item> bag = new LinkedList<Item>();  //Primarily only allow 10 items.
    private LinkedList<Item> equipment = new LinkedList<Item>();
    private int attack;
    private int defence;
    
    public Character(String animalType){
    	super("Nameless", "There is no description yet. Pleas add one.");
    	this.animalType = animalType;
        this.hitPoints = 100;
        //this.equipment =;
        this.attack = 0;
        this.defence = 1;
    }
    
    public Character(String animalType, String name, int hitPoints, LinkedList<Item> equipment, int attack, int defence, String description){
    	super(name, description);
    	this.animalType = animalType;
        this.hitPoints = hitPoints;
        this.equipment = equipment;
        this.attack = attack;
        this.defence = defence;
    }

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}


	public LinkedList<Item> getEquipment() {
		return equipment;
	}

	public void setEquipment(LinkedList<Item> equipment) {
		this.equipment = equipment;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

    
}

import java.util.*;

public class Character extends GameObject{
    private String animalType; //T.ex. human, dragon, cat...  
	private String name;
    private int hitPoints;
    private LinkedList<Item> bag = new LinkedList<Item>();  //Primarily only allow 10 items.
    private LinkedList<Item> equipment = new LinkedList<Item>();
    private int attack;
    private int defence;
    
    public Character(String animalType){
        this.animalType = animalType;
        this.name = "Nameless";
        this.hitPoints = 100;
        //this.bag = ;          //need to set them to empty but don't know how maybe the are null to begin with
        //this.equipment =;
        this.attack = 0;
        this.defence = 1;
        super.setDescription("There is no description yet. Pleas add one.");
    }

	public String getAnimalType() {
		return animalType;
	}

	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public LinkedList<Item> getBag() {
		return bag;
	}

	public void setBag(LinkedList<Item> bag) {
		this.bag = bag;
	}
	
	
	public void addItemToBag(Item object){
		this.bag.add(object);
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

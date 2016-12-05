import java.util.LinkedList;

public class Item extends GameObject {

	private int eatable;
	private int liftable;
	private int containingCapability;//The numbers of items that the Item can contain.
	private LinkedList<Item> containing = new LinkedList<Item>(); // bags and bottles can contain stuff.

	public Item(String name, Location location){//Minimum input
		super(name);
		this.setEatable(0); //0 for not initiated, 1 for eatable -1 for not eatable.
		this.setLiftable(0);  //0 for not initiated, 1 for liftable -1 for not liftable.
		this.setContainingCapability(0);

	}

	public int getEatable() {
		return eatable;
	}

	public void setEatable(int eatable) {
		this.eatable = eatable;
	}

	public int getLiftable() {
		return liftable;
	}

	public void setLiftable(int liftable) {
		this.liftable = liftable;
	}

	public LinkedList<Item> getContaining() {
		return containing;
	}

	public void setContaining(LinkedList<Item> containing) {
		this.containing = containing;
	}
	
	public void addContaining(Item containing) {
		if (this.containing.size() <= getContainingCapability()){
		this.containing.add(containing);
		}
	}

	public int getContainingCapability() {
		return containingCapability;
	}

	public void setContainingCapability(int containingCapability) {
		this.containingCapability = containingCapability;
	}
	
	
	
	
	
	
	
	
	
	
}


public class Item extends GameObject {
    
	private Location location;
	private int eatable;
	private int liftable;
	
    public Item(String name, Location location){//Minimum input
    	super();
    	super.setName(name);
    	this.eatable = 0; //0 for not initiated, 1 for eatable -1 for not eatable.
    	this.liftable = 0;  //0 for not initiated, 1 for liftable -1 for not liftable.
    	
    }
}

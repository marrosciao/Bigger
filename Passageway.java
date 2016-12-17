


/**
 * Passageway leading from A to B.
 * @author r2d2
 *
 */
public class Passageway extends GameObject{
	private Location locationA; 
	private Location locationB;
	private String direction; //The direction in in which the locationB is relative to locationA
	private boolean hidden; //Should the passageway be revealed when asked for or is it hidden, ex hidden door or tree house

	public Passageway(String name){
		super(name);
	}//Constructor

	public Passageway(Location locationA, Location locationB){
		this.locationA = locationA;
		this.locationB = locationB;
		this.hidden = false;
	}//Constructor
	public Passageway(Location locationA, Location locationB, String direction){
		this.locationA = locationA;
		this.locationB = locationB;
		this.direction = direction;
		this.hidden = false;
	}//Constructor
	public Location getLocationA() {
		return locationA;
	}
	public void setLocationA(Location locationA) {
		this.locationA = locationA;
	}
	public Location getLocationB() {
		return locationB;
	}
	public void setLocationB(Location locationB) {
		this.locationB = locationB;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}


}

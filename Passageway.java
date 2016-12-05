


/**
 * Passageway leading from A to B.
 * @author r2d2
 *
 */
public class Passageway{
	private Location locationA; 
	private Location locationB;
	private String direction; //The direction in in which the locationB is relative to locationA
	private boolean hidden; //Should the passageway be revealed when asked for or is it hidden, ex hidden door or tree house
	
	public Passageway(Location locationA, Location locationB){
        this.locationA = locationA;
        this.locationB = locationB;
        this.hidden = false;
	}
	public Passageway(Location locationA, Location locationB, String direction){
        this.locationA = locationA;
        this.locationB = locationB;
        this.direction = direction;
        this.hidden = false;
	}
	
	// might need to move this method to an other class
	/*public void UsePassageway(Character character, Location currentLocation){
	 
	}*/
	
}

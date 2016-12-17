import java.util.LinkedList;
import java.util.Scanner;

public class Toolbox {

	public static Location FindLocation(String name, LinkedList<Location> locations){
		for (int i = 0; i<locations.size();i++){
			if (locations.get(i).getName().equals(name)){
				return locations.get(i);
			}
		}
		Location noExistence = new Location("noExistence");
		return noExistence;
	}


	
	public static Item ItemFix(String wantedText, Scanner worldScann, LinkedList<Item> items) {
		boolean continueLoop = true;
		String line;
		int startPos;
		int endPos;
		LinkedList<Item> containings = new LinkedList<Item>();
		items.add(new Item(wantedText));
		while (continueLoop){
			line = worldScann.nextLine();
			if (line.contains(":")){
				startPos = line.indexOf(":",0) + 2;//+2 to skip the ":" and a space
				endPos = line.length();
				if (startPos != endPos){//The sub string does not exist
					wantedText = line.substring(startPos, endPos);
				}
				else{
					wantedText = "#blank"; //TODO Caution, not sure if this will cause error
				}
			}
			else{
				continue;
			}
			if (line.contains("#description:")){
				items.getLast().setDescription("wantedText");
	      	         	    
			}
			else if (line.contains("#eatable:")){
				if (wantedText.equals("yes")){
					items.getLast().setEatable(1);
				}
				else if (wantedText.equals("no")){
					items.getLast().setEatable(-1);
				}
				else{
					items.getLast().setEatable(0);
				}
			}
			else if (line.contains("#liftable:")){
				if (wantedText.equals("yes")){
					items.getLast().setLiftable(1);
				}
				else if (wantedText.equals("no")){
					items.getLast().setLiftable(-1);
				}
				else{
					items.getLast().setLiftable(0);
				}
				     	    
			}
			else if (line.contains("#containingCapability:")){
				int convertedWantedText = Integer.parseInt(wantedText);
				items.getLast().setContainingCapability(convertedWantedText);     	    
			}
			else if (line.contains("#containing:")){
				line = worldScann.nextLine();
				if (line.contains(":")){
					startPos = line.indexOf(":",0) + 2;//+2 to skip the ":" and a space
					endPos = line.length();
					if (startPos != endPos){//The sub string does not exist //TODO dubble check.
						wantedText = line.substring(startPos, endPos);
					}
					else{
						wantedText = "#blank"; //TODO Caution, not sure if this will cause error
					}
				}
				LinkedList<Item> usableOnce = new LinkedList<Item>();
				usableOnce.add(ItemFix( wantedText, worldScann, containings));
				items.getLast().setContaining(usableOnce); 
	      	         	    
			}
			else if (line.contains("#endItem")){
				continueLoop = false;
			}
			else{
				System.out.println("Error in tolbox item");
			}
				
			
		}
		return items.getLast();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static NPC NpcFix(String wantedText, Scanner worldScann, LinkedList<NPC> Npcs) {
		boolean continueLoop = true;
		String line;
		int startPos;
		int endPos;
		LinkedList<Item> equipments = new LinkedList<Item>();
		Npcs.add(new NPC(wantedText)); // Adds animal type not name.
		while (continueLoop){
			line = worldScann.nextLine();
			if (line.contains(":")){
				startPos = line.indexOf(":",0) + 2;//+2 to skip the ":" and a space
				endPos = line.length();
				if (startPos != endPos){//The sub string does not exist
					wantedText = line.substring(startPos, endPos);
				}
				else{
					wantedText = "#blank"; //TODO Caution, not sure if this will cause error
				}
			}
			else{
				continue;
			}
			if (line.contains("#name:")){
				Npcs.getLast().setName("wantedText");
	      	         	    
			}
			else if (line.contains("#description:")){
				Npcs.getLast().setDescription("wantedText");
	      	         	    
			}
			else if (line.contains("#equipment:")){
				boolean goOn = true;
				while(goOn){
					line = worldScann.nextLine();
					if (line.contains(":")){
						startPos = line.indexOf(":",0) + 2;//+2 to skip the ":" and a space
						endPos = line.length();
						if (startPos != endPos){//The sub string does not exist //TODO dubble check.
							wantedText = line.substring(startPos, endPos);
						}
						else{
							wantedText = "#blank"; //TODO Caution, not sure if this will cause error
						}
					}
					else{
						goOn = false;
					}

					if (line.contains("#item:")){
						equipments.add(Toolbox.ItemFix(wantedText, worldScann, equipments));// do I really need "items" as input? Yes I do, check toolBox
					}
				}
				LinkedList<Item> usableOnce = new LinkedList<Item>();
				usableOnce.add(ItemFix( wantedText, worldScann, equipments));
				equipments.getLast().setContaining(usableOnce); 
	      	         	    
			}
			else if (line.contains("#endNpcPressent")){
				continueLoop = false;
			}
			else{
				System.out.println("Error in tolbox item");
			}
				
			
		}
		return Npcs.getLast();
	}
	
	
	
	
}

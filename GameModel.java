import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

public class GameModel {

	public GameModel() {

		setUpWorld();
		//setUpLocation("farm house");
		interaction();
	}

	/*
	 * Creates the world by reading a txt-file describing the world with key words.
	 * This in order to able that the player adds code to the came that can be added directly 
	 */
	//private void setUpLocation(String locationName){
	// }

	private void setUpWorld(){
		String filename = "BiggerWorld.txt";
		String line;
		int startPos;//When cutting out text 
		int endPos;
		String wantedText;

		File file = new File(filename);
		try {//FileNotFoundException
			Scanner worldScann = new Scanner(file);


			//Skips some descriptions of the file. THis one is redundant
			/*boolean runLoop = true;
			while (worldScann.hasNextLine() && runLoop){
				line = worldScann.nextLine();
				System.out.println(line);//TODO remove
				if (line.equals("Start reading")){
					runLoop = false;
				}
			}*/

			//This chunk is redundant, move down the creating of locations and remove the whole chunk =) Not true since passageways
			LinkedList<Location> locations = new LinkedList<Location>();
			LinkedList<Passageway> passageways = new LinkedList<Passageway>();
			LinkedList<Item> items = new LinkedList<Item>();
			LinkedList<NPC> Npcs = new LinkedList<NPC>();
			while (worldScann.hasNext()){//Creates all locations. Need all locations to finish one completely
				line = worldScann.nextLine();
				if (line.contains("#location:")){
					startPos = line.indexOf(":",0) + 2;//+2 to skip the ":" and a space
					endPos = line.length();
					wantedText = line.substring(startPos, endPos);
					locations.add(new Location(wantedText));//adds location to list with specific name
					//locations.get(index).setName(wantedText);
				}
				else{
					//We will do nothing here. Just continue to next line	
				}
			}
			Scanner worldScann2 = new Scanner(file);
			int locationIndex = -1;
			int itemIndex = -1;
			int NpcIndex = -1;
			int passagewayIndex = -1;
			String activeType = "location";
			while (worldScann2.hasNext()){
				line = worldScann2.nextLine();
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
					continue;
				}

				if (line.contains("#location:")){		
					locationIndex++;
					activeType = "location";
				}
				else if (line.contains("#item:")){		
					itemIndex++;
					activeType = "item";
					items.add(new Item(wantedText));
				}
				else if (line.contains("#NPC:")){		
					NpcIndex++;
					activeType = "NPC";
					Npcs.add(new NPC(wantedText));
				}
				else if (line.contains("#NPC:")){		
					passagewayIndex++;
					activeType = "passageway";
					passageways.add(new Passageway(wantedText));
				}
				else if (line.contains("#description:")){//Doubble check ! to make inverse   && !wantedText.equals("#blank") //TODO why did I want this?

					if (activeType == "location"){
						locations.get(locationIndex).setDescription(wantedText);
					}
					else if (activeType == "item"){
						items.get(itemIndex).setDescription(wantedText);
					}
					else if (activeType == "NPC"){
						Npcs.get(NpcIndex).setDescription(wantedText);
					}
				}
				else if (activeType.equals("passageway")){
					if (line.contains("#locationA:")) {
						passageways.get(passagewayIndex).setLocationA(Toolbox.FindLocation(wantedText, locations));
					}
					else if (line.contains("#locationB:")) {
						passageways.get(passagewayIndex).setLocationB(Toolbox.FindLocation(wantedText, locations));
					}
					else if (line.contains("#direction:")) {
						if (wantedText.equals("yes"))
							passageways.get(passagewayIndex).setDirection(wantedText);
					}
					else if (line.contains("#hidden:")) {
						if (wantedText.equals("no")){
							passageways.get(passagewayIndex).setHidden(false);
						}
						else{
							passageways.get(passagewayIndex).setHidden(true);
						}
					}
				}
				else if (line.contains("#thingsPressent:")){ // fix the loop
					boolean goOn = true;
					while(goOn){
						line = worldScann2.nextLine();
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
							items.add(Toolbox.ItemFix(wantedText, worldScann2, items));// do I really need "items" as input? Yes I do, check toolBox
						}
					}
				}
				else if (line.contains("#NPC")){
					Npcs.add(Toolbox.NpcFix(wantedText, worldScann2, Npcs));// currently working on this one
				}

				else if (line.contains("#endLocation:")){
					itemIndex = -1;
					NpcIndex = -1;
					passagewayIndex = -1;
					locations.get(locationIndex).setThingsPressent(items);
					locations.get(locationIndex).setNpcPressent(Npcs);
					locations.get(locationIndex).setPassageways(passageways);


				}
				else{
					//We will do nothing here. Just continue to next line	
				}
			}





		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
		}

	}

	private void interaction(){

	}

	private void addToGame(){

	}

	private void save(){

	}

	private void loading(){

	}

	private void ending(String ending){
		if (ending.equals("quit")){
			Scanner input = new Scanner(System.in);
			System.out.println("Do you want to save the game before you quit? [yes/no]");
			String choice = input.nextLine();
			if (choice.equals("yes")){
				save();
				System.out.println("You have now saved the game");
				System.exit(0);
			}
			else if (choice.equals("no")){
				System.exit(0);
			}
			else{
				System.out.println("Non valid answer");
				ending("quit");
			}
			input.close();
		} 
		else if (ending.equals("dead")){
			System.out.println("You are dead.\nIf you have preiviosly saved the game you can restart frome there.");
			System.exit(0);
			//TODO make it a bit better with feedback and so.
		}
		else if (ending.equals("win")){
			System.out.println("Nice! you have won the game. you can continu to play in  thes world and"
					+ " create a own quest or try to find other players quests");
		}
		else{
			System.out.println("invalid endig");
		}



	}

	private void highScore(){

	}

	private void feedback(){

	}




}

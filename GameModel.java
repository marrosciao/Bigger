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
		//TODO change location on BiggerWorld so it can be read

		File file = new File(filename);
		try {//FileNotFoundException
			Scanner worldScann = new Scanner(file);


			//Skips some descriptions of the file
			String line;
			boolean runLoop = true;
			while (worldScann.hasNextLine() && runLoop){
				line = worldScann.nextLine();
				System.out.println(line);
				if (line.equals("Start reading")){
					runLoop = false;
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

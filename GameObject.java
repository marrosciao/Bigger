
public abstract class GameObject{

	private String name;
	private String description;


	public GameObject(){
		this.name = "*There is no name yet. Pleas add one.*";
		this.description = "There is no description yet. Pleas add one.";
	}
	
	public GameObject(String name){
		this.name = name;
		this.description = "There is no description yet. Pleas add one.";
	}
	
	public GameObject(String name, String description){
		this.name = name;
		this.description = description;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(this.name != "*There is no name yet. Pleas add one.*"){
			this.name = name;
		}
		else{
			System.out.print("There is alreaddy a description, if you want to change it do so in the code.");
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String text){
		if(this.description != "There is no description yet. Pleas add one."){
			this.description = text;
		}
		else{
			System.out.print("There is alreaddy a description, if you want to change it do so in the code.");
		}
	}

}

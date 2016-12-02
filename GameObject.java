
public abstract class GameObject{

	private String name;
	private String description;


	public GameObject(){
		this.description = "There is no description yet. Pleas add one.";
	}




	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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

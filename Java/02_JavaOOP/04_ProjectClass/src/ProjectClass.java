
public class ProjectClass {

	String name = "Project1";
	String description = "HackApp";

	public ProjectClass() {
	};

	public ProjectClass(String name) {
		this.name = name;
	}

	public ProjectClass(String name, String description) {
		this.name = name;
		this.description = description;
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

	public void setDescription(String description) {
		this.description = description;
	}

}

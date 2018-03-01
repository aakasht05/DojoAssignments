
public class ProjectClassTest {

	public static void main(String[] args) {

		ProjectClass elevatorPitch1 = new ProjectClass();
		System.out.println(elevatorPitch1.name);
		System.out.println(elevatorPitch1.description);

		ProjectClass elevatorPitch2 = new ProjectClass("Project2");
		System.out.println(elevatorPitch2.name);
		System.out.println(elevatorPitch2.description);

		ProjectClass elevatorPitch3 = new ProjectClass("Project3", "BankApp");
		System.out.println(elevatorPitch3.name);
		System.out.println(elevatorPitch3.description);
	}

}

public class Owner extends User {
	private boolean isAdmin = true;

	public Owner(String name, String email) {
		this.name= name;
		this.email = email;
		}
	public String getEmail() {
		return email;
	}
	public String getName(){
		return name;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
}
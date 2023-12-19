package wsp;

import java.io.Serializable;
import java.util.Objects;

import database.Database;

public abstract class User implements Serializable {
	
	private int id = 1;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	
	public User(String username, String password, String firstName, String lastName) {
		if(Database.getInstance().getUsers().isEmpty()) {
			this.id = 1;
		}
		else {
			int nextid = Database.getInstance().getUsers().lastElement().id;
			this.id = ++nextid;
		}
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	
	public void authentification() {
		this.viewNews();
		this.viewMenu();
	}
	
	public abstract void viewNews();
	public abstract void viewMenu();
	public abstract void changeInfo();
	
//	public void logOut() {
//		
//	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "[id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}
	
	
}

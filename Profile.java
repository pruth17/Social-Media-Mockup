// @author Pruthvi Punwar
// Purpose: The Purpose of this file is to create User Profiles!

import supportClasses.AList;

/**
 * A profile on a simple social network.
 */
public class Profile {

	private String id;
	private String Name;
	private String status;
	private AList<Profile> friends;

	public String getID() {
		return this.id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public int getNumberOfFriends() {
		return friends.getLength();
	}

	public Profile(String id, String Name) {
		this.id = id;
		this.Name = Name;

	}

	public Profile() {

		Name = "";
		status = "";
		friends = new AList<>();
		id = "-1";
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public void setStatus(String stat) {
		status = stat;
	}

	/**
	 * Returns the status associated with the profile.
	 */
	public String getStatus() {
		return status;
	}

	public AList<Profile> getFriends() {
		return friends;
	}

	public void addFriend(Profile p) {
		friends.add(p);
	}

	public void removeFriend(Profile p) {
		int index = -1;

		index = friends.contains(p);

		if (index != -1)
			friends.remove(index);

	}

	public void profileDisplay() {
		System.out.println("_________________________");
		System.out.println("ID: " + this.id);
		System.out.println("Name: " + this.Name);
		System.out.println("Status: " + status);
		if (friends.isEmpty()) {
			System.out.println("NO friends");
		} else {
			System.out.println("List of friends: ");
			for (int i = 0; i < friends.getLength(); i++) {
				System.out.println((i + 1) + ": " + friends.getEntry(i + 1).getName());

			}

		}

	}
}

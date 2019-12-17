// @author Pruthvi Punwar
import java.util.Iterator;

import supportClasses.AList;
import supportClasses.LinkedQueue;
import supportClasses.LinkedStack;
import supportClasses.ListInterface;
import supportClasses.QueueInterface;
import supportClasses.StackInterface;
import supportClasses.UndirectedGraph;
import supportClasses.VertexInterface;

public class BERDnetwork extends UndirectedGraph {
// list of profiles
	private final AList<Profile> listProfiles;

	public AList<Profile> getListProfiles() {
		return listProfiles;
	}
// graph to keep a list of friends
	private final UndirectedGraph<Profile> graphProfiles;

	public BERDnetwork() {

		listProfiles = new AList<>();
		graphProfiles = new UndirectedGraph<>();
	}
// adding a profile
	public void addProfile(Profile p) {
		listProfiles.add(p);
		graphProfiles.addVertex(p);
	}
// removing a profile
	public void removeProfile(Profile p) {
		int index = -1;

		index = listProfiles.contains(p);
		if (index != -1) {
			for (int i = 1; i <= p.getFriends().getLength(); i++)
				((p.getFriends()).getEntry(i)).removeFriend(p);
			graphProfiles.removeVertex(p);
			listProfiles.remove(index);
		}

	}

	public void fv() {

		graphProfiles.displayEdges();
	}
// creating friends
	public void createFriendship(Profile a, Profile b) {

		a.addFriend(b);
		b.addFriend(a);
		graphProfiles.addEdge(a, b, 1);
	}
// removing friends
	public void endFriendship(Profile a, Profile b) {
		a.removeFriend(b);
		b.removeFriend(a);
		graphProfiles.removeEdge(a, b);
	}
// displaying friends
	public void displayAllProfileInfo() {
		// TODO Auto-generated method stub
		for (int i = 0; i < listProfiles.getLength(); i++) {
			listProfiles.getEntry(i + 1).profileDisplay();
		}

	}
// searchinf for profile by name
	public Profile searchProfile(String x) {
		for (int i = 0; i < listProfiles.getLength(); i++) {
			if (x.contentEquals(listProfiles.getEntry(i + 1).getName())) {

				return listProfiles.getEntry(i + 1);
			}
		}
		return null;

	}
// changing status
	public void changeStatus(String a, String chan) {
		for (int i = 0; i < listProfiles.getLength(); i++) {
			if (chan.contentEquals(listProfiles.getEntry(i + 1).getID())) {
				// System.out.println("5t354948848484");
				listProfiles.getEntry(i + 1).setStatus(a);

			}
		}

	}
// searching by IS
	public Profile SearchByID(String k) {
		for (int i = 0; i < listProfiles.getLength(); i++) {
			if (k.contentEquals(listProfiles.getEntry(i + 1).getID())) {

				return listProfiles.getEntry(i + 1);
			}
		}
		return null;

	}
// getting friends of friends
	public ListInterface<Profile> getFriendsOfFriends(Profile p) {
		ListInterface<Profile> friendsOfFriends = new AList<>();
		StackInterface<Profile> path = new LinkedStack();
		int size = 0;
		QueueInterface<Profile> potential = graphProfiles.getBreadthFirstTraversal(p);
		for (int i = 0; i <= p.getFriends().getLength(); i++)// removes themselves and their friends, who are all at the
																// beginning of the queue
			potential.dequeue();
		while (!potential.isEmpty())// if the path to the individual is
		{
			graphProfiles.getShortestPath(p, potential.getFront(), path);
			while (!path.isEmpty()) {
				path.pop();
				size++;
			}
			if (size == 3)// The three nodes in path should be the starting person, the friend, and then
							// the friend of the friend
				friendsOfFriends.add(potential.dequeue());
			else
				return friendsOfFriends;
			size = 0;
			path.clear();
		}
		return friendsOfFriends;
	}
// friends reccomendation
	public ListInterface<Profile> getFriendCandidates(Profile origin, int numberOfFriends) {

		resetVertices();
		ListInterface<Profile> traversalOrder = new AList<>();
		QueueInterface<VertexInterface<Profile>> vertexQueue = new LinkedQueue<>();

		VertexInterface<Profile> originVertex = (VertexInterface<Profile>) vertices.getValue(origin);
		originVertex.visit();
		vertexQueue.enqueue(originVertex);
		int count = 0;
		while (!vertexQueue.isEmpty() && count <= numberOfFriends) {
			VertexInterface<Profile> frontVertex = vertexQueue.dequeue();
			Iterator<VertexInterface<Profile>> neighbors = frontVertex.getNeighborIterator();
			while (neighbors.hasNext()) {
				VertexInterface<Profile> nextNeighbor = neighbors.next();
				if (!nextNeighbor.isVisited()) {
					nextNeighbor.visit();
					if (count != 0)
						traversalOrder.add(nextNeighbor.getLabel());
					vertexQueue.enqueue(nextNeighbor);
				}
			}
			count++;
		}
		for (int i = 0; i < traversalOrder.getLength(); i++)
			System.out.println(traversalOrder.getEntry(i) + " ");
		return traversalOrder;
	}

	public void displayFriendsOfFriends(Profile x) {
		ListInterface<Profile> t = new AList<>();
		t = getFriendsOfFriends(x);
		for (int i = 1; i <= t.getLength(); i++) {
			System.out.print(i + ": ");
			System.out.println(t.getEntry(i) + " ");
		}
	}

}

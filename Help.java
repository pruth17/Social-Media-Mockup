// @author Pruthvi Punwar
import javax.swing.JFrame;
import supportClasses.AList;
import supportClasses.ListInterface;
import supportClasses.ListWithIteratorInterface;

public class Help {
	


	public int helpingme(BERDnetwork m) {
		ListInterface<Profile> fff = new AList<>();

			Profile vishaal = new Profile();
			vishaal.setName("Vishal");
			vishaal.setStatus("My name is Vishaal.");
			vishaal.setID("1");

			Profile dylan = new Profile();
			dylan.setName("Dylan");
			dylan.setStatus("BRO GO FOLLOW HOODVINE");
			dylan.setID("2");

			Profile will = new Profile();
			will.setName("will");
			will.setStatus("call me bb tho");
			will.setID("3");

			Profile travis = new Profile();
			travis.setName("Travis");
			travis.setStatus("ITS LIT");
			travis.setID("4");

			Profile Sam = new Profile();
			Sam.setName("Sam");
			Sam.setStatus("420");
			Sam.setID("5");

			Profile luke = new Profile();
			luke.setName("Luke");
			luke.setStatus("YOU AREN'T MY FATHER");
			luke.setID("6");

			Profile faith = new Profile();
			faith.setName("Faith");
			faith.setStatus("wut");
			faith.setID("7");

			m.addProfile(vishaal);
			m.addProfile(dylan);
			m.addProfile(will);
			m.addProfile(travis);
			m.addProfile(Sam);
			m.addProfile(luke);
			m.addProfile(faith);
			 m.createFriendship(vishaal, dylan);
		        m.createFriendship(dylan, will);
		        m.createFriendship(vishaal, travis);
		        m.createFriendship(travis, dylan);
		        m.createFriendship(will, travis);
		        m.createFriendship(will, Sam);
		        m.createFriendship(will, faith);
		        m.createFriendship(luke, Sam);
		        m.createFriendship(dylan, faith);
		      //  m.getFriendsOfFriends(will);
	
		   
			
			return 7;
			
		
		// TODO Auto-generated method stub
		
	}
}

// @author Pruthvi Punwar
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import supportClasses.AList;


public class Driver {
// variables required
	private static JTextArea textArea;
	private static BERDnetwork m = new BERDnetwork();
	private static JFrame frame;
	private static JPanel helloPanel;
	private static JPanel firstPanel;
	private static JButton modifyProfile;
	private static Profile temp = new Profile();
	private static JTextArea k = new JTextArea(" ");
	private static JPanel j = new JPanel();
	private static JLabel h = new JLabel("Enter your new Status.");
	private static JButton anothe = new JButton("Enter");
	private static JFrame frame3;
	private static JFrame frame4;
	private static JFrame frame5;
	private static JLabel enterName = new JLabel("Enter the name");
	private static JLabel enterStatus = new JLabel("Enter the status");
	private static int totalid = 8;
	private static JPanel cret = new JPanel();
	private static JTextArea getN = new JTextArea(" ");
	private static JTextArea getS = new JTextArea(" ");
	private static JButton r4 = new JButton("Enter");
	private static String dcc;
	private static Profile dc = new Profile();
	private static JFrame frame6 = new JFrame("Searching for a Profile");
	private static JLabel reto = new JLabel("Enter the ID: ");
	private static JTextArea getSearch = new JTextArea(" ");
	private static JButton anod = new JButton("Enter");
	private static JLabel disp = new JLabel();
	private static JButton back = new JButton("Back");
	private static JFrame frame7 = new JFrame("Adding a friend");
	private static AList<Profile> pedd = new AList<>();
	private static AList<Profile> peddd = new AList<>();
	private static Profile toax = new Profile();
	private static Profile cs = new Profile();
	private static JFrame frame8 = new JFrame("Your Friends' friends");
	private static JTextArea dispanl = new JTextArea(" ");
	private static JButton addds = new JButton("Back");
	private static JLabel sta = new JLabel();

	public static void main(String[] args) {
		// setting the JFrames
		frame6.setLayout(new FlowLayout());
		frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame6.pack();
		frame6.setSize(500, 500);
		frame8.setLayout(new FlowLayout());
		frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame8.pack();
		frame8.setSize(500, 500);
		frame = new JFrame();
		frame.setLayout(new FlowLayout());
		frame3 = new JFrame();
		frame3.setLayout(new FlowLayout());
		frame3.setVisible(false);
		frame7.setLayout(new FlowLayout());
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame7.pack();
		frame7.setSize(500, 500);
		frame7.setVisible(false);

		final int FIELD_WIDTH = 20;
		JLabel askingID = new JLabel("Enter your ID (1 - 7): ");
		textArea = new JTextArea(" ");
		JButton enter = new JButton("Enter");
		firstPanel = new JPanel();
		firstPanel.add(askingID, BorderLayout.NORTH);
		firstPanel.add(textArea, BorderLayout.CENTER);
		firstPanel.add(enter, BorderLayout.SOUTH);
		frame.add(firstPanel);

		enter.addActionListener(e -> {
			P1();

		});
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.pack();
		frame3.setSize(500, 500);// set frame size and let teh game begin

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(500, 500);// set frame size and let teh game begin
		frame.setVisible(true);

	} // end main

	public static void P1() {
		// the welcome window, which welcomes the user.
		String id = textArea.getText();
		// System.out.println(id);
		// tt.profileDisplay();
		String news = id.substring(0, 1);

		Profile vishaal = new Profile();
		vishaal.setName("vishaal");
		vishaal.setStatus("My name is Vishaal.");
		vishaal.setID("1");

		Profile dylan = new Profile();
		dylan.setName("dylan");
		dylan.setStatus("hey, sup?");
		dylan.setID("2");

		Profile will = new Profile();
		will.setName("will");
		will.setStatus("call me");
		will.setID("3");

		Profile travis = new Profile();
		travis.setName("travis");
		travis.setStatus("ITS LIT");
		travis.setID("4");

		Profile Sam = new Profile();
		Sam.setName("Sam");
		Sam.setStatus("its rockin");
		Sam.setID("5");

		Profile luke = new Profile();
		luke.setName("luke");
		luke.setStatus("star wars");
		luke.setID("6");

		Profile faith = new Profile();
		faith.setName("faith");
		faith.setStatus("yo");
		faith.setID("7");
// adding profiles to network
		m.addProfile(vishaal);
		m.addProfile(dylan);
		m.addProfile(will);
		m.addProfile(travis);
		m.addProfile(Sam);
		m.addProfile(luke);
		m.addProfile(faith);
		// creating friendships
		m.createFriendship(vishaal, dylan);
		
		m.createFriendship(vishaal, travis);
		m.createFriendship(travis, dylan);
		m.createFriendship(will, travis);
		m.createFriendship(will, Sam);
		m.createFriendship(will, faith);
		m.createFriendship(luke, Sam);
		m.createFriendship(dylan, faith);
		

		dcc = Integer.toString(totalid);

		
		temp = m.SearchByID(news);

		

		
		frame3.setTitle("Welcome " + temp.getName());
		
		helloPanel = new JPanel();
		// adding buttons to the frame

		JButton modifyProfile = new JButton("Modify my Profile");
		JButton createProfile = new JButton("Create a Profile");
		JButton searchProfile = new JButton("Search a Profile");
		JButton addFriend = new JButton("Add a friend");

		JButton seeFF = new JButton("See Friends' friends");
		JButton exit = new JButton("Exit");
		helloPanel.add(modifyProfile, BorderLayout.SOUTH);

		helloPanel.add(createProfile, BorderLayout.SOUTH);
		helloPanel.add(searchProfile, BorderLayout.SOUTH);

		helloPanel.add(addFriend, BorderLayout.SOUTH);
		helloPanel.add(seeFF, BorderLayout.SOUTH);
		helloPanel.add(exit, BorderLayout.SOUTH);
		frame3.setLayout(new BorderLayout(1, 6));

		frame3.add(helloPanel);
		frame.setVisible(false);
		frame3.setVisible(true);
		exit.addActionListener(e -> {
			System.exit(0);
		});
// adding button functionality
		seeFF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				dispanl.setText(" ");
				pedd = vishaal.getFriends();
				String x = " ";

				for (int s = 0; s < pedd.getLength(); s++) {
					peddd = pedd.getEntry(s + 1).getFriends();
					for (int k = 1; k < peddd.getLength(); k++) {
						if (pedd.getEntry(s + 1).getName() != peddd.getEntry(k + 1).getName()) {
							x += peddd.getEntry(k + 1).getName() + ", ";

						}

					}
				}
				dispanl.setText(x);
				frame8.add(dispanl, BorderLayout.CENTER);
				frame8.add(addds, BorderLayout.SOUTH);
				frame3.setVisible(false);
				frame8.setVisible(true);
				addds.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent dxz) {
						frame8.setVisible(false);
						P1();
					}
				});

			}
		});
		// adding button functionality
		addFriend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent qws) {
				JLabel de = new JLabel("Enter the ID, you want to add as friend");
				JTextArea qwx = new JTextArea(" ");
				sta.setText(" ");

				JButton gec = new JButton("Enter");
				JButton dss = new JButton("Back");
				frame7.add(de, BorderLayout.NORTH);
				frame7.add(qwx, BorderLayout.CENTER);
				frame7.add(gec, BorderLayout.CENTER);
				frame7.add(dss, BorderLayout.SOUTH);

				frame3.setVisible(false);
				frame7.setVisible(true);

				gec.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent dcx) {
						String idTOadd = qwx.getText();
						if (idTOadd.length() == 2)
							idTOadd = idTOadd.substring(0, 1);
						else if (idTOadd.length() == 3)
							idTOadd = idTOadd.substring(0, 2);
						toax = m.SearchByID(idTOadd);

						frame7.add(sta, BorderLayout.SOUTH);
						if (toax == null)
							sta.setText("Profile not found");
						else {
							m.createFriendship(temp, toax);
							sta.setText(toax.getName() + " added as your friends");
							m.displayAllProfileInfo();
						}
						dss.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent ss) {
								m.displayAllProfileInfo();
								frame7.setVisible(false);
								P1();

							}
						});

					}
				});

			}
		});
		// adding button functionality
		searchProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent qw) {
				frame6.add(reto, BorderLayout.NORTH);
				frame6.add(getSearch, BorderLayout.CENTER);
				frame6.add(disp, BorderLayout.CENTER);
				frame6.add(anod, BorderLayout.CENTER);
				frame6.add(back, BorderLayout.SOUTH);
				frame3.setVisible(false);
				frame6.setVisible(true);
				disp.setText(" ");
				anod.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						String toSearch = getSearch.getText();
						disp.setText(" ");
						if (toSearch.length() == 2)
							toSearch = toSearch.substring(0, 1);
						else if (toSearch.length() == 3)
							toSearch = toSearch.substring(0, 2);
						cs = m.SearchByID(toSearch);

						disp.setText(" ");
						System.out.print(toSearch + "d");
						if (cs == null)
							disp.setText("not found.");
						else
							disp.setText(
									"ID: " + cs.getID() + ", Name: " + cs.getName() + ", Status: " + cs.getStatus());
						back.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent wa) {
								frame6.setVisible(false);
								P1();

							}
						});

					}
				});

			}
		});
		// adding button functionality
		createProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent eve) {
				frame5 = new JFrame();
				frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame5.pack();
				frame5.setSize(500, 500);
				frame5.setTitle("Creating a profile");
				frame5.add(back, BorderLayout.SOUTH);
				getN.setText(" ");
				getS.setText(" ");
				cret.setLayout(new FlowLayout());
				cret.add(enterName, BorderLayout.NORTH);
				cret.add(getN, BorderLayout.NORTH);
				cret.add(enterStatus, BorderLayout.CENTER);
				cret.add(getS, BorderLayout.CENTER);
				cret.add(r4, BorderLayout.SOUTH);
				frame5.add(cret);
				frame3.setVisible(false);
				frame5.setVisible(true);
				back.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent wa) {
						frame5.setVisible(false);
						frame6.setVisible(false);
						P1();

					}
				});

				r4.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent es) {
						String newName = getN.getText();
						String newStatus = getS.getText();
						dc.setName(newName);
						dc.setStatus(newStatus);
						dcc = Integer.toString(totalid);
						dc.setID(dcc);
						totalid++;
						m.addProfile(dc);
						m.displayAllProfileInfo();
						frame5.setVisible(false);
						P1();
					}
				});

			}
		});
		// adding button functionality
		modifyProfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				frame4 = new JFrame();
				frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame4.pack();
				frame4.setSize(500, 500);// set frame size and let teh game begin
				frame3.setVisible(false);
				frame4.setVisible(true);

				k.setText(" ");
				j.add(h, BorderLayout.NORTH);
				j.add(k, BorderLayout.CENTER);

				j.add(anothe, BorderLayout.SOUTH);

				frame4.add(j);

				anothe.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent even) {
						m.changeStatus(k.getText(), temp.getID());
						m.displayAllProfileInfo();
						frame4.setVisible(false);
						P1();

					}

				});

			}
		});

	}

} // end Driver

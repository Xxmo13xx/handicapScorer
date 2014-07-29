import java.awt.*;
import java.awt.Event.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Gui {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JPanel userInputPanel;
	private JPanel controlPanel;
	private JList playerListBox;
	JScrollPane listScroller;
	private Controller viewController;
	private JTextField textField;
	private JButton button1 = new JButton("");
	private JButton button2 = new JButton("");
	
//	public static void main(String[] args){
//		Gui gui = new Gui();
//		gui.showGetPlayer();
//	}
	
	public Gui(Controller controller){
		viewController = controller;
		prepareGui();
		showGetPlayer();
	}
	
	public void prepareGui(){
		// creates the new frame
		mainFrame = new JFrame("Handicap Calculator");
		// sets the size for the main frame
		mainFrame.setSize(400,400);
		// determines which layout to use
		mainFrame.setLayout(new GridLayout(3,1));
		// creates a Label to tell the user what to do. 
		headerLabel = new JLabel("", JLabel.CENTER);
		// creates a listener to exit the application if the user clicks on close. 
		mainFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});
		
		userInputPanel = new JPanel();
		userInputPanel.setLayout(new FlowLayout());
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		controlPanel.add(button1);
		controlPanel.add(button2);
		
		mainFrame.add(headerLabel);
		mainFrame.add(userInputPanel);
		mainFrame.add(controlPanel);
		mainFrame.setVisible(true);	
	}
	
	public void showGetPlayer(){
		headerLabel.setText("Choose a player or you can add a new one.");
		String[] playerList = viewController.getPlayersNames();
		
//		for(int i = 0; i < viewController.getNumberOfPlayers(); i++){
//			playerList.add(viewController.)
//		}
		
		playerListBox = new JList(playerList);
		playerListBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		playerListBox.setLayoutOrientation(JList.VERTICAL_WRAP);
		playerListBox.setVisibleRowCount(-1);
		
		listScroller = new JScrollPane(playerListBox);
		listScroller.setPreferredSize(new Dimension(100,100));
		userInputPanel.removeAll();
		userInputPanel.add(listScroller);
		userInputPanel.repaint();
		
//		button1 = new JButton("Create a new player");
		button1.setText("Create a new player");
		button1.setActionCommand("newPlayer");
		button1.addActionListener(new ButtonClickListener());
		
//		button2 = new JButton("Next");
		button2.setText("Next");
		button2.setActionCommand("goToOptionsMenu");
		button2.addActionListener(new ButtonClickListener());
		
		//controlPanel.removeAll();
//		controlPanel.add(button1);
//		controlPanel.add(button2);
		//controlPanel.repaint();
		mainFrame.setVisible(true);
	}
	public void showCreateNewPlayer(){
		headerLabel.setText("Add the players name in the box.");
		
		textField = new JTextField(20);
		textField.setText("");
		textField.addActionListener(new TextListener());
		userInputPanel.removeAll();
		userInputPanel.add(textField);
		userInputPanel.repaint();
		
		button1.setText("Choose a different player.");
		button1.setActionCommand("playerMenu");

		
		
	}
	
	private class TextListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String text = textField.getText();
			//System.out.println(text);
		}
	}
	private class ButtonClickListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String command = e.getActionCommand();
			if(command.equals("newPlayer")){
				showCreateNewPlayer();
			} else if (command.equals("goToOptionsMenu")){
				System.out.println(playerListBox.getSelectedValue());
			} else if (command.equals("playerMenu")){
//				System.out.println("Before player menu");
//				System.out.println(viewController.getListOfPlayers());
				System.out.println(textField.getText());
				viewController.addNewPlayer(textField.getText());
//				System.out.println("After player menu");
				
//				System.out.println(viewController.getListOfPlayers());
				showGetPlayer();
			}
//			else if (command.equals("addThisPlayer")){
//				
//			}
			
			
		}
	}
	
//	private class sharedListSelectionListener implements ListSelectionListener{
//		public void valueChanged(ListSelectionEvent e){
//			ListSelectionModel lsm = (ListSelectionModel)e.getSource();
//			int firstIndex = e.getFirstIndex();
//			int lastIndex = e.getLastIndex();
//			boolean isAdjusting = e.getValueIsAdjusting();
//			StringBuilder output = new StringBuilder();
//			output.append("Event for indexes "
//                    + firstIndex + " - " + lastIndex
//                    + "; isAdjusting is " + isAdjusting
//                    + "; selected indexes:");
//
//      if (lsm.isSelectionEmpty()) {
//          output.append(" <none>");
//      } else {
//          // Find out which indexes are selected.
//          int minIndex = lsm.getMinSelectionIndex();
//          int maxIndex = lsm.getMaxSelectionIndex();
//          for (int i = minIndex; i <= maxIndex; i++) {
//              if (lsm.isSelectedIndex(i)) {
//                  output.append(" " + i);
//              }
//          }
//      }
//      output.append("\n");
//      System.out.println(output);
//     // output.setCaretPosition(output.getDocument().getLength());
//		}
//		}
	
	
	
}

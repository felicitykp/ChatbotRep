import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Chatbot {
	
	//VARIABLES
	private final int WIDTH = 600, HEIGHT = 600, TEXTHEIGHT = 475;
	private JTextArea displayarea, typearea;
	private boolean entered = false;
	private final String[] answers = {"Haha, so funny", "Wait what?", "I love pickles", "That's so annoying", "What time do you want to go?",
			"Blue is my favorite color", "Do you like pickles", "Boo", "I hate you :(", "Thats a big oof", "What are you even talking about?",
			"I'm over this convo", "Wait .... dont leave", "We're all in this together", "Ew you don't social distance...", "Thats spooky"};
	
	//CONSTRUCTOR
	public Chatbot() {
		
		//set up panel
		JPanel panel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(boxlayout);
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.decode("#577399"), 6), 
				"AI Chat Bot", TitledBorder.CENTER, TitledBorder.TOP, new Font("Ariel",Font.BOLD,18), Color.decode("#577399")));
		panel.setBackground(Color.decode("#BDD5EA"));
		
		
		//set up text display area
		displayarea = new JTextArea();
		displayarea.setEditable(false);
		displayarea.setBackground(Color.WHITE);
		displayarea.setForeground(Color.decode("#495867"));
		
		//set up text entering area
		typearea = new JTextArea();
		typearea.setEditable(true);
		typearea.setBackground(Color.WHITE);
		typearea.setForeground(Color.decode("#495867"));
		
		//key listener
		typearea.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
				if (e.getKeyChar() == '\n')
					sendReceive();
				}
			public void keyPressed(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			});
		
		//setup scroll panes
		JScrollPane scroll = new JScrollPane (displayarea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JScrollPane scroll2 = new JScrollPane (typearea);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(WIDTH,TEXTHEIGHT));
		scroll2.setPreferredSize(new Dimension(WIDTH,HEIGHT-TEXTHEIGHT));
		panel.add(scroll);
		panel.add(scroll2);
		
		//button listener
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendReceive();
				}});
		
		//inner panel for button
		JPanel innerPanel = new JPanel();
		innerPanel.add(sendButton);
		panel.add(innerPanel);
		
		//main container
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		panel.setFocusable(true);
		
		//beginning text display
		displayarea.setText("\n Welcome to AI ChatBot. Say anything to start the conversation.");
		
		run();
		
		}
	
		public void sendReceive() {
			//if real message then add
			if (!typearea.getText().trim().equals("")) {
				displayarea.setText(displayarea.getText()+"\n\n   User4931: "+typearea.getText().trim());
				entered = true;
			}
			
			//clear type area
			typearea.setText("");
		}
		
		public void run() {
			while(true) {
				if (entered) {
					try {Thread.sleep(500);}
					catch (InterruptedException e) {}
					int rand = (int)(Math.random()*answers.length);
					displayarea.setText(displayarea.getText()+"\n\n   ChatBot: "+answers[rand]);
					entered = false;
				}
				try {Thread.sleep(50);} 
				catch (InterruptedException e) {}
			}
		}
		
		public static void main(String[] args) {
			new Chatbot();
			}
		
		
		
}
	



import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login extends JFrame{
	//Attributes
	private JFrame frame = new JFrame("Login");
	private JPanel fondoFrame = new JPanel();
	private JPanel centralPanel = new JPanel();
	int xCenter;
	int yCenter;
	private String name;
	private String password;
	private JButton signInBtn = new JButton("Sign in");
	private JTextField nameBox = new JTextField();
	private JTextField passwordBox = new JTextField();
	
	
	
	//Builder
	public login(){
		frame.setSize(1500,800);
		xCenter = frame.getWidth()/2;
		yCenter = frame.getHeight()/2;
		//System.out.print(yCenter-150);
		frame.add(fondoFrame);
		frame.setVisible(true);
		frame.add(centralPanel);
		
		centralPanel.setBounds(xCenter-(600/2),yCenter-(300/2)
				,600,300);
		centralPanel.add(nameBox);
		centralPanel.setBackground(Color.decode("#ffa424"));
		
		centralPanel.add(nameBox);
		nameBox.setBounds(0,0,500,400);
		centralPanel.setVisible(true);
		//centralPanel.add(nameBox);
		//frame.add(centralPanel.add(nameBox));
		
		
		
		//nameBox.setBounds(xCenter-(150/2),200,150,25);
		/*
		passwordBox.setBounds(xCenter-(150/2),250,150,25);
		signInBtn.setBounds(xCenter-50,350
				, 100, 50);
		signInBtn.setBounds(xCenter-50,350
				, 100, 50);
		
		//userNameTf.setBounds(x, y, width, height); Me he quedado aquí
		frame.add(signInBtn);
		frame.add(nameBox);
		frame.add(passwordBox);
	*/
	}
	public void buidSignUpPanel(JPanel panel) {
		
	}
	
	
	//
	public static void main(String[] args) {
		login jframe = new login();
		
		
	}
	
}
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login extends JPanel{
	//Attributes
	private JFrame frame;
	private JPanel centralPanel = new JPanel();
	int xCenter;
	int yCenter;
	private String name;
	private String password;
	private JButton signInBtn = new JButton("Sign in");
	private JTextField nameBox = new JTextField();
	private JTextField passwordBox = new JTextField();
	
	
	
	//Builder
	public login(JFrame frame){
		this.frame = frame;
		xCenter = frame.getWidth()/2;
		yCenter = frame.getHeight()/2;
		System.out.print(yCenter-150);
		centralPanel.setBounds(xCenter-(600/2),yCenter-(300/2)
				,600,300);
		centralPanel.setBackground(Color.decode("#ffa424"));
		nameBox.setBounds(200,100,500,400);
		frame.add(centralPanel);
		centralPanel.add(nameBox);
		frame.add(centralPanel.add(nameBox));
		
		
		
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
		JFrame jframe = new JFrame("Login");
		jframe.setSize(1500,800);
		login login1 = new login(jframe);
		//x,y
		//login1.setBounds(40,80,200,200);
		login1.setBackground(Color.decode("#252440"));
		login1.setVisible(true);
		jframe.add(login1);
		jframe.setVisible(true);
		
	}
	
}
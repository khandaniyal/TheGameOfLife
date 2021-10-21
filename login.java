import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login extends JPanel{
	//Attributes
	private JFrame frame;
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
		nameBox.setBounds(xCenter-(150/2),200,150,25);
		
		passwordBox.setBounds(xCenter-(150/2),250,150,25);
		signInBtn.setBounds(xCenter-50,350
				, 100, 50);
		signInBtn.setBounds(xCenter-50,350
				, 100, 50);
		
		//userNameTf.setBounds(x, y, width, height); Me he quedado aquí
		frame.add(signInBtn);
		frame.add(nameBox);
		frame.add(passwordBox);
	}
	
	
	//
	public static void main(String[] args) {
		JFrame jframe = new JFrame("Login");
		jframe.setSize(1000,500);
		login login1 = new login(jframe);
		//x,y
		//login1.setBounds(40,80,200,200);
		login1.setBackground(Color.ORANGE);
		login1.setVisible(true);
		jframe.add(login1);
		jframe.setVisible(true);
		
	}
	
}
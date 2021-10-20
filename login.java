import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class login extends JPanel{
	//Attributes
	private JFrame frame;
	float xCenter;
	float yCenter;
	private String name;
	private String password;
	private JButton signInBtn = new JButton("Sign in");
	private JTextField userNameTf = new JTextField();
	
	
	
	//Builder
	public login(JFrame frame){
		this.frame = frame;
		xCenter = frame.getWidth()/2;
		yCenter = frame.getHeight()/2;
		signInBtn.setSize(100, 50);
		signInBtn.setBounds((frame.getWidth()/2)-(signInBtn.getWidth()/2)
				,((frame.getHeight()/4)*3)-(signInBtn.getHeight()/2) 
				, 100, 50);
		//userNameTf.setBounds(x, y, width, height); Me he quedado aquí
		frame.add(signInBtn);
		frame.add(userNameTf);
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
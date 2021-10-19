import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class login extends JPanel{
	//Attributes
	private String name;
	private String password;
	private JButton signIn = new JButton();
	//Builder
	public login(JFrame frame){
		signIn.setBounds(500,frame.getHeight()/2 , 150, 75);//x,y,w,h
		frame.add(signIn);
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
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class login extends JFrame{
	//Attributes
	private int x;
	private int y;

	private JFrame frame = new JFrame("Login");
	private JPanel panel0 = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private String name;
	private String password;
	private JButton signInBtn = new JButton("Sign in");
	private JTextField nameBox = new JTextField();
	private JTextField passwordBox = new JTextField();




	//Builder
	public login(){
	//	frame.setSize(1200-75,700-150);
		this.x=1000;
		this.y=600;
		frame.setSize(x,y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(panel0);
		panel0.setBackground(Color.decode("#252440"));

		panel0.setLayout(null);

		//panel1.setBounds(810-75, 0, 400, 700-150);
		panel1.setBounds(x*70/100, 0, 400, 700-150);
		panel0.add(panel1);
		panel1.setBackground(Color.decode("#2c2c2c"));//ffa424
		panel1.setLayout(null);

		nameBox.setBounds(100, 160, 200, 20);
		passwordBox.setBounds(100,262,200,20);
		signInBtn.setBounds(100,360,100,60);

		panel1.add(nameBox);
		panel1.add(passwordBox);
		panel1.add(signInBtn);

		frame.setVisible(true);


	}
	public void buidSignUpPanel(JPanel panel) {

	}
	//Returns the correspondent percentage of a number
	public float percentage(float percentage, float full ){

	}


	//
	public static void main(String[] args) {
		login jframe = new login();


	}
}

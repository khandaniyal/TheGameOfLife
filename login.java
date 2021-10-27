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
		panel0.setBackground(Color.decode("#ffa424"));//#252440   

		panel0.setLayout(null);

		//panel1.setBounds(810-75, 0, 400, 700-150);
		panel1.setBounds(percentage(70,x), 0, percentage(30,x), y);
		panel0.add(panel1);
		panel1.setBackground(Color.decode("#2c2c2c"));//ffa424  #2c2c2c
		panel1.setLayout(null);
		
		nameBox.setBounds(percentage(25,panel1.getWidth()), 160, percentage(50,panel1.getWidth()), 20);
		passwordBox.setBounds(percentage(25,panel1.getWidth()), 260, percentage(50,panel1.getWidth()), 20);
		signInBtn.setBounds(percentage(35,panel1.getWidth()),360,percentage(30,panel1.getWidth()),50);
		
		
		
		panel1.add(nameBox);
		panel1.add(passwordBox);
		panel1.add(signInBtn);

		frame.setVisible(true);


	}
	public void buidSignUpPanel(JPanel panel) {
		
	}
	//Returns the correspondent percentage of a number
	public int percentage(int percentage, int full ){
		return (percentage*full)/100;
	}


	//
	public static void main(String[] args) {
		login jframe = new login();


	}
}

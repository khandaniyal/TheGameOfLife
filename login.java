import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter ;
import java.awt.event.MouseEvent;





public class login {
	//Attributes
	private int x;
	private int y;

	private JFrame frame = new JFrame("Login");

	private JPanel panel0 = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();

	private JButton signInBtn = new JButton("Sign in");

	private JTextField nameBox = new JTextField();
	private JPasswordField passwordBox = new JPasswordField();

	private JLabel lblTitle = new JLabel(new String("Title"));
	private JLabel lblName = new JLabel(new String("UserName"));
	private JLabel lblPassword = new JLabel(new String("Password"));
	private JLabel lblRegister = new JLabel(new String("I am not registred"));

	//Builder
	public login(){
		buidSignUpPanel();
	}

	//Getters & Setters

	public String getName() {
		return nameBox.getText();
	}
	public String getPassword() {
		return passwordBox.getPassword().toString();
	}

	public void buidSignUpPanel() {
		this.x=1000;
		this.y=600;
		frame.setSize(x,y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		//JPanel0
		frame.getContentPane().add(panel0);
		panel0.setBackground(Color.decode("#252440"));//#252440
		panel0.setLayout(null);
		//JPanel1
		panel1.setBounds(percentage(70,x), 0, percentage(30,x), y);
		panel0.add(panel1);
		panel1.setBackground(Color.decode("#2c2c2c"));//ffa424  #2c2c2c
		panel1.setLayout(null);
		//Boxes
		nameBox.setBounds(percentage(25,panel1.getWidth()), 160, percentage(50,panel1.getWidth()), 20);
		passwordBox.setBounds(percentage(25,panel1.getWidth()), 260, percentage(50,panel1.getWidth()), 20);
		passwordBox.setEchoChar('*');//if we don't call this function puts points
		//Buttons
		signInBtn.setBounds(percentage(35,panel1.getWidth()),360,percentage(30,panel1.getWidth()),50);
		//Labels
		lblTitle.setBounds(percentage(20, panel1.getWidth()), 60, 200, 50);
		lblTitle.setForeground(Color.decode("#ffa424"));
		lblRegister.setBounds(signInBtn.getX(), signInBtn.getY()+50, 100, 50);
		lblRegister.setForeground(Color.decode("#ffa424"));
		lblRegister.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
						formRegisterWindow();
				}
		});

		//Add buttons and boxes
		panel1.add(nameBox);
		panel1.add(passwordBox);
		panel1.add(signInBtn);
		panel1.add(lblRegister);
		panel1.add(lblTitle);
		frame.setVisible(true);
	}

	//Methods

	public void clickLabel() {//temporal name
			formRegisterWindow();
	}

	public void formRegisterWindow(){
			final JFrame formWindow = new JFrame("Form");
			formWindow.setSize(100,200);
			formWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			formWindow.setVisible(true);
	}

	//Returns the correspondent percentage of a number
	public int percentage(int percentage, int full ){
		return (percentage*full)/100;
	}
	/////////////////////////////////////
	public static void main(String[] args) {
		login jframe = new login();


	}
}

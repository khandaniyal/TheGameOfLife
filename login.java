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
	public static final Color labelColor  = Color.decode("#ffa424"); //warmOrange
	public static final Color loginMenuColor  = Color.decode("#2c2c2c");//galaBlack
	public static final Color loginScreenColor  = Color.decode("#252440");//marine

	private int x;
	private int y;

	private JFrame frame = new JFrame("Login");

	private JPanel panel0 = new JPanel();
	private JPanel panel1 = new JPanel();

	private JButton signInBtn = new JButton("Sign in");

	private JTextField nameTf = new JTextField();
	private JPasswordField passwordTf = new JPasswordField();

	private JLabel lblTitle = new JLabel(new String("Title"));
	private JLabel lblName = new JLabel(new String("UserName"));
	private JLabel lblPassword = new JLabel(new String("Password"));
	private JLabel lblWarning = new JLabel(new String("Wrong name or Password"));
	private JLabel lblRegister = new JLabel(new String("I am not registred"));
	

	//Builder
	public login(){
		buidSignUpPanel();
	}

	//Getters & Setters

	public String getName() {
		return nameTf.getText();
	}
	public String getPassword() {
		return passwordTf.getPassword().toString();
	}

	public void buidSignUpPanel() {
		this.x=1000;
		this.y=600;
		frame.setSize(x,y);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		//JPanel0
		frame.getContentPane().add(panel0);
		panel0.setBackground(loginScreenColor);//#252440
		panel0.setLayout(null);
		//JPanel1
		panel1.setBounds(percentage(70,x), 0, percentage(30,x), y);
		panel0.add(panel1);
		panel1.setBackground(loginMenuColor);//ffa424  #2c2c2c
		panel1.setLayout(null);
		//JTextFields_____________________
		nameTf.setBounds(
				percentage(25,panel1.getWidth())	//x
				, 160
				, percentage(50,panel1.getWidth())	//y
				, 20);
		passwordTf.setBounds(
				percentage(25,panel1.getWidth())	//width
				, 260
				, percentage(50,panel1.getWidth())
				, 20);
		passwordTf.setEchoChar('*');//if we don't call this function puts points when we write
		//Buttons_____________________
		signInBtn.setBackground(Color.decode("#F5F5DC"));
		signInBtn.setBounds(
				percentage(35,panel1.getWidth())
				,360
				,percentage(30,panel1.getWidth())
				,50);
		//Labels_____________________
		lblTitle.setBounds(
				percentage(20, panel1.getWidth())
				, 60
				, 400
				, 25);
		lblTitle.setForeground(labelColor);

		lblName.setBounds(
				nameTf.getX()
				, nameTf.getY()-40
				, 400
				, 10);
		lblName.setForeground(labelColor);

		lblPassword.setBounds(
				passwordTf.getX()
				, passwordTf.getY()-40
				, 400
				, 50);
		lblPassword.setForeground(labelColor);

		lblRegister.setBounds(
				nameTf.getX()
				, signInBtn.getY()+60
				, (int) Math.round(lblRegister.getText().length()*7.22) //130 
				, 20);
		System.out.println(lblRegister.getText()+" "+lblRegister.getText().length()*7);
		lblRegister.setForeground(labelColor);
		lblRegister.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e){
						try {
							formRegisterWindow();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
				public void mouseEntered(MouseEvent e) {
					lblRegister.setForeground(Color.WHITE);
				}
				public void mouseExited(MouseEvent e) {
					lblRegister.setForeground(labelColor);
				}
		});

		//Add buttons,boxes and labels
		panel1.add(nameTf);
		panel1.add(passwordTf);
		panel1.add(signInBtn);
		panel1.add(lblRegister);
		panel1.add(lblTitle);
		panel1.add(lblName);
		panel1.add(lblPassword);
		frame.setVisible(true);
	}

	//Methods
	//Call the form window
	public void formRegisterWindow() throws Exception{
			form formWindow = new form(frame.getWidth(), frame.getHeight());
	}
	

	//Returns the correspondent percentage of a number
	public static int percentage(int percentage, int full ){
		return (percentage*full)/100;
	}
	/////////////////////////////////////
	public static void main(String[] args) {
		login jframe = new login();


	}
}

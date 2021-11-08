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
import java.sql.SQLException;

import DB.UserDB;

public class LogIn {
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
    private JLabel lblRegister = new JLabel(new String("I am not registred"));

    //Builder
    public LogIn(){
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
        this.x = 1000;
        this.y = 600;
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
        //JTextFields
        nameTf.setBounds(percentage(25,panel1.getWidth()), 160, percentage(50,panel1.getWidth()), 20);
        passwordTf.setBounds(percentage(25,panel1.getWidth()), 260, percentage(50,panel1.getWidth()), 20);
        passwordTf.setEchoChar('*');//if we don't call this function puts points
        //Buttons
        signInBtn.setBounds(percentage(35,panel1.getWidth()),360,percentage(30,panel1.getWidth()),50);
        //Labels
        lblTitle.setBounds(percentage(20, panel1.getWidth()), 60, 400, 50);
        lblTitle.setForeground(labelColor);

        lblName.setBounds(nameTf.getX(), nameTf.getY()-40, 400, 50);
        lblName.setForeground(labelColor);

        lblPassword.setBounds(passwordTf.getX(), passwordTf.getY()-40, 400, 50);
        lblPassword.setForeground(labelColor);

        lblRegister.setBounds(nameTf.getX(), signInBtn.getY()+50, 400, 50);
        lblRegister.setForeground(labelColor);
        lblRegister.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                formRegisterWindow();
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
    public void formRegisterWindow(){
        Form formWindow = new Form(frame.getWidth(), frame.getHeight());
    }

    //Returns the correspondent percentage of a number
    public static int percentage(int percentage, int full ){
        return (percentage*full)/100;
    }
    /////////////////////////////////////
    public static void main(String[] args) throws SQLException {
        LogIn jframe = new LogIn();


    }
}
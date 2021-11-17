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
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.SQLException;

import javax.imageio.ImageIO;

public class Form extends JFrame {
    //Attributes
    private final JPanel panel = new JPanel();
    private final JLabel nameLbl = new JLabel("Name");
    private final JLabel passwordLbl = new JLabel("Password");
    private final JTextField nameTf = new JTextField();
    private final JPasswordField passwordTf = new JPasswordField();
    private  JButton signUpBtn = new JButton("Sign Up");

    // private BufferedImage myPicture = ImageIO.read(new File("formIcon.jpg"));//<I stayed here

    //Getters && Setters
    public String getName() {
        return nameTf.getText();
    }
    public String getPassword() {
        return new String(passwordTf.getPassword());
    }

    //Builder
    Form (int loginWitdth, int loginHeight) throws SQLException{
        setTitle("Form");
        setSize(LogIn.percentage(50 ,loginWitdth),LogIn.percentage(50, loginHeight));
        setLocationRelativeTo(null);
        panel.setBackground(LogIn.loginMenuColor);
        panel.setLayout(null);
        //TextFields
        nameTf.setBounds(LogIn.percentage(60, getWidth()),
                LogIn.percentage(20, getHeight()), LogIn.percentage(30, getWidth()),20);
        passwordTf.setBounds(nameTf.getX(), nameTf.getY()+70, nameTf.getWidth(), 20);
        passwordTf.setEchoChar('*');
        //Labels
        nameLbl.setBounds(nameTf.getX(), nameTf.getY()-40,400,50);
        nameLbl.setForeground(LogIn.labelColor);
        passwordLbl.setBounds(nameTf.getX(),passwordTf.getY()-40,400,50);
        passwordLbl.setForeground(LogIn.labelColor);
        //Buttons
        signUpBtn.setBounds(passwordTf.getX()+LogIn.percentage(15, passwordTf.getWidth())
                , passwordTf.getY()+50
                , LogIn.percentage(70, passwordTf.getWidth())
                , 50);
        signUpBtn.setBackground(LogIn.buttonsColor);
        signUpBtn.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){

                try {
                    addUsers();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }//Save the credentials on database
            }
        });

        add(panel);
        panel.add(nameTf);
        panel.add(passwordTf);
        panel.add(nameLbl);
        panel.add(passwordLbl);
        panel.add(signUpBtn);
        setVisible(true);
    }

    public void addUsers() throws SQLException {//Override with database conection
    	/*
    	login.users.add(getName());
    	login.passwords.add(getPassword().toString());
    	for (String u: login.users) {
    		System.out.println(u);
    	}
    	for (String p: login.passwords) {
    		System.out.println(p);
    	}*/
        LogIn.dataBase.connectDB();
        LogIn.dataBase.insertUser(getName(), getPassword());
        LogIn.dataBase.disconnectDB();
    }



}
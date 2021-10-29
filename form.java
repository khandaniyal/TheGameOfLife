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
import javax.imageio.ImageIO;

public class form extends JFrame {
    //Attributes
    private final JPanel panel = new JPanel();

    private final JLabel nameLbl = new JLabel("Name");
    private final JLabel passwordLbl = new JLabel("Password");

    private final JTextField nameTf = new JTextField();
    private final JPasswordField passwordTf = new JPasswordField();

    private  JButton signUpBtn = new JButton("Sign Up");

    private BufferedImage myPicture = ImageIO.read("A image");//<I stayed here

    //Builder
    form(int loginWitdth, int loginHeight){
      setTitle("Form");
      setSize(login.percentage(50 ,loginWitdth),login.percentage(50, loginHeight));
      setLocationRelativeTo(null);

      panel.setBackground(login.loginMenuColor);
      panel.setLayout(null);
      //TextFields
      nameTf.setBounds(login.percentage(60, getWidth()),
          login.percentage(20, getHeight()), login.percentage(30, getWidth()),20);
      passwordTf.setBounds(nameTf.getX(), nameTf.getY()+70, nameTf.getWidth(), 20);
      passwordTf.setEchoChar('*');
      //Labels
      nameLbl.setBounds(nameTf.getX(), nameTf.getY()-40,400,50);
      nameLbl.setForeground(login.labelColor);
      passwordLbl.setBounds(nameTf.getX(),passwordTf.getY()-40,400,50);
      passwordLbl.setForeground(login.labelColor);

      add(panel);
      panel.add(nameTf);
      panel.add(passwordTf);
      panel.add(nameLbl);
      panel.add(passwordLbl);
      setVisible(true);
    }

}

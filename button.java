import java.awt.Color;
import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;

public class button  {
	//Attributes
	private String buttonName = "";
    private JButton etiquetabutton;
    private JPanel button; 
    //Builders
    public button(String buttonName, JButton etiquetabutton, JPanel button) {
        setName(etiquetabutton, buttonName);
        setButton(button);
        
      
    }
    //Getters and Setters
    private void setButton(JPanel button) {
    	button = new JPanel();
    	button.setBackground(Color.BLACK);
        button.setLayout(new GridLayout(0,3));
    }
    private JPanel getButton() {return button;}
    private void setName(JButton etiquetabutton, String buttonName) {
    	Scanner sc = new Scanner(System.in);
    	buttonName = sc.nextLine();
    	etiquetabutton = new JButton(buttonName);
        button.add(etiquetabutton);
    }    
    private JButton getName() {return etiquetabutton;}
}
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class theGameOfLife extends JFrame {
	//Attribute
	private int BOARD_SIZE = 25;
	private int ANIMATION_DELAY = 100;
	//private final Cells[][] cells;
    //private final Cells cell;
    //Panels
	private JPanel mainPanel = new JPanel();
	private JPanel universePanel = new JPanel();
    private JPanel buttonsPanel = new JPanel();
    private JPanel scorePanel = new JPanel();
    //JLabels
    private JLabel contador = new JLabel("Contador: ");
    
    private int count;
    
    //Builder
    public theGameOfLife() {
    	mainPanel.setLayout(new BorderLayout(0,1));
    	add(mainPanel);
    	
    	setSize(500,500);
    	setTitle("Game");
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	buildScorePanel();
    	buildUniversePanel();
    	buildPanelButtons();
    	
    	setLocationRelativeTo(null);
    	setVisible(true);
    	
    }
    //Methods
    public void buildScorePanel() {
    	scorePanel.setLayout(new GridLayout(3,3));//To change
    	scorePanel.setPreferredSize(new Dimension(this.getWidth(),20));
    	scorePanel.setBackground(Color.decode("#2c2c2c"));
    	mainPanel.add(scorePanel, BorderLayout.NORTH);
    }
    public void buildUniversePanel() {
    	universePanel.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
    	universePanel.setBackground(Color.ORANGE);
    	mainPanel.add(universePanel, BorderLayout.CENTER);
    }
    public void buildPanelButtons() {
    	buttonsPanel.setLayout(new GridLayout(20, 20));//To change
    	buttonsPanel.setPreferredSize(new Dimension(this.getWidth(),40));
    	buttonsPanel.setBackground(Color.decode("#2c2c2c"));
    	
    	mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
    	theGameOfLife hola = new theGameOfLife();
    }
   
	
}

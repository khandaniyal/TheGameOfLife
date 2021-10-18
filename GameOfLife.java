/* Conway's Game Of Life
 * How to play:
 * Right mouse click to draw, left mouse click to erase.
 * You can draw amd erase while the game is running
 *
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.*;

public class GameOfLife extends JFrame{
    private int btnSize;
    private boolean logicUnivers[][];
    private JButton cells[][];
    private Random rnd=new Random();
    private int count = 0;
    private JPanel univers;
    private int ms = 200;

    //Raw constructor
    public GameOfLife(int btnSize) {
        this.univers = univers;
        this.logicUnivers = logicUnivers;
        this.cells = cells;
        this.btnSize = btnSize;
        this.ms = ms;
        //Calls the function which will create the panel
        getPanel();
        logicUnivers = new boolean[btnSize][btnSize];
        cells = new JButton[btnSize ][btnSize];
        //Will print the board on the panel
        getBoard();
        //A class that fires one or more ActionEvents at specified intervals in this case we want our cells to live, die or create new cells.
        Timer timer = new Timer(ms,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean[][] tempUnivers = new boolean[btnSize][btnSize];
                checkNeighbours(tempUnivers);
            }
        });

        //Buttons
        JPanel buttons = new JPanel();
        buttons.setBackground(Color.BLACK);
        buttons.setLayout(new GridLayout(0,3));
        buttons.setBounds(150,510,220,50);

        JButton start = new JButton("Start");
        buttons.add(start);

        JButton stop = new JButton("Stop");
        buttons.add(stop);

        JButton clear = new JButton("Clear");
        buttons.add(clear);
        
        JButton morems = new JButton("+");
        buttons.add(morems);
        
        JTextField msnow = new JTextField(this.ms);
        msnow.setText(this.ms + "");
        buttons.add(msnow);
        
        JButton lessms = new JButton("-");
        buttons.add(lessms);
        //Actions listeners when the folowing button are pressed.
        //Starts the timer
        start.addActionListener(e->timer.start());

        //Stops the timer
        stop.addActionListener(e->timer.stop());
        
        //Clears the buttons which are painted
        clear.addActionListener(e->functionclear(timer));
      //speed up the timer
        morems.addActionListener(e->speedupms(msnow, ms));
      //the timer now
        msnow.addActionListener(e->rightnowms(msnow));
      //low speed the timer
        lessms.addActionListener(e->lowspeedms(msnow, ms));
        //A listener that wait when we interact with the mouse
        MouseListener mouseListener = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseExited(MouseEvent e) { }
            //In this function we want to get the current position of our mouse
            @Override
            public void mouseEntered(MouseEvent e) {
                //Current button where the mouse is laying on
                JButton currentBtnPressed = (JButton) e.getSource();
                //Get the grid size
                int gridSize = univers.getSize(getSize()).width/btnSize;
                //Get the position in this current axis.
                int AxisX = (currentBtnPressed.getLocation(getLocation()).x)/gridSize;
                int AxisY = (currentBtnPressed.getLocation(getLocation()).y)/gridSize;
                //Checks the current position of the mouse and checks if we are pressing the left mouse button as well.
                if (!logicUnivers[AxisY][AxisX] && SwingUtilities.isLeftMouseButton(e)) {
                    logicUnivers[AxisY][AxisX] = true;
                    //In this case paint the button with the following colour.
                    cells[AxisY][AxisX].setBackground(Color.GREEN);
                }
                //Here is viceversa and checks if the right button os the mouse is pressed
                if(logicUnivers[AxisY][AxisX] && SwingUtilities.isRightMouseButton(e)) {
                    logicUnivers[AxisY][AxisX] = false;
                    //In this case we want to erase the painted cells
                    cells[AxisY][AxisX].setBackground(Color.BLACK);
                }
            }

        };
        //Call the mouse listener when we are in the grid and pressing any button.
        for(int i = 0; i < btnSize;i++) {
            for(int j = 0; j < btnSize; j++) {
                cells[i][j].addMouseListener(mouseListener);
            }
        }
        //Add the following components on the panel
        add(univers, BorderLayout.CENTER);
        add(buttons);
        setLocationRelativeTo(null);
        setVisible(true);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Functions
    //Counts the neighbour cells surrounding each cell
    public int neighbours(int x, int y) {
        int count = 0;
        for(int i = x - 1; i <= x + 1; i++) {
            for(int j = y - 1; j <= y + 1; j++) {
                try {
                    //counts each cell
                    if(logicUnivers[i][j]) count++;
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        //reduces the cell count until you get the count of the surrounding cells of the alive cell
        if(logicUnivers[x][y]) count--;

        return count;
    }
    //Bunch of rules to tell which cell will live, die or will create a new cell.
    public boolean[][] checkNeighbours(boolean[][] tempLogicUnivers){
        for(int i = 0; i < btnSize; i++) {
            for(int j = 0; j < btnSize; j++) {
                int count= neighbours(i, j);
                if(logicUnivers[i][j]) {
                /*
                    if(count < 2) { // in this case the cell will die
                        tempLogicUnivers[i][j] = false;
                    }

                 */
                    if(count == 3 ||count == 2) { // in this case it will create a new cell
                        tempLogicUnivers[i][j] = true;
                    }
                /*    if(count > 3) { // die
                        tempLogicUnivers[i][j] = false;
                    }

                 */
                }else{
                    if(count==3) //will be kept alive
                        tempLogicUnivers[i][j] = true;
                }
            }
        }
        logicUnivers = tempLogicUnivers; //the temporary logic univers will be the current logic univers.
        //now when we get our new logic univers with the rules it will paint green if its alive!
        for(int i = 0; i < btnSize; i++) {
            for(int j = 0; j < btnSize; j++) {
                if(logicUnivers[i][j]) {
                    cells[i][j].setBackground(Color.GREEN);
                }else {
                    cells[i][j].setBackground(Color.BLACK);
                }
            }
        }
        return logicUnivers;
    }
    //function that resets the current 2D array of buttons
    public JButton[][] resetButtons(int i, int j) {
        return new JButton[i][j];
    }
    //creates the panel
    public void getPanel(){
        setPreferredSize(new Dimension(515, 600));
        setLayout(null);
        //pack();
        univers = new JPanel();
        univers.setBounds(0,0,500,500);
        univers.setLayout(new GridLayout(btnSize, btnSize));
    }
    //prints or shows the current board in the panel
    public void getBoard(){
        for(int x=0;x<btnSize ;x++) {
            for(int y=0;y<btnSize ;y++) {
                logicUnivers[x][y] = false;
                logicUnivers[x][y] = rnd.nextInt(100)<20;
                JButton btn = new JButton();
                if(logicUnivers[x][y]) {
                    btn.setBackground(Color.GREEN);
                }else {
                    btn.setBackground(Color.BLACK);
                }
                univers.add(btn);
                cells[x][y]=btn;
            }
        }
    }
    public void functionclear(Timer timer){
    	timer.stop();
        for(int i = 0; i < btnSize ; i++){
            for(int j = 0; j < btnSize ; j++){
                if(logicUnivers[i][j]){
                    cells[i][j].setBackground(Color.BLACK);
                }
                logicUnivers[i][j] = false;
            }
        }
    }
    public void speedupms(JTextField msnow, int ms){
    	this.ms=ms+50;
    	msnow.setText(this.ms + "");
    }
    public void rightnowms(JTextField msnow){
    	String contenido = msnow.getText();
    	msnow.setText(contenido);
    	this.ms = Integer.parseInt(contenido);
    }
    public void lowspeedms(JTextField msnow, int ms){
    	this.ms=ms-50;
    	if (this.ms <= 0) {
    		this.ms = 0;
    	}
    	msnow.setText(this.ms + "");

    }
}

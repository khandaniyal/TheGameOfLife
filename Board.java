import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    private int BOARD_SIZE = 25,
            ANIMATION_DELAY = 100;//milliseconds;
    private Univers[][] cells;
    private Univers cell;
    private JPanel universPanel;
    private JPanel panelButton;
    private JPanel contadorPanel;
    private JLabel contador;
    private int count;

    public Board(int BOARD_SIZE) {
        this.BOARD_SIZE = BOARD_SIZE;
        //initialize constants
        universPanel = new JPanel();
        panelButton = new JPanel();
        contadorPanel = new JPanel();
        cell = new Univers();
        cells = new Univers[BOARD_SIZE][BOARD_SIZE];
        //add a grid
        universPanel.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        //initialize all cells
        initializeAllCells(cells);
        //Animation begins!
        Timer timer = new Timer(ANIMATION_DELAY, e -> animate());
        //Buttons
        JButton start = new JButton("Start");
        JButton stop = new JButton("Stop");
        JButton clear = new JButton("Clear");
        JButton lessms = new JButton("-");
        JButton morems = new JButton("+");
        JTextField msnow = new JTextField(ANIMATION_DELAY + "");
        addAllButtons(start, stop, clear, lessms, msnow, morems);
        //Labels
        contador = new JLabel("Contador: ");
        addAllLabels(contador);
        //Starts the timer
        start.addActionListener(e ->  timer.start());
        //Stops the timer
        stop.addActionListener(e -> timer.stop());
        //Resets all cells
        clear.addActionListener(e -> resetCells(timer));
        add(contadorPanel, BorderLayout.NORTH);
        add(universPanel, BorderLayout.CENTER);
        add(panelButton, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        //speed up the timer
        morems.addActionListener(e-> speedUpMs(timer, msnow, ANIMATION_DELAY));
        //the timer now
        msnow.addActionListener(e-> currentMs(timer, msnow));
        //low speed the timer
        lessms.addActionListener(e-> speedDownMs(timer, msnow, ANIMATION_DELAY));
    }
    /*Function & Methods*/
    private void animate(){
        Univers[][] tempCell = new Univers[BOARD_SIZE][BOARD_SIZE];
        initializeAllCells(tempCell);
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                count = 0;
                count = cell.countNeighbours(i, j, tempCell);
                if(cells[i][j].isUniverse()){
                    if(count < 2){
                        tempCell[i][j].setUniverse(false);
                    }
                    if(count == 3 || count == 2) { //process next if only if previous one was false
                        tempCell[i][j].setUniverse(true);
                    }
                    if(count > 3){
                        tempCell[i][j].setUniverse(false);
                    }
                }else{
                    if(count == 3) {
                        tempCell[i][j].setUniverse(true);
                    }
                }
            }
        }
        this.cells = tempCell;
    }
    public void initializeAllCells(Univers[][] cells){
        for(int x = 0; x < BOARD_SIZE; x++) {
            for(int y= 0; y < BOARD_SIZE; y++) {
                Univers cell = new Univers();
                universPanel.add(cell);
                cells[x][y] = cell;
            }
        }
    }
    public void addAllButtons(JButton start, JButton stop, JButton clear, JButton lessms, JTextField msnow, JButton morems){
        panelButton.setLayout(new GridLayout(0,3));
        panelButton.add(start);
        panelButton.add(stop);
        panelButton.add(clear);
        panelButton.add(lessms);
        panelButton.add(msnow);
        panelButton.add(morems);
    }
    public void addAllLabels(JLabel contador){
        contadorPanel.setLayout(new GridLayout(0,3));
        contadorPanel.add(contador);
    }
    public void resetCells(Timer timer){
        timer.stop();
        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j = 0; j < BOARD_SIZE; j++){
                cells[i][j].setUniverse(false);
            }
        }
    }
    public void speedUpMs(Timer timer, JTextField currentMs, int ANIMATION_DELAY){
        this.ANIMATION_DELAY=ANIMATION_DELAY+50;
        currentMs.setText(this.ANIMATION_DELAY + "");
        timer.setDelay(this.ANIMATION_DELAY);
    }
    public void currentMs(Timer timer, JTextField currentMs){
        String contenido = currentMs.getText();
        currentMs.setText(contenido);
        this.ANIMATION_DELAY = Integer.parseInt(contenido);
        timer.setDelay(this.ANIMATION_DELAY);
    }
    public void speedDownMs(Timer timer, JTextField currentMs, int ANIMATION_DELAY){
        this.ANIMATION_DELAY = ANIMATION_DELAY - 50;
        if (this.ANIMATION_DELAY <= 0) {
            this.ANIMATION_DELAY = 0;
        }
        currentMs.setText(this.ANIMATION_DELAY + "");
        timer.setDelay(this.ANIMATION_DELAY);
    }
}
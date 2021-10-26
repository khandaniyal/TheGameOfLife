import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    private int BOARD_SIZE = 25,
                      ANIMATION_DELAY = 100;//milliseconds;
    private final Cells[][] cells;
    private final Cells cell;
    private JPanel universPanel;
    private JPanel panelButton;
    private int count = 0;

    public Board(int BOARD_SIZE) {
        this.BOARD_SIZE = BOARD_SIZE;
        //initialize constants
        universPanel = new JPanel();
        panelButton = new JPanel();
        cell = new Cells();
        cells = new Cells[BOARD_SIZE][BOARD_SIZE];
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
        addAllButtons(start, stop, clear);
        //Starts the timer
        start.addActionListener(e ->  timer.start());
        //Stops the timer
        stop.addActionListener(e -> timer.stop());
        //Resets all cells
        clear.addActionListener(e -> resetCells(timer));
        add(universPanel, BorderLayout.CENTER);
        add(panelButton, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    /*Function & Methods*/
    private void animate(){
        for(int i = 0; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                count = cell.countNeighbours(i, j, cells);
                if(cells[i][j].isUniverse()){
                    if(count < 2) {
                        cells[i][j].setUniverse(false);
                    }else if(count == 3 || count == 2) { //process next if only if previous one was false
                        cells[i][j].setUniverse(true);
                    }else if(count > 3) {
                        cells[i][j].setUniverse(false);
                    }
                }else if(count == 3) {
                    cells[i][j].setUniverse(true);
                }
            }
        }
    }
    public void initializeAllCells(Cells[][] cells){
        for(int x = 0; x < BOARD_SIZE; x++) {
            for(int y= 0; y < BOARD_SIZE; y++) {
                Cells cell = new Cells();
                universPanel.add(cell);
                cells[x][y] = cell;
            }
        }
    }
    public void addAllButtons(JButton start, JButton stop, JButton clear){
        panelButton.setLayout(new GridLayout(0,3));
        panelButton.add(start);
        panelButton.add(stop);
        panelButton.add(clear);
    }
    public void resetCells(Timer timer){
        timer.stop();
        for(int i = 0; i < BOARD_SIZE; i++){
            for(int j = 0; j < BOARD_SIZE; j++){
                cells[i][j].setUniverse(false);
            }
        }
    }
}

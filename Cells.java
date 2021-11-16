import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Cells extends JLabel{
    private static Color BOARD = Color.BLACK,
            UNIVERSE = Color.GREEN,
            BORDER = Color.GRAY;
    private static Dimension CELL_SIZE;
    private boolean universe = false;
    private int neighbours;

    public Cells() { //Constructor calling the following methods to create the universe
        super();
        CELL_SIZE  = new Dimension(30, 30);
        createUnivers();
        mouseListener();
    }
    /*Getters & Setters*/
    public int getNeighbours(){ return neighbours; }
    public void setNeighbours(int neighbours){ this.neighbours = neighbours; }
    public Dimension getPreferredSize() { return CELL_SIZE; } //Current size of the cells
    public boolean isUniverse() { return universe; }
    public void setUniverse(boolean isUniverse) { //checks the state of the univers and paints the univers or the board
        if (universe == isUniverse) return;
        universe = isUniverse;
        setBackground(isUniverse ? UNIVERSE : BOARD);
        repaint();
    }
    /* Extra methods */
    public void mouseClickedHandler(MouseEvent e) { //Method for our mouse input
        if (SwingUtilities.isLeftMouseButton(e)) //Checks if the left mouse button is clicked, in this case we want to paint
            setUniverse(true);
        else
            if (SwingUtilities.isRightMouseButton(e)) //Otherwise we want to erase the painted cells
                setUniverse(false);
    }
    public void createUnivers() { //Create the universe with the following visual elements
        setUniverse(universe);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(BORDER, 2));
        setBackground(BOARD);
    }
    public void mouseListener() { //Method for the mouse input listener
        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { mouseClickedHandler(e); } //This event only listens for each click, in this case we want to paint each cell individually
            @Override
            public void mouseEntered(MouseEvent e) { mouseClickedHandler(e); } //This event listens when the mouse is pressed, in this case we want to draw while the mouse is being pressed
        });
    }

    public int countNeighbours(int x, int y, Cells[][] cells){
        neighbours = 0;
        for(int i = x - 1; i <= x + 1; i++) {
            for(int j = y - 1; j <= y + 1; j++) {
                try {
                    if(cells[i][j].isUniverse()) neighbours++; //counts each cell
                }catch(Exception e){ }
            }
        }
        if(cells[x][y].isUniverse()) neighbours--; //reduces the cell count until you get the count of the surrounding cells of the alive cell
        return neighbours;
    }
}
public class GameOfLifeTerminal {
    private int WIDTH;
    private int HEIGHT;
    private int[][] board;
    private int aliveNeighbours = 0;


    public GameOfLifeTerminal(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.board = new int[width][height];
    }

    /*Getters & Setters*/
    public void setAlive(int x, int y) {
        this.board[x][y] = 1;
    }

    public void setDead(int x, int y) {
        this.board[x][y] = 0;
    } // currently not being used

    /*Methods and functions*/
    public void printBoard() { //prints the board
        for (int y = 0; y < HEIGHT; y++) {
            String line = "";
            for (int x = 0; x < WIDTH; x++) {
                if (this.board[x][y] == 0) {
                    line += "·";
                } else {
                    line += "O";
                }
            }
            System.out.println(line);
        }
        System.out.println();
    }

    public int countAliveNeighbours(int x, int y) {    //count the number of alive neighbours
        int count = 0;
        /*
        for(int i = x-1; i < x+1; i++) {
            for (int j = y - 1; i < y + 1; j++) {
                if (getState(i, j) == 1) count++;
            }
        }
         if(getState(x, y) == 1) count--;
        */

        //checks each position one by one and calls the getState() method to be inside the bounds
        count += getState(x - 1, y - 1);
        count += getState(x, y - 1);
        count += getState(x + 1, y - 1);

        count += getState(x - 1, y);
        count += getState(x + 1, y);

        count += getState(x - 1, y + 1);
        count += getState(x, y + 1);
        count += getState(x + 1, y + 1);
        //System.out.println(count);
        return count;
    }

    public int getState(int x, int y) { //get state neighbours in case is out of bounds
        if (x < 0 || x >= WIDTH) return 0;
        if (y < 0 || y >= HEIGHT) return 0;
        return this.board[x][y];
    }

    public void animateChanges() { //applies the rules and then prints the board with current state of the cells
        //temporary board
        int[][] newBoard = new int[WIDTH][HEIGHT];
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                aliveNeighbours = countAliveNeighbours(x, y);
                //rules
                if (getState(x, y) == 1) { //if true
                    if (aliveNeighbours < 2) { // le ded
                        newBoard[x][y] = 0;
                    } else if (aliveNeighbours == 2 || aliveNeighbours == 3) { //alive
                        newBoard[x][y] = 1;
                    } else if (aliveNeighbours > 3) { // le ded
                        newBoard[x][y] = 0;
                    }
                } else {
                    if (aliveNeighbours == 3) { //create new cells
                        newBoard[x][y] = 1;
                    }
                }
            }
        }
        this.board = newBoard;
        //System.out.println("Alive cells " + aliveNeighbours);
        printBoard();
    }
    //main method
    public static void main(String[] args) {
        GameOfLifeTerminal simulation = new GameOfLifeTerminal(8, 5);

        simulation.setAlive(2, 2);
        simulation.setAlive(3, 2);
        simulation.setAlive(4, 2);

        simulation.animateChanges();
        simulation.animateChanges();
        simulation.animateChanges();
    }
}

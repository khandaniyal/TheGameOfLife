public class tablero {
    //Attributes
    private int x;
    private int y;
    private cell[][] arrayBackend;
    //Builders
    tablero (int x,int y) throws Exception{
        setX(x);
        setY(y);
        arrayBackend = new cell[x][y];//Creamos las celdas
        insertCells();
    }
    //Getters and Setters
    private void setX(int x) throws Exception {
        try {
            this.x = x;
        } catch (Exception e) {
            System.out.println("Exception thrown  :" + e);
        }
    }
    private void setY(int y) throws Exception {
        try {
            this.y = y;
        } catch (Exception e) {
            System.out.println("Exception thrown  :" + e);
        }
        
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    //Methods
    //Insertamos todas las celulas en el tablero
    public void insertCells () {
        for (int i = 0; i <= arrayBackend.length-1;i++) {//array de array celdas
            System.out.println(arrayBackend[i]);
            for (int o = 0; o <= arrayBackend[i].length-1;o++) {//array de celdas
                //if (cellsY==null){//--Problema
                    arrayBackend[i][o] = new cell();
                    System.out.println(arrayBackend[i][o].getNeighbors());
                //}
            }
        }
    }

    //Muestra la tabla por consola
    public void showBoard(){
        for (cell[] cellsX : arrayBackend) {//Recorre el array x
            for (cell cellsY : cellsX) {    //Recorre el array y de x 
                System.out.print(cellsY.getNeighbors());//Devuelve el número de vecinos
            }
            System.out.println();//Siguiente línia
        }
    }
    public void change(int x, int y, boolean state){
        arrayBackend[x][y].setState(state);
    }
    
    //__________________________
    public static void main(String[] args) throws Exception {
        tablero tab1 = new tablero(3, 3);
        tab1.change(2, 2, true);
        tab1.showBoard();
    }
}


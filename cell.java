import javax.swing.JButton;

public class cell  {
    //Attributes
    private boolean state = false;
    private int neighbors = 0;
    //Builders
    //Getters and Setters
    public void setNeighbors(int neighbors) throws Exception {
        try {
            this.neighbors = neighbors;
        } catch (Exception e) {
            System.out.println(e+" Invalid number: "+ neighbors);
            System.out.println("Max=8 Min=0");
        }
    }
    //Método de cambio al INICIO
    public void setState(boolean state) {
       this.state = state;
    }
    //Método que actualiza su estado en el transcurso partida
    public void setState(boolean state, int neighbors){
        if(neighbors == 2 || neighbors == 3) {
            state = true;
        }else{
            state = false;
        }
    }
    public boolean getState(){
        return this.state;
    }
    public int getNeighbors() {
        return neighbors;
    }
    //En construcción
    
    
    
}


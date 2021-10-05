import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class practice  extends JFrame{

	int x = 50;
	int y = 50;
	boolean[][] compruebaUnivers;
	JButton[][] btnArr;
	
	public practice() {
		//se crea el panel con los botones
		Random rand =  new Random();
		compruebaUnivers = new boolean[x][y];
		btnArr = new JButton[x][y];
		setSize(500, 500);
		setLayout(new GridLayout(x, y));
		//recorremos el mapa y pintamos los botones
		for(int i = 0; i < x; i++) {
			for(int j = 0;j < y ; j++) {
				compruebaUnivers[i][j] = rand.nextInt(60)<30;
				JButton temp = new JButton();
				if(compruebaUnivers[i][j]) {
					temp.setBackground(Color.WHITE);
				}else {
					temp.setBackground(Color.GREEN);
				}
				btnArr[i][j] = temp;
				add(temp);
			}
			
		}
		//el panel se muestra
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// el timer hace que funcione
		Timer timer = new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean[][] temp = new boolean[x][y]; // array temporal
				//recorremos el universo otra vez
				for(int i = 0; i < x; i++) {
					for(int j = 0; j < y; j++) {
						int count = countNeighbours(i, j); //metodo que comprueba las celdas que estan vivas o muertas
						if(compruebaUnivers[i][j]) { // reglas
							if(count < 2) {
								temp[i][j] = false;
							}
							if(count == 3 || count == 2) {
								temp[i][j] = true;
							}
							if(count > 3) {
								temp[i][j] = false;
							}
						}else {
							if(count == 3) {
								temp[i][j] = true;
							}
						}
					}
				}
				compruebaUnivers = temp; // el array logico temporal pasa a ser el array principal
				//recorremos el universo otra vez para pintar las celdas que estan vivas o muertas
				for(int i = 0; i < x; i++) {
					for(int j = 0; j < y; j++) {
						if(compruebaUnivers[i][j]) {
							btnArr[i][j].setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
						}else {
							btnArr[i][j].setBackground(Color.WHITE);
						}
					}
				}
			}

		});
		timer.start();		
	
	}
	//metodo para contar las celdas vecinas
	private int countNeighbours(int x, int y) {
		int count = 0;
		for(int i = x-1; i <= x+1; i++) {
			for(int j = y-1; j <= y+1; j++) {
				try {
					if(compruebaUnivers[i][j]) count++;
				}catch(Exception e) {
					System.out.println(e);
				}
			}
		}
		if(compruebaUnivers[x][y]) count--;
		return count;
	}
		
	
	public static void main(String[] args) {
		new practice();
		
	}
}

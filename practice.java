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
		Random rand =  new Random();
		compruebaUnivers = new boolean[x][y];
		btnArr = new JButton[x][y];
		setSize(500, 500);
		setLayout(new GridLayout(x, y));
		
		for(int i = 0; i < x; i++) {
			for(int j = 0;j < y; j++) {
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
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	public static void main(String[] args) {
		new practice();
	}
}

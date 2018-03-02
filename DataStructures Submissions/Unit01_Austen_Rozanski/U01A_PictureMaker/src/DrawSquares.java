import javax.swing.*;
import java.awt.*;

public class DrawSquares extends JPanel
{
	private static final long serialVersionUID = 8667913702921838903L;
	
	private Integer[] coordinates;
	private final int SQUARESIZE = 10;
	
	//Set instance variable coordinates
	public DrawSquares(Integer[] coordinates) {
		this.coordinates = coordinates;
	}
	
	public void drawing() {
		repaint();
	}
	
	//Paint squares to screen
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.setColor(Color.black);
		
		//Draw squares to screen based on coordinates instance variable
		for (int i = 0; i < coordinates.length-1; i=i+2) {
			g.fillRect(coordinates[i+1]*SQUARESIZE, coordinates[i]*SQUARESIZE, SQUARESIZE, SQUARESIZE);
		}
	}
}

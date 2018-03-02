/*
 * Author: Austen Rozanski
 * Class: Data Structures
 * Title: PictureMaker
 * 
 * Date Started: January 18, 2015
 * Date Last Revised: January 18, 2015
 * 
 * 
 * Description of Problem: Write a program that draws a picture based on pixel coordinates. The size of the "pixels"
 * should be 10 pixels by 10 pixels.
 * 
 * Outline of the Program: Reads input from the file "coordinates.txt" and then draws a picture to a JFrame using those
 * coordinates. The program sends the coordinates to the DrawSquares class to perform this task.
 */

import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class U01A_Austen_Rozanski
{	
	public static void main(String[] args) throws FileNotFoundException
	{
		//Create the JFrame
		JFrame frame = new JFrame("Picture Maker");
		
		
		//Get coordinates for squares from the file coordinates.txt
		ArrayList<Integer> coordinatesList = new ArrayList<Integer>();
		
		Scanner scanner = new Scanner(new File("coordinates.txt"));
		while(scanner.hasNextInt()){
			coordinatesList.add(scanner.nextInt());
		}
		scanner.close();
		
		//Convert the ArrayList to and array to be used in the DrawSquares class
		Integer[] coordinates = coordinatesList.toArray(new Integer[coordinatesList.size()]);
		
		
		//Draw squares using the DrawSquares class and the coordinates found
		DrawSquares square = new DrawSquares(coordinates);
		frame.add(square);
		square.drawing();
		
		
		//Display the JFrame
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

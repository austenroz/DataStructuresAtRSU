/*
 * Author: Austen Rozanski
 * Class: Data Structures
 * Title: SquareRoot
 * 
 * Date Started: January 18, 2015
 * Date Last Revised: January 19, 2015
 * 
 * 
 * Description of Problem: Write a program that finds the square root of a number using 
 * the formula NG=0.5*(LG+N/LG) where NG stands for the next guess and LG stands for last guess.
 * 
 * Outline of the Program: Program finds the square root of the variable x and outputs it to the console.
 */

public class U01B_Austen_Rozanski {

	public static void main(String[] args) {
		
		//Change this variable to find the square root of a different number
		double x = 9.0;
		
		//Output result
		System.out.println("The square root of " + x + " is " + mysqrt(x));
	}
	
	public static double mysqrt(double N)
	{
		return mysqrt(N, 0.005);
	}
	
	public static double mysqrt(double N, double accuracy)
	{
		double ACCURACY = accuracy;

		double lastGuess = 1;
		double newGuess = 0.5 * (lastGuess+N/lastGuess);
		double delta = Math.abs(lastGuess - newGuess);
		
		//Loop until square root guess is close enough to accuracy requested
		while (delta > ACCURACY)
		{
			lastGuess = newGuess;
			newGuess = 0.5 * (lastGuess+N/lastGuess);
			delta = Math.abs(lastGuess - newGuess);
		}
		
		//Round decimal up to 5 decimal numbers
		newGuess = (double)Math.round(newGuess * 100000d) / 100000d;
		
		//Return result
		return newGuess;
	}

}

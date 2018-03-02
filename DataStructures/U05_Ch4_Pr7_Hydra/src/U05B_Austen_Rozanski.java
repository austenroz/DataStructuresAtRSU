/**
 * 
 * Author: Austen Rozanski
 * Class: Data Structures
 * Title: Hydra
 * 
 * Date Started: February 13, 2015
 * Date Last Revised: February 14, 2015
 * 
 * 
 * Description of Problem: Write a program that represents a hyrda using strings
 * 
 * Speed Test:
 * 5 letters: 0.000102 seconds
 * 10 letters: 0.000745 seconds
 * 20 letters: 0.133951 seconds
 * 21 letters: 0.351589 seconds   1 - 1
 * 22 letters: 1.406162 seconds   2 - 3.99
 * 23 letters: 4.931561 seconds   3 - 14.02
 * 24 letters: 10.830859 seconds  4 - 30.8
 * 25 letters: 24.945822 seconds  5 - 70
 * 
 * It appears to Big Oh notation of this algorithm is quadratic.
 */

import java.util.Scanner;

public class U05B_Austen_Rozanski {

	private static Bag bag = new Bag();
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Word: ");
		String inputWord = input.nextLine();
		bag.add(inputWord);
		
		long startTime = System.nanoTime();
		SlayHydra();
		double elapsedTime=(System.nanoTime()-startTime)/1E+09;
		System.out.printf("Elapsed Time: %f\n", elapsedTime);
		
		
		input.close();
	}

	
	
	public static void SlayHydra()
	{
		while (!bag.isEmpty())
		{
			Bag newBag = new Bag();
			while (!bag.isEmpty())
			{
				String currentWord = (String) bag.remove();
				if (currentWord.length() > 1)
				{
					String newWord = currentWord.substring(1);
					//System.out.println(newWord + " " + newWord);
					newBag.add(new String(newWord));
					newBag.add(new String(newWord));
				}
			}
			while (!newBag.isEmpty())
			{
				bag.add(newBag.remove());
			}
		}
	}
}

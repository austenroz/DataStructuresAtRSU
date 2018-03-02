/**
 * 
 * Author: Austen Rozanski
 * Class: Data Structures
 * Title: Authorship
 * 
 * Date Started: February 20, 2015
 * Date Last Revised: February 21, 2015
 * 
 * 
 * Description of Problem: Write a program that finds pairs of letters in a given text.
 * 
 * 
 */

import java.io.FileReader;
import java.io.IOException;


public class U06_Austen_Rozanski {
	
	//Letters used for creating all possible pairs of letters
	private static final String[] LETTERS = new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
	
	public static void main(String[] args) throws IOException 
	{
		//Name of text file to be read from 
		String textFileName = "Shakespeare.txt";
		
		//Double for loop to create every pair of letters possible
		for (int first = 0; first < LETTERS.length; first++)
		{
			for (int second = 0; second < LETTERS.length; second++)
			{
				findPair(textFileName, new String(LETTERS[first]  + "" + LETTERS[second]));
			}
		}
	}
	
	public static void findPair(String textFileName, String pair) throws IOException
	{
		FileReader inputStream = null;
		int pairsFound = 0;
		
		try {
			inputStream = new FileReader(textFileName);
			int c;
			String currentTestPair = "";
			
			//Read in each pair at a time from the text file
			while ((c = inputStream.read()) != -1) 
			{
				if (currentTestPair.length() < 2)
				{
					currentTestPair = currentTestPair + Character.toString((char)c);
				}
				else
				{
					currentTestPair = currentTestPair.substring(1) + Character.toString((char)c);
				}
				
				currentTestPair = currentTestPair.toLowerCase();
				
				//Compare the pairs
				if (currentTestPair.equals(pair))
					pairsFound++;
			}
		}
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
        
			//Output results
			System.out.println("Pairs of " + pair + " found: " + pairsFound);
        }
	}
}

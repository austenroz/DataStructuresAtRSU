/**
 *  @author Austen Rozanski
 * 
 *  Description: Guessing game stores the random numbers which the player will be guessing.
 *  It also includes methods for processing player guesses.
 * */

import java.util.Random;

public class GuessingGame {
	
	//Variables storing the total number of numbers generated and their range.
	private int totalNumbers=4;
	private int maxRange=10;
	
	//Bag used to store random numbers.
	private BagInterface<Integer> bag = new Bag<Integer>();
	
	public GuessingGame()
	{
		//Default values
		this(4, 10);
	}

	/** Assigns totalNumbers and maxRange to this objects instance variables of the same name.
	 * Then random numbers are generated based on those variables and stores in the bag object.
     * @param totalNumbers  Total number of numbers randomly generated
     * @param maxRange The maximum range for the numbers randomly generated (Inclusive) */
	public GuessingGame(int totalNumbers, int maxRange)
	{
		this.totalNumbers = totalNumbers;
		this.maxRange = maxRange;
		
		for (int i = 0; i < totalNumbers; i++)
		{
			bag.add(getRandomNumber(1,maxRange));
		}
	}
	
	/** Generates a new set of random numbers*/
	public void GetNewNumbers()
	{
		for (int i = 0; i < totalNumbers; i++)
		{
			bag.add(getRandomNumber(1,maxRange));
		}
	}
	
	/** Compares the players guesses to the numbers randomly generated. Outputs result.
    @param numbers  The players guesses
    @return  true if players guesses were correct, false if not */
	public boolean GuessNumbers(int[] numbers)
	{
		if (numbers.length > totalNumbers)
		{
			System.out.println("Too many guesses.");
			return false;
		}
		else if (numbers.length < totalNumbers)
		{
			System.out.println("Not enough guesses.");
			return false;
		}
		else
		{
			boolean isCorrect = true;
			int totalCorrect = 0;
			int[] tempNumberStorage = new int[totalNumbers];
			
			//Check to see what numbers were in the bag
			for (int i = 0; i < totalNumbers; i++)
			{
				if (bag.contains(numbers[i]))
				{
					bag.remove(numbers[i]);
					tempNumberStorage[totalCorrect] = numbers[i];
					totalCorrect++;
				}
				else
				{
					isCorrect = false;
				}
			}
			
			//Add numbers back into the bag
			for (int i = 0; i < totalCorrect; i++)
			{
				bag.add(tempNumberStorage[i]);
			}
			
			//Output results
			if (!isCorrect)
			{
				System.out.println(totalCorrect + " of your guesses were correct. Guess again.");
			}
			else
			{
				System.out.println("You are correct!");
			}
			return isCorrect;
		}
		
	}
	
	/** Receives a minimum and maximum value and return a random number between them
    @param min  The minimum value of the random number (Inclusive)
    @param max  The maximum value of the random number (Inclusive)
    @return  Random integer between the values of the max and min variables */
	public int getRandomNumber(int min, int max)
	{
		Random rng = new Random();
		return min + rng.nextInt(max - min + 1);
	}

}

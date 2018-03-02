import java.util.*;

public class Shoe 
{
	private List<PlayingCard> cards = new ArrayList<PlayingCard>();
	
	
	public Shoe(PlayingCard[] arrayCards)
	{
		cards = new ArrayList<PlayingCard>(Arrays.asList(arrayCards));
	}
	
	/** @return  Returns the number of cards in the shoe */
	public int getNumberOfCards()
	{
		return cards.size();
	}
	
	/** Shuffles the cards in the shoe*/
	public void Shuffle()
	{
		List<PlayingCard> sourceList = new ArrayList<PlayingCard>();
		List<PlayingCard> shuffledList = new ArrayList<PlayingCard>();
		
		//Transfer all cards into source list to be shuffled
		while (cards.size() > 0)
		{
			sourceList.add(cards.get(0));
			cards.remove(0);
		}
		
		//Transfer all cards into shuffled list randomly
		while (sourceList.size() > 0)
		{
			int randomNumber = getRandomNumber(0, sourceList.size()-1);
			shuffledList.add(sourceList.get(randomNumber));
			sourceList.remove(randomNumber);
		}
		
		//Transfer all cards into shoe
		while (shuffledList.size() > 0)
		{
			cards.add(shuffledList.get(0));
			shuffledList.remove(0);
		}
		
	}
	
	/** Outputs the order of the cards in the shoe */
	public void OutputOrder()
	{
		for (int i = 0; i < cards.size(); i++)
		{
			System.out.print(cards.get(i).getCard()+ "   ");
		}
		System.out.print("\n");
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

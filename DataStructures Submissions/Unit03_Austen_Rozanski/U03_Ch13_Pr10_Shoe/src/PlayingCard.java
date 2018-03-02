/**
 * 
 * @author Austen Rozanski
 * 
 * Description: Simple playing card class. Has variables to store the cards number and suit.
 *
 */

public class PlayingCard 
{
	private String cardSuit;
	private String cardNumber;
	
	
	public PlayingCard(String cardNumber, String cardSuit)
	{
		this.cardNumber = cardNumber;
		this.cardSuit = cardSuit;
	}
	
	//Getters and Setters
	public String getCardSuit() {
		return cardSuit;
	}
	public void setCardSuit(String cardSuit) {
		this.cardSuit = cardSuit;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getCard()
	{
		return cardNumber + " of " + cardSuit;
	}
}

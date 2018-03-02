/*
 * Author: Austen Rozanski
 * Class: Data Structures
 * Title: Shoe
 * 
 * Date Started: January 31, 2015
 * Date Last Revised: January 31, 2015
 * 
 * 
 * Description of Problem: Write a program that shuffles the cards in a shoe
 * 
 * Outline of the Program: Creates an array of cards in order and puts them into the shoe. The shoe class then shuffles the cards. The order is output
 * before and after shuffling.
 */
public class U03B_Austen_Rozanski 
{
	public static void main(String[] args) {
		PlayingCard card1 = new PlayingCard("3", "Spades");
		PlayingCard card2 = new PlayingCard("5", "Diamonds");
		PlayingCard card3 = new PlayingCard("9", "Hearts");
		PlayingCard card4 = new PlayingCard("10", "Spades");
		PlayingCard card5 = new PlayingCard("Jack", "Clubs");
		PlayingCard card6 = new PlayingCard("Queen", "Clubs");
		PlayingCard card7 = new PlayingCard("Ace", "Hearts");
		PlayingCard[] cards = {card1, card2, card3, card4, card5, card6, card7};
		
		Shoe shoe = new Shoe(cards);
		System.out.println("Order of cards before shuffling:");
		shoe.OutputOrder();
		shoe.Shuffle();
		System.out.println("\nOrder of cards after shuffling:");
		shoe.OutputOrder();
	}
}

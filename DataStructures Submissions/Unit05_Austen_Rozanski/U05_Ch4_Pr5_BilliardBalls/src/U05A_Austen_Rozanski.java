/**
 * 
 * Author: Austen Rozanski
 * Class: Data Structures
 * Title: Billiards
 * 
 * Date Started: February 13, 2015
 * Date Last Revised: February 14, 2015
 * 
 * 
 * Description of Problem: Write a program that creates balls based on the number of the initial ball. 
 *
 * Speed Test Results:
 * Initial ball number of 5: 0.000016 seconds
 * Initial ball number of 10: 0.000019 seconds
 * Initial ball number of 100000: 0.008155 seconds      1 -   1
 * Initial ball number of 200000: 0.012017 seconds      2 -   1.47
 * Initial ball number of 400000: 0.018211 seconds      4 -   2.23
 * Initial ball number of 1000000: 0.278216 seconds     10 -  34.11
 * Initial ball number of 2000000: 0.463602 seconds     20 -  56.8
 * Initial ball number of 10000000: 12.640435 seconds   100 - 1550.022
 * Initial ball number of 20000000: 22.246460 seconds   200 - 2727.95
 * 
 * It appears to Big Oh notation of this algorithm is linear because the the time nearly doubles every time the amount of information doubles.
 */ 


public class U05A_Austen_Rozanski {
	
	private static Bag bag = new Bag();
	
	public static void main(String[] args) 
	{
		int ballNum = 20000000;
		Ball ball = new Ball(ballNum);
		bag.add(ball);
		
		long startTime = System.nanoTime();
		ChangeBalls();
		double elapsedTime=(System.nanoTime()-startTime)/1E+09;
		System.out.printf("Elapsed Time: %f\n", elapsedTime);
	}
	
	public static void ChangeBalls()
	{
		Bag newBag = new Bag();
		while (!bag.isEmpty())
		{
			Ball ball = (Ball) bag.remove();
			int ballNum = ball.getNumber();
			int newBallNum = (int) (ballNum / 2);
			for (int i = 0; i < ballNum; i++)
			{
				Ball newBall = new Ball(newBallNum);
				newBag.add(newBall);
			}
		}
		//System.out.println("Bag Now Contains:");
		while (!newBag.isEmpty())
		{
			//Ball b = (Ball) newBag.remove();
			//System.out.print(b.getNumber() + " Ball  ");
			bag.add(newBag.remove());
		}
		//System.out.println();
	}
}

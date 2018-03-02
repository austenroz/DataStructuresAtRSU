import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Random;


public class SpeedTest
{
    private static Formatter output;
    
    public static void main(String args[])
    {
        int nums;
        int[] inputArr;
        MyMergeSort mms = new MyMergeSort();
        
        //Small (100) number sort
        nums = 100;
        inputArr = new int[nums];
        inputArr = GetRandomArray(nums);
        long startTime = System.nanoTime();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
        double elapsedTime=(System.nanoTime()-startTime)/1E+09;
        System.out.printf("\n%-40s\t Elapsed Time: %f\n", "Console output with " + nums +" numbers", elapsedTime);
        
        //Medium (1000) number sort
        nums = 1000;
        inputArr = new int[nums];
        inputArr = GetRandomArray(nums);
        startTime = System.nanoTime();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
        elapsedTime=(System.nanoTime()-startTime)/1E+09;
        System.out.printf("\n%-40s\t Elapsed Time: %f\n", "Console output with " + nums + " numbers", elapsedTime);
        
        //Large (10000) number sort
        nums = 10000;
        inputArr = new int[nums];
        inputArr = GetRandomArray(nums);
        startTime = System.nanoTime();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
        elapsedTime=(System.nanoTime()-startTime)/1E+09;
        System.out.printf("\n%-40s\t Elapsed Time: %f\n", "Console output with " + nums + " numbers", elapsedTime);
        
        //Large (1000000) number sort
        nums = 1000000;
        inputArr = new int[nums];
        inputArr = GetRandomArray(nums);
        startTime = System.nanoTime();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
        elapsedTime=(System.nanoTime()-startTime)/1E+09;
        System.out.printf("\n%-40s\t Elapsed Time: %f\n", "Console output with " + nums + " numbers", elapsedTime);


        
	     //Small (100) number sort
	     nums = 100;
	     inputArr = new int[nums];
	     inputArr = GetRandomArray(nums);
	     startTime = System.nanoTime();
	     mms.sort(inputArr);
	     CreateFile("small.txt", inputArr);
	     elapsedTime=(System.nanoTime()-startTime)/1E+09;
	     System.out.printf("\n%-40s\t Elapsed Time: %f\n", "Text file with " + nums +" numbers", elapsedTime);
	     
	     //Medium (1000) number sort
	     nums = 1000;
	     inputArr = new int[nums];
	     inputArr = GetRandomArray(nums);
	     startTime = System.nanoTime();
	     mms.sort(inputArr);
	     CreateFile("medium.txt", inputArr);
	     elapsedTime=(System.nanoTime()-startTime)/1E+09;
	     System.out.printf("\n%-40s\t Elapsed Time: %f\n", "Text file with " + nums +" numbers", elapsedTime);
	     
	     //Large (10000) number sort
	     nums = 10000;
	     inputArr = new int[nums];
	     inputArr = GetRandomArray(nums);
	     startTime = System.nanoTime();
	     mms.sort(inputArr);
	     CreateFile("large.txt", inputArr);
	     elapsedTime=(System.nanoTime()-startTime)/1E+09;
	     System.out.printf("\n%-40s\t Elapsed Time: %f\n", "Text file with " + nums +" numbers", elapsedTime);
	     
	     //Larger (1000000) number sort
	     nums = 1000000;
	     inputArr = new int[nums];
	     inputArr = GetRandomArray(nums);
	     startTime = System.nanoTime();
	     mms.sort(inputArr);
	     CreateFile("larger.txt", inputArr);
	     elapsedTime=(System.nanoTime()-startTime)/1E+09;
	     System.out.printf("\n%-40s\t Elapsed Time: %f\n", "Text file with " + nums +" numbers", elapsedTime);
    }
    
    public static int[] GetRandomArray(int numOfNumbers)
    {
        int[] returnArray = new int[numOfNumbers];
        Random rng = new Random();
        for (int i = 0; i < numOfNumbers; i++)
        {
            returnArray[i] = rng.nextInt((100 - 0) + 1);
        }
        return returnArray;
    }
    
    public static void CreateFile(String FILENAME, int[] numbers)
    {
        //Open/Create the file
        try
        {
            output = new Formatter(FILENAME);
        }
        catch (SecurityException securityException)
        {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1);
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
        
        //Add records to file
        try
        {
            for (int i = 0; i < numbers.length; i++)
            {
                output.format(Integer.toString(numbers[i]));
            }
        }
        catch (FormatterClosedException formatterClosedException)
        {
            System.err.println("Error writing to file. Terminating.");
        }
        catch (NoSuchElementException elementException)
        {
            System.err.println("Invalid input. Terminating.");
        }
        
        //Close file
        if (output!= null)
            output.close();
    }
}
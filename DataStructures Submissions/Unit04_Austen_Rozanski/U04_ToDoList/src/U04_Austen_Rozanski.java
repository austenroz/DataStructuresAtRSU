/*
 * Author: Austen Rozanski
 * Class: Data Structures
 * Title: To Do List
 * 
 * Date Started: February 6, 2016
 * Date Last Revised: January 7, 2016
 * 
 * 
 * Description of Problem: Write a program that uses a GUI to store a to do list.
 * 
 * Outline of the Program: Creates a to do list for the user to input data into. Entries can be completed and will then be removed from the list.
 * The user can also specify a priority number for each task to determine where on the list it will appear.
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class U04_Austen_Rozanski
{
    static JFrame frame;
    
    //Specify the number of tasks visible at one
    //NOTE: DO NOT CHANGE THIS NUMBER YET! A solution needs to be found to be able to have an unlimited number of buttons so they can
    //be assigned in a loop. Also window needs to be resized vertically to show all tasks or scroll bar needs to be added.
    final static int MAXTASKSVISIBLE = 10;
    
    //JLabel array that displays all tasks
    static JLabel[] centerLabels = new JLabel[MAXTASKSVISIBLE];
    
    //Output information to user through this JLabel
    static JLabel outputLabel = new JLabel();
    
    //User input comes through these two JTextAreas
    static JTextArea newTaskInput = new JTextArea();
    static JTextArea newPriorityLevelInput = new JTextArea();
    
    //Create a new list object to store tasks
    static CustomLinkedList linkedList = new CustomLinkedList();
    
    //Array of buttons for completing tasks
    static JButton[] finTaskButtons = new JButton[MAXTASKSVISIBLE];
    
    //Assign ID numbers to each button for completing tasks
    static int[] finTaskIdNumbers = new int[MAXTASKSVISIBLE];
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run()
            {
                displayJFrame();
            }
        });
    }
    
    static void displayJFrame()
    {
        frame = new JFrame("To Do List");
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////
        //TOP
        
        //Create panel for top portion of GUI and assign it to a grid layout
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 3, 0, 5));
        
        //JLabel displaying the word Tasks
		JLabel taskTitleBar = new JLabel("Tasks", JLabel.CENTER);
		taskTitleBar.setFont(new Font("Courier", Font.BOLD, 24));
		topPanel.add(taskTitleBar);
		
		//Load Data Button
        JButton loadDataButton = new JButton("Load List");
        loadDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	DeserializeList();
            }
        });
        topPanel.add(loadDataButton);
        
        //Save Data Button
        JButton saveDataButton = new JButton("Save List");
        saveDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	SerializeList();
            	outputLabel.setText("List Saved");
            }
        });
        topPanel.add(saveDataButton);
		
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        //Center
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(MAXTASKSVISIBLE+1, 2, 0, 5));
        
        //FIN TASK BUTTONS
        //Used to complete tasks based on the tasks ID number.
        //I would have used a loop for this but an error occurred where I wasn't able to use it.
        finTaskButtons[0] = new JButton("Task Completed");
        finTaskButtons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	linkedList.remove(finTaskIdNumbers[0]);
            	UpdateTaskList();
            	outputLabel.setText("Task completed!");
            }
        });
        finTaskButtons[1] = new JButton("Task Completed");
        finTaskButtons[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	linkedList.remove(finTaskIdNumbers[1]);
            	UpdateTaskList();
            	outputLabel.setText("Task completed!");
            }
        });
        finTaskButtons[2] = new JButton("Task Completed");
        finTaskButtons[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	linkedList.remove(finTaskIdNumbers[2]);
            	UpdateTaskList();
            	outputLabel.setText("Task completed!");
            }
        });
        finTaskButtons[3] = new JButton("Task Completed");
        finTaskButtons[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	linkedList.remove(finTaskIdNumbers[3]);
            	UpdateTaskList();
            	outputLabel.setText("Task completed!");
            }
        });
        finTaskButtons[4] = new JButton("Task Completed");
        finTaskButtons[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	linkedList.remove(finTaskIdNumbers[4]);
            	UpdateTaskList();
            	outputLabel.setText("Task completed!");
            }
        });
        finTaskButtons[5] = new JButton("Task Completed");
        finTaskButtons[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	linkedList.remove(finTaskIdNumbers[5]);
            	UpdateTaskList();
            	outputLabel.setText("Task completed!");
            }
        });
        finTaskButtons[6] = new JButton("Task Completed");
        finTaskButtons[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	linkedList.remove(finTaskIdNumbers[6]);
            	UpdateTaskList();
            	outputLabel.setText("Task completed!");
            }
        });
        finTaskButtons[7] = new JButton("Task Completed");
        finTaskButtons[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	linkedList.remove(finTaskIdNumbers[7]);
            	UpdateTaskList();
            	outputLabel.setText("Task completed!");
            }
        });
        finTaskButtons[8] = new JButton("Task Completed");
        finTaskButtons[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	linkedList.remove(finTaskIdNumbers[8]);
            	UpdateTaskList();
            	outputLabel.setText("Task completed!");
            }
        });
        finTaskButtons[9] = new JButton("Task Completed");
        finTaskButtons[9].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	linkedList.remove(finTaskIdNumbers[9]);
            	UpdateTaskList();
            	outputLabel.setText("Task completed!");
            }
        });
        
        //Add fin task buttons and labels for tasks onto the panel
        for (int i = 0; i < MAXTASKSVISIBLE; i++)
        {
        	centerLabels[i] = new JLabel("");
        
        	centerPanel.add(centerLabels[i]);
        	centerPanel.add(finTaskButtons[i]);
        }
        centerPanel.add(new JLabel(""));
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        //Bottom
        
        //Create Panel for bottom of borderlayout base panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(3, 2, 0, 5));
        
        //Add task button
        JButton showDialogButton = new JButton("Add Task");
        showDialogButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
            	//Check if priority level is an integer. If it is proceed as normal; if not output to user.
            	if (isInteger(newPriorityLevelInput.getText()))
            	{
            		//Check if task input is empty. If not add task to list, else print out error to user.
            		if (!newTaskInput.getText().isEmpty())
            		{
		            	Task newTask = new Task(newTaskInput.getText(), Integer.parseInt(newPriorityLevelInput.getText()));
		            	linkedList.add(newTask);
		            	newTaskInput.setText("");
		            	newPriorityLevelInput.setText("");
		            	UpdateTaskList();
		            	outputLabel.setText("Task added!");
            		}
            		else
            		{
            			outputLabel.setText("Error: Enter a task");
            		}
            	}
            	else
            	{
            		outputLabel.setText("Error: Enter an integer for Priority Level");
	            	newPriorityLevelInput.setText("");
            	}
            }
        });
        
        //Add all buttons and text fields to bottom panel
		bottomPanel.add(new JLabel("Task: "));
		bottomPanel.add(newTaskInput);
		bottomPanel.add(new JLabel("Priority Level: "));
		bottomPanel.add(newPriorityLevelInput);
		bottomPanel.add(outputLabel);
		bottomPanel.add(showDialogButton);
		
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
		
        // put the buttons on the frame
        frame.getContentPane().setLayout(new BorderLayout());
        //frame.add(showDialogButton, BorderLayout.SOUTH);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        
        // set up the jframe, then display it
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    //Update the data on the task list
    static void UpdateTaskList()
    {
    	for (int i = 0; i < MAXTASKSVISIBLE; i++)
    	{
    		if (i < linkedList.getCurrentSize())
    		{
    			centerLabels[i].setText(linkedList.get(i).getName());
    			finTaskIdNumbers[i] = linkedList.get(i).getId();
    		}
    		else
    		{
    			centerLabels[i].setText("");
    			finTaskIdNumbers[i] = -1;
    		}
    	}
    }
    
    ///////////////////////////////////////////////////////////
    //Saving and Loading
    static void SerializeList()
    {
 	   try{
		   
 			FileOutputStream fout = new FileOutputStream("LinkedList.ser");
 			ObjectOutputStream oos = new ObjectOutputStream(fout);   
 			oos.writeObject(linkedList);
 			oos.close();
 			System.out.println("Done");
 			   
 		   }catch(Exception ex){
 			   ex.printStackTrace();
 		   }
    }

    static void DeserializeList()
    {
    	
    	CustomLinkedList list;
    	try{
		    
    		FileInputStream fin = new FileInputStream("LinkedList.ser");
    		ObjectInputStream ois = new ObjectInputStream(fin);
		    list = (CustomLinkedList) ois.readObject();
		    ois.close();
		    
		    linkedList = list;
		    UpdateTaskList();
		    outputLabel.setText("List Loaded");
		    }
    	catch(Exception ex){
		    	ex.printStackTrace();
		    	outputLabel.setText("Error: No saved list found");
	   } 
    }
    
    ///////////////////////////////////////////////////////////
    //Error Checking
    public static boolean isInteger(String s) {
        return isInteger(s,10);
    }

    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
}
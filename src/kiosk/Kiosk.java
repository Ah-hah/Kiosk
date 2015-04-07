package kiosk;

import java.io.IOException;
import java.util.Scanner;

/**
 * Jie Liang
 * ID#: 109371227
 * Homework #5
 * Thursday: R06
 * Kevin Flyangolts
 * Grading TA: Zheyuan (Jeffrey) Gao
 * @author jieliang
 */

public class Kiosk {
	
	private static boolean quit = false;
	private static Scanner user_input = null;
	private static String selection = "Root Node";
	
	public Kiosk()
	{
	}

	public static void main(String[] args) throws IOException
	{
		Tree tree = new Tree();
		user_input = new Scanner(System.in);
		displayMenu();
		while(!quit)
		{
			switch (getMenuSelection())
			{
			case "L":loadATree(tree); break;
			case "P":printMenu(tree); break;
			case "S":startService(tree); break;
			case "Q":quitKiosk(); break;
		}
		}
	}
	private static void displayMenu()
	{
		System.out.println("******************");
		System.out.println("Main Menu:");
		System.out.println("******************");
		System.out.println("L) Load a Tree"); 
		System.out.println("P) Print menu");
		System.out.println("S) Start service");
		System.out.println("Q) Quit");
		System.out.println(" ");
	}
	private static String getMenuSelection()
	{
		String selection;
		System.out.print("Choice: ");
		selection = user_input.next().toUpperCase();
		System.out.println(" ");
		
		if(isValidSelection(selection))
			return selection;
		
		System.out.println(selection + " is not a valid choice. Please try again.");
		System.out.println(" ");
		return getMenuSelection();
	}
	
	private static boolean isValidSelection(String selection) 
	{
		return selection.equals("L") || selection.equals("P") || selection.equals("S") || selection.equals("Q");
	}
	
	private static void quitKiosk()
	{
		System.out.println("Kiosk shutting down...");
		quit = true;
	}
	
	private static void loadATree(Tree tree) throws IOException
	{
		String selection;
		System.out.print("Enter the name for the file: ");
		selection = user_input.next().toLowerCase();
		System.out.println(" ");
		tree.beginSession(selection);
		System.out.println("menu has been updated!");
		System.out.println();
	}
	
	private static void startService(Tree tree)
	{
		System.out.println("Help session starting...");
		System.out.println();
		System.out.println(tree.getRoot().getMessage());
		System.out.println(tree.getRoot().getLeft().getSelection());
		System.out.println(tree.getRoot().getMiddle().getSelection());
		System.out.println(tree.getRoot().getRight().getSelection());
		System.out.println("0 Exit Session");
		tree.getSelection();
	}
	
	private static void printMenu(Tree tree)
	{
		System.out.println("Menu: ");
//		tree.printMenu(parentInfo);
	}
}

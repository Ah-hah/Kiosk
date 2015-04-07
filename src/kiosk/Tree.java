package kiosk;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Jie Liang
 * ID#: 109371227
 * Homework #5
 * Thursday: R06
 * Kevin Flyangolts
 * Grading TA: Zheyuan (Jeffrey) Gao
 * @author jieliang
 */

public class Tree {
	
	private TreeNode root;
	private TreeNode[] stack;
	
	public Tree()
	{
		root = null;
	}
	
	public TreeNode findNode(String name, TreeNode node)
	{
		//using array to see multiple children
		if(node != null)
            if (node.getName().equals(name))
                return node;
            else {
            	TreeNode temp = findNode(name, node.getLeft());
            	if(temp == null)
            	{
            		temp = findNode(name, node.getMiddle());
            	}
            	if(temp == null)
            	{
            		temp = findNode(name, node.getRight());
            	}
                return temp;
            }
		else
		{
			return null;
		}
	}
	
	public boolean addNode(String name, String selection, String message, String parentName) throws NoSuchChildException
	{
		TreeNode newNode = new TreeNode();
		newNode.setName(name);
		newNode.setSelection(selection);
		newNode.setMessage(message);
		
		if(root != null)
		{
			TreeNode node = findNode(parentName, root);
			if(node.numChildren() < node.CHILDREN_CAPACITY)
			{
				node.setNthChildren(node.numChildren() + 1, newNode);
				return true;
			}
			else
				return false;
		}
		else
		{
			root = newNode;
			return true;
		}
	}
	
	public void printMenu(String parentInfo)
	{
		StringBuilder b = new StringBuilder();
		b.append(String.format("Dining         Selection                          Price\n"));
		
	}
	
	public void beginSession(String fileName) throws IOException, NoSuchChildException
	{
		FileInputStream fis = new FileInputStream(fileName); 
		InputStreamReader inStream = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(inStream);

		String data;
		int children = 1;
		String parentName = null;
		while((data = reader.readLine()) != null)
		{
			for(int i = 0; i < children; i++)
			{
				String name = data;
				data = reader.readLine();
				String selection = data;
				data = reader.readLine();
				String message = data;
				data = reader.readLine();
				addNode(name, selection, message, parentName);
			}
			if(data != null)
			{
				String information = data;
				StringTokenizer j = new StringTokenizer(information);
				while(j.hasMoreTokens())
				{
					parentName = j.nextToken();
					children = Integer.parseInt(j.nextToken());
				}
			}
		}
	}
	
	public TreeNode getRoot()
	{
		return root;
	}
	
	public TreeNode findNode(String name)
	{
		return findNode(name, root);
	}
	public void getSelection()
	{
		TreeNode cursor = root;
		Scanner user_input = new Scanner(System.in);

		while(!cursor.isLeaf())
		{
			System.out.print("Choice: ");
			String selection = user_input.next().toUpperCase();
			if(selection.equals("0"))
			{
				System.out.println("You have existed the session!");
			}
			if(selection.equals("1"))
			{
				if(cursor.getLeft() != null)
				{
					if(cursor.isLeaf())
					{
						System.out.println("The order at " );
					}
					
					cursor = cursor.getLeft();
					System.out.println(cursor.getMessage());
					if(cursor.getLeft() != null)
					{
						System.out.println(cursor.getLeft().getSelection());
					}
					if(cursor.getMiddle() != null)
					{
						System.out.println(cursor.getMiddle().getSelection());
					}
					if(cursor.getRight() != null)
					{
						System.out.println(cursor.getRight().getSelection());
					}
				}
			}
			else if(selection.equals("2"))
			{
				if(cursor.getMiddle() != null)
				{
					cursor = cursor.getMiddle();
					System.out.println(cursor.getMessage());
					if(cursor.getLeft() != null)
					{
						System.out.println(cursor.getLeft().getSelection());
					}
					if(cursor.getMiddle() != null)
					{
						System.out.println(cursor.getMiddle().getSelection());
					}
					if(cursor.getRight() != null)
					{
						System.out.println(cursor.getRight().getSelection());
					}
				}
			}
			else if(selection.equals("3"))
			{
				if(cursor.getRight() != null)
				{
					cursor = cursor.getRight();
					System.out.println(cursor.getMessage());
					if(cursor.getLeft() != null)
					{
						System.out.println(cursor.getLeft().getSelection());
					}
					if(cursor.getMiddle() != null)
					{
						System.out.println(cursor.getMiddle().getSelection());
					}
					if(cursor.getRight() != null)
					{
						System.out.println(cursor.getRight().getSelection());
					}
				}
			}
		}
	}
}

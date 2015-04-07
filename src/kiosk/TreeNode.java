package kiosk;

/**
 * Jie Liang
 * ID#: 109371227
 * Homework #5
 * Thursday: R06
 * Kevin Flyangolts
 * Grading TA: Zheyuan (Jeffrey) Gao
 * @author jieliang
 */

public class TreeNode {

	private String name;
	private String selection;
	private String message;
	private TreeNode[] children;
	public static int CHILDREN_CAPACITY = 10;
//	private TreeNode left;
//	private TreeNode middle;
//	private TreeNode right;

	
	public TreeNode()
	{
		children = new TreeNode[CHILDREN_CAPACITY];
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSelection()
	{
		return selection;
	}
	public void setSelection(String selection)
	{
		this.selection = selection;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
//	public TreeNode getLeft()
//	{
//		return left;
//	}
//	public void setLeft(TreeNode left)
//	{
//		this.left = left;
//	}
//	public TreeNode getMiddle()
//	{
//		return middle;
//	}
//	public void setMiddle(TreeNode middle)
//	{
//		this.middle = middle;
//	}
//	public TreeNode getRight()
//	{
//		return right;
//	}
//	public void setRight(TreeNode right)
//	{
//		this.right = right;
//	}
	public TreeNode getNthChildren(int n) throws NoSuchChildException
	{
		if(n > 0 && n <= CHILDREN_CAPACITY)
			return children[n - 1];
		else
			throw new NoSuchChildException();
	}
	public void setNthChildren(int n, TreeNode children) throws NoSuchChildException
	{
		if(n > 0 && n <= CHILDREN_CAPACITY)
			this.children[n] = children;
		else
			throw new NoSuchChildException();
	}
	public boolean isLeaf(int n) throws NoSuchChildException
	{
		int count = 0;
		for(int i = 0; i <= CHILDREN_CAPACITY; i ++)
		{
			if(this.getNthChildren(i) == null)
			{
				count++;
			}
		}
		if(count == 10)
			return true;
		else
			return false;
	}
	public int numChildren()
	{
		int count = 0;
		for(TreeNode child : children)
		{
			if(child != null)
				count++;
		}
		return count;
	}
}

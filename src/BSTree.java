import java.awt.Graphics;

public class BSTree {
	
	BSTreeNode root;
	
	
	//recursive method
	public void add(int x)
	{
		if(root == null)
		{
			root = new BSTreeNode(x);
			return;
		}
		add(root, x);
	}
	
	private void add(BSTreeNode n, int x)
	{
		if(n == null) return;
		if(n.data > x)
		{
			if(n.left == null)
			{
				n.left = new BSTreeNode(x);
				return;
			}
			add(n.left, x);
		}
		else if(n.data < x)
		{
			if(n.right == null)
			{
				n.right = new BSTreeNode(x);
				return;
			}
			add(n.right, x);
		}
	}
	
	public void add2(int x) {
		if(root == null) {
			root = new BSTreeNode(x);
			return;
		}
		BSTreeNode n = root;
		while(true) {
			if(n.data > x)
			{
				if(n.left == null)
				{
					n.left = new BSTreeNode(x);
					return;
				}
				n = n.left;
			}
			else if(n.data < x)
			{
				if(n.right == null)
				{
					n.right = new BSTreeNode(x);
					return;
				}
				n = n.right;
			}
			else {
				break;
			}
			
		}
	}
	
	public int num()
	{
		if(root == null) return 0;
		return num(root);
	}
	
	private int num(BSTreeNode n)
	{
		if(n == null) return 0;
		return num(n.left)+num(n.right)+1;
	}
	
	public int height() {
		if(root == null)return -1;
		return height(root);
	}
	
	private int height(BSTreeNode n)
	{
		if(n == null) return -1;
		int l = height(n.left);
		int r = height(n.right);
		return (l > r ? l:r)+1;
	}
	
	public void draw(Graphics g, int screen_width, int screen_height)
	{
		int n = num();
		int h = height();
		
		int sw = screen_width / (n+2);
		int sh = screen_height / (h+2);
		
		draw(g, root, sw, sh, 1, 1, -1, -1);
	}
	
	private int draw(Graphics g, BSTreeNode n, int step_Width, int step_Height, int x, int y, int x_parent, int y_parent) {
		if(n == null) {
			return 0;
		}
		int num_current = 0;
		int num_left = num(n.left);
		num_current += draw(g, n.left, step_Width, step_Height, x, y+1, num_left + x , y);
		
		n.draw(g, (x+num_current)*step_Width, y*step_Height);
		
		if(x_parent != -1 && y_parent != -1)
		{
			g.drawLine((x+num_current)*step_Width, y*step_Height, (x_parent)*step_Width, y_parent*step_Height);
		}
		
		num_current += 1;
		num_current += draw(g, n.right, step_Width, step_Height, x+num_current, y+1, x+num_current-1, y);
		
		return num_current;
	}
	
}

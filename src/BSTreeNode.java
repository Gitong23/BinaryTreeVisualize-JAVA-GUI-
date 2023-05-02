import java.awt.Color;
import java.awt.Graphics;

public class BSTreeNode {
	public int data;
	public BSTreeNode left;
	public BSTreeNode right;
	
	public BSTreeNode() {
		data = 0;
		left = null;
		right = null;
	}
	
	public BSTreeNode(int xdata) {
		this();
		data = xdata;
	}
	
	public BSTreeNode(int xdata, BSTreeNode xleft, BSTreeNode xright) {
		data = xdata;
		left = xleft;
		right = xright;
	}
	
	public void draw(Graphics g, int x, int y) {
		
		g.setColor(Color.GREEN);
		g.fillOval(x-15 , y-15, 30, 30);
		g.setColor(Color.BLACK);
		g.drawString(""+data, x, y);

	}
}

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel{
	
	public BSTree t;

	public Main() {
		
		t = new BSTree();
		for(int i=0; i<50; i++) {
			t.add((int)(Math.random() * 1000));
		}
		
		JFrame f = new JFrame();
		f.add(this);
		f.setSize(500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		System.out.println(t.num());
		System.out.println(t.height());
		
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		t.draw(g, this.getWidth(), this.getHeight());
	}
	
	public static void main(String [] args) {
		
		new Main();
		
	}
}

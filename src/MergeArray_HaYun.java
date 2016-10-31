import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Arrays;
import java.util.ArrayList;

public class MergeArray_HaYun {
    static JFrame frame;
	
	public static void main (String[] args) throws InterruptedException {     
		frame = new JFrame();
		frame.setSize(550,700);
		frame.setBounds(0,0,550,700);
		frame.setTitle("Sort Demonstration");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(null);
		frame.setVisible(true);
		
		JLabel label = new JLabel("Temporary");
		label.setBounds(225,10, 100, 50);
		frame.add(label);
		frame.validate();
		frame.repaint();
		
		Rectangle[] rec = new Rectangle[10];
		for (int i = 0; i < rec.length; i++) {
			rec[i] = new Rectangle();
			rec[i].setBounds(0,0,550,700);
			frame.add(rec[i]);
			frame.validate();
			frame.repaint();
		}
		frame.setVisible(true);
		
		Thread.sleep(2000);
		swapRectangles(rec[1], rec[8]);
    }
	
	public static void moveRectangles(Rectangle r, int posX, int posY) throws InterruptedException {
		int numIntervals = 10;
		int dX = (posX - r.posX)/numIntervals;
		int dY = (posY - r.posY)/numIntervals;
		int sleepTime = 15;
		r.color = Color.RED;
		for (int i = 0; i < numIntervals; i++)
		{
			r.move(dX, dY);
			frame.validate();
			frame.repaint();
			Thread.sleep(sleepTime);
		}
		
		r.move(posX - r.posX, posY - r.posY);
		frame.validate();
		frame.repaint();
		Thread.sleep(sleepTime);
		
		Thread.sleep(sleepTime*50);
		r.color = Color.GREEN;
		frame.validate();
		frame.repaint();
		Thread.sleep(sleepTime*50);
	}
	
	public static void swapRectangles(Rectangle r1, Rectangle r2) throws InterruptedException {
		int tempX = 245;
		int tempY = 60;
		int oldX = r1.posX;
		int oldY = r1.posY;
		int newX = r2.posX;
		int newY = r2.posY;
		int sleepTime = 100;
		
		moveRectangles(r1, tempX, tempY);
		Thread.sleep(sleepTime);
		moveRectangles(r2, oldX, newY);
		Thread.sleep(sleepTime);
		moveRectangles(r1, newX, oldY);
		Thread.sleep(sleepTime);
	}
}

class Rectangle extends JComponent{
    int height = 0;
    int width = 25;
    static int incrementX = 30;
    int posX = 20;
    int posY = 0;
    Rectangle2D.Double rectangle;
	Color color = Color.GREEN;
	
    public Rectangle() {
        height = (int)(Math.random()*100+10);
		posX = incrementX + width + 15;
		incrementX = posX;
		posY = 300-height;
        rectangle = new Rectangle2D.Double(posX, posY, width, height);
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fill(rectangle);
    }
	
	public void move(int dx, int dy) {
		posX += dx;
		posY += dy;
		rectangle = new Rectangle2D.Double(posX, posY, width, height);
	}
}

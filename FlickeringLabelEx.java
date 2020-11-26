import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FlickingThread extends Thread{
	private JLabel flickingLabel;
	int way;
	
	public FlickingThread(JLabel flickingLabel, int way) {
		this.flickingLabel = flickingLabel;
		this.way = way;
	}

	public void run() {
		int n = 0;
		int time = 0;
		while(true) {
			flickingLabel.setOpaque(true);
			if(time % 2 == 0) {
				flickingLabel.setBackground(Color.YELLOW);
				if(way == 1) {
					if(time % 2 == 0) {
						flickingLabel.setLocation(flickingLabel.getX(), flickingLabel.getY()+10);
						if(flickingLabel.getY() > 170) {
							flickingLabel.setLocation(flickingLabel.getX(), 0);
						}
					}
				}
				if(way == 0) {
					if(time % 2 == 0) {
						flickingLabel.setLocation(flickingLabel.getX()+10, flickingLabel.getY());
						if(flickingLabel.getX() > 300) {
							flickingLabel.setLocation(0, flickingLabel.getY());
						}
					}
				}
			} else {
				flickingLabel.setBackground(Color.GREEN);
			}
			time++;
			try {
				Thread.sleep(200);
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
}
public class FlickeringLabelEx extends JFrame{
	JLabel l1 = new JLabel();
	JLabel l2 = new JLabel();
	JLabel l3 = new JLabel();
	
	public FlickeringLabelEx() {
		setTitle("FlickeringLableEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addKeyListener(new MyKeyListener());
		
		l1.setText("±ôºý");
		c.add(l1);

		l2.setText("¾È±ôºý");
		c.add(l2);
		
		l3.setText("¿©±â¼­ ±ôºý");
		c.add(l3);
		
		for (int i = 0; i < 10000; i++) {
			if(i % 2 == 0) {
				l3.setLocation(l3.getX()+30, l3.getY());
			}else {
				l3.setLocation(l3.getX()-30, l3.getY());
			}
		}
		
		FlickingThread t1 = new FlickingThread(l1, 1);
		FlickingThread t3 = new FlickingThread(l3, 0);
		
		setSize(300, 170);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
		
		t1.start();
		t3.start();
	}
	
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
			case KeyEvent.VK_LEFT:
				l2.setLocation(l2.getX()-10, l2.getY());
				break;
			case KeyEvent.VK_RIGHT:
				l2.setLocation(l2.getX()+10, l2.getY());
				break;
			case KeyEvent.VK_UP:
				l2.setLocation(l2.getX(), l2.getY()-10);
				break;
			case KeyEvent.VK_DOWN:
				l2.setLocation(l2.getX(), l2.getY()+10);
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FlickeringLabelEx();
	}

}

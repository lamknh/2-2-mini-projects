import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

class TimerThread extends Thread{
	JLabel clock;
	public TimerThread(JLabel clock){
		this.clock = clock;
		clock.setFont(new Font("나눔글꼴", Font.BOLD, 20));
	}
	
	public void run() {
		while(true) {
			Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int min = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			String clockText = Integer.toString(hour);
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(min));
			clockText = clockText.concat(":");
			clockText = clockText.concat(Integer.toString(second));
			
			clock.setText(clockText);
			try {
				sleep(1000);
			} catch(InterruptedException e) {
				return;
			}
		}
		
	}
}

public class p734_3 extends JFrame{
	JLabel clock = new JLabel();
	public p734_3(){
		setTitle("디지탈 시계 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(clock);
		
		TimerThread th = new TimerThread(clock);
		th.start();
		
		setSize(350, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new p734_3();
	}

}

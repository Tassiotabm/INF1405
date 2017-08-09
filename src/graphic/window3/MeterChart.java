package graphic.window3;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MeterChart extends JPanel {

		private static final long serialVersionUID = 1L;
		Meter meterFace;

		public MeterChart(String s1,String s2) {
			meterFace = new Meter(s1,s2);
			this.add(meterFace, BorderLayout.CENTER);
		}//end constructor
		
	}//end class ClockAnalogBuf

	class Meter extends JPanel {
		
		private static final long serialVersionUID = 1L;

		private static final int spacing = 10;
		// Angles for the trigonometric functions are measured in radians.
		// The following in the number of radians per sec or min.
		private static final float radPerSecMin = (float)(Math.PI / 30.0);
		private int size; // height and width of clock face
		private int centerX; // x coord of middle of clock
		private int centerY; // y coord of middle of clock
		private BufferedImage clockImage;
		private String vDir;
		private float vInt;
		
	//==================================================== Clock constructor
		public Meter(String ventDir,String ventInt) {
			this.setPreferredSize(new Dimension(300,300));
			this.setBackground(Color.white);
			this.setForeground(Color.black);
			this.vDir = ventDir;
			float f = Float.parseFloat(ventInt);
			this.vInt = f;
			update();
	}
	public void update() {
		this.repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // paint background, borders
		Graphics2D g2 = (Graphics2D)g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		RenderingHints.VALUE_ANTIALIAS_ON);
		// The panel may have been resized, get current dimensions
		int w = getWidth();
		int h = getHeight();
		size = ((w<h) ? w : h) - 2*spacing;
		centerX = size/2 + spacing;
		centerY = size/2 + spacing;
		// Create the clock face background image if this is the first time,
		// or if the size of the panel has changed
		if (clockImage == null || clockImage.getWidth() != w || clockImage.getHeight() != h) {
			clockImage = (BufferedImage)(this.createImage(w, h));
		// now get a graphics context from this image
			Graphics2D gc = clockImage.createGraphics();
			gc.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			drawClockFace(gc);
		}

	// Draw the clock face from the precomputed image
		g2.drawImage(clockImage, null, 0, 0);
	// Draw the clock hands
		drawClockHands(g);
	}//end paintComponent
	//======================================================= drawClockHands
	private void drawClockHands(Graphics g) {
		int secondRadius = size/2;
		Double vAngle = Math.acos(vInt/secondRadius); 
		System.out.println(vAngle);
		drawRadius(g, centerX, centerY, vAngle, 0, secondRadius);
	}
	
	private void drawClockFace(Graphics g) {
	// clock face
			g.setColor(Color.blue);
			//g.fillOval(spacing, spacing, size, size);
			g.fillArc(spacing, spacing, size, size, 0, 180);
			g.setColor(Color.black);
			//g.drawOval(spacing, spacing, size, size);
			String dir = "Direção do vento: "+this.vDir;
			String intVento = "Intensidade do Vento"+vInt;
			g.drawString(dir, centerX-70, centerY+50);
			g.drawString(intVento, centerX-60, centerY-50);
			g.setFont(new Font("Courier New", Font.BOLD, 32));
			g.drawString("0", centerX - 125, centerY -0); 
			g.drawString("100", centerX + 85, centerY + 0); 
			
			//Read more: http://mrbool.com/how-to-construct-an-analog-clock-with-java/26863#ixzz4jtuHw3OB
			
			// tic marks
			for (int sec = 15; sec<45; sec++) {
				int ticStart;
				if (sec%5 == 0)
					ticStart = size/2-10;
				else
					ticStart = size/2-5;
				drawRadius(g, centerX, centerY, radPerSecMin*sec, ticStart , size/2);
			}
	}//endmethod drawClockFace
	//=========================================================== drawRadius
	private void drawRadius(Graphics g, int x, int y, double angle, int minRadius, int maxRadius) {
		float sine = (float)Math.sin(angle);
		float cosine = (float)Math.cos(angle);
		int dxmin = (int)(minRadius * sine);
		int dymin = (int)(minRadius * cosine);
		int dxmax = (int)(maxRadius * sine);
		int dymax = (int)(maxRadius * cosine);
		g.drawLine(x+dxmin, y+dymin, x+dxmax, y+dymax);
	}//end drawRadius
}
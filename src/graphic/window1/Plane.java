package graphic.window1;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class Plane extends JPanel{

	private static ImageIcon plane;
	private static int x;
	private static int y;
	private static int width;
	private static int height;
	private static int speed = 4;
	
	Plane(){
		plane = new ImageIcon("images/plane.png");
		x = 800;
		y = 900;
		width = 60;
		height = 60;
	}
	@Override
	protected void paintComponent(Graphics g){
		g.drawImage(this.getPlane().getImage(),Plane.x,Plane.y,Plane.width,Plane.height,null);
	}
	
	public void setY(int y) {
		Plane.y = y;
	}
	public void setX(int x) {
		Plane.x = x;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public ImageIcon getPlane() {
		return plane;
	}
	public void incX(int x1){
		x = x + x1;
	}
	public void incY(int y1){
		y = y + y1;
	}
	public void movePlane(){
		this.incX(speed);
		this.incY(speed);
	}
}

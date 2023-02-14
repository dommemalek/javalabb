import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;



public class Ball extends Sprite{
	

	private int xdirection = 5;
	private int ydirection = 5;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void update(Keyboard keyboard) {
		this.setX(this.getX() + xdirection);
		this.setY(this.getY() + ydirection);
		
		if (this.getX() < 0) {
			this.setX(0);
			xdirection = -xdirection;
		}
		if (this.getX() > 800 - this.getWidth()) {
			this.setX(800 - this.getWidth());
			xdirection = -xdirection;
		}
		if (this.getY() < 0) {
			this.setY(0);
			ydirection = -ydirection;
		}
		if (this.getY() > 600 - this.getHeight()) {
			this.setY(600 - this.getHeight());
			ydirection = -ydirection;
		}
	}


	@Override
	public void draw(Graphics2D graphics) {
		graphics.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}


}

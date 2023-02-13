import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Wall extends Sprite {

	public Wall(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(Color.pink);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public Rectangle getBounds() {
		return new Rectangle(getX(), getY(), getWidth(),getHeight());
	}

	

}

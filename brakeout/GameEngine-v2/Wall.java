import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Wall extends Sprite {

	public Wall(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Keyboard keyboard) {
		
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}

}

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Player extends Sprite {

	static boolean leftkeydown;
	static boolean rightkeydown;
	
	
	static boolean leftkeyup;
	static boolean rightkeyup;
	
	public Player(int x, int y, int width, int height) {
		super(x, y, 80, 10);
	}

	@Override
	public void update(Keyboard keyboard) {

		if(keyboard.isKeyDown(Key.Left)){
			setX(getX()-8);
			leftkeydown = true;
			
		}
		if(keyboard.isKeyUp(Key.Left)) {
			
			leftkeydown = false;
		
		}
		
		if(keyboard.isKeyDown(Key.Right)){
			setX(getX()+8);
			rightkeydown = true;
			
		}
		if(keyboard.isKeyUp(Key.Right)){
			
			rightkeydown = false;
			
	}
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.blue);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	
	public static boolean isLeftKeyDown() {
	    return leftkeydown;
	}

	public static boolean isRightKeyDown() {
	    return rightkeydown;
	}

}
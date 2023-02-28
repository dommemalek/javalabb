import javax.swing.*;

public class Brick extends Sprite {

	private boolean DESTROYED;
	
	public Brick(int x, int y, int width, int height) {
		super(x, y, width, height);
		INIT_BRICK(x, y, width, height);
	}
	
	private void INIT_BRICK(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		DESTROYED = false;
	}
	
	boolean IS_DESTROYED() {
		return DESTROYED;
	
	}
	void setDESTROYED(boolean destroyed) {
		DESTROYED = destroyed;
		}
		
	boolean getDESTROYED() {
		return DESTROYED;
		}
}

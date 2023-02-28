import java.awt.*;

public class Player extends Sprite{

	static boolean leftkeydown;
	static boolean rightkeydown;
	
	
	static boolean leftkeyup;
	static boolean rightkeyup;
	
	
	private int DX;
	
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		INIT_PLAYER();
	}
	
	private void INIT_PLAYER() {
		RESET_STATE();
	}
	private void RESET_STATE() {
		x = IWorld.INIT_PADDLEX;
		y = IWorld.INIT_PADDLEY;
		}
	void MOVE() {
		x += DX;
		if(x <= 0) {
			x = 0;
		}
		if(x+IWorld.PADDEL_WIDTH >= IWorld.WORLD_WIDTH) {
			x = IWorld.WORLD_WIDTH-IWorld.PADDEL_WIDTH;
		}
	}
	public void KEY(Keyboard keyboard) {
		
		
		if(keyboard.isKeyDown(Key.Left)){
			setX(getX()-6);
			DX = -1;
			leftkeydown = true;
			
		}
		if(keyboard.isKeyUp(Key.Left)) {
			DX = 0;
			leftkeydown = false;
		
		}
		
		if(keyboard.isKeyDown(Key.Right)){
			setX(getX()+6);
			DX = 1;
			rightkeydown = true;
			
		}
		if(keyboard.isKeyUp(Key.Right)){
			DX = 0;
			rightkeydown = false;
			
	}
		
	}
		
	public static boolean isLeftKeyDown() {
	    return leftkeydown;
	}

	public static boolean isRightKeyDown() {
	    return rightkeydown;
	}
	
	
}












































/*
public class Player extends Sprite {

	static boolean leftkeydown;
	static boolean rightkeydown;
	
	
	static boolean leftkeyup;
	static boolean rightkeyup;
	
	public Player(int x, int y, int width, int height) {
		super(x, y, 80, 10);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		/*if(keyboard.isKeyDown(Key.Down)) {
			setY(getY()+3);
		}
		if(keyboard.isKeyDown(Key.Up)) {
			setY(getY()-3);
		}
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
		// TODO Auto-generated method stub
		graphics.setColor(Color.blue);
		graphics.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
	public Rectangle2D getBounds() {
		return new Rectangle2D.Double(getX(),getY(), getWidth(), getHeight());
	}
	
	
	
	
	
	
	public static boolean isLeftKeyDown() {
	    return leftkeydown;
	}

	public static boolean isRightKeyDown() {
	    return rightkeydown;
	}
	
	


}*/
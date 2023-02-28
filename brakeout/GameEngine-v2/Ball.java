import javax.swing.*;


public class Ball extends Sprite{

	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		INIT_BALL();
	}
	private int XDIR;
	private int YDIR;
	
	
	private void INIT_BALL() {
	XDIR = 3;
	YDIR = -3;
	RESET_STATE();
	}
	
	private void RESET_STATE() {
	x = IWorld.INIT_BALLX;
	y = IWorld.INIT_BALLY;
	}
	
	void setXDIR(int x) {
	XDIR = x;
	}
	
	void setYDIR(int y) {
	YDIR = y;
		}
	
	int getXDIR() {
	return XDIR;
	}
	
	int getYDIR() {
		return YDIR;
		}
	
	void MOVE() {
		x += XDIR;
		y += YDIR;
		
		if(x == 0) {
			setXDIR(1);
		}
		if(x == IWorld.WORLD_WIDTH) {
			setXDIR(-1);
		}
		if(y == 0) {
			setYDIR(1);
		}
		//if(y == IWorld.WORLD_HEIGHT) {
		//	setYDIR(-1);
		//}
}
   




/*
public class Ball extends Sprite{
	
	public static final double BALL_SIZE = 10;
	public static final double INIT_BALL_SPEED = 5;		
	public enum HIT_ANGLE{
		HORISONTEL, VERTIKAL, UNDEFINED
	
	};

	private double DIRECTION;
	private double SPEED;
	
	public Ball(double x, double y, double DIRECTION, double SPEED) {
		super(x,y,BALL_SIZE,BALL_SIZE);
		this.DIRECTION = DIRECTION;
		this.SPEED = SPEED;
	}
	
	public double getSPEED() {
		return SPEED;
	}
	public double getDIRECTION() {
		return DIRECTION;
	}

	public double getRADIANTS() {
		return DIRECTION / 180 * Math.PI;
	}
	
	public void MOVE() {
		double R = getRADIANTS();
		this.setX(this.getX()+SPEED * Math.cos(R));
		this.setY(this.getY()+SPEED * Math.sin(R));
	}
	
	public void BOUNCE(HIT_ANGLE angle) {
		double R = getRADIANTS();
		double cos = Math.cos(R);
		double sin = Math.sin(R);
		
		if(angle.equals(HIT_ANGLE.HORISONTEL)) {
			sin = -sin;
		}
		else {
			cos = -cos;
		}
		R = (sin > 0) ? Math.acos(cos) : -Math.acos(cos);
		this.DIRECTION = R * 180 / Math.PI;
	}
	
	


	
	@Override
	public void update(Keyboard keyboard) {
		// TODO Auto-generated method stub
		setY(getY()+ydirection);
		setX(getX()+xdirection);
	
		 if (getBounds().intersects(Game.wallleft.getBounds())) {
			  
	            xdirection = -xdirection;
	        }
		 if (getBounds().intersects(Game.wallright.getBounds())) {
	            xdirection = -xdirection;
	        }
		 if (getBounds().intersects(Game.walltop.getBounds())) {
	            ydirection = -ydirection;
	        }
	
		 if (getBounds().intersects(Game.player.getBounds()) && !Player.leftkeydown && !Player.rightkeydown) {
	            ydirection = -ydirection;
	            xdirection = 0;
		 }
		 if (getBounds().intersects(Game.player.getBounds()) && Player.isLeftKeyDown()) {
	            ydirection = -ydirection;
	            xdirection = -5;
	        }
		 if (getBounds().intersects(Game.player.getBounds()) && Player.isRightKeyDown()) {
	            ydirection = -ydirection;
	            xdirection = 5;
	        }
		 //Rectangle spriteBounds =  getBounds();
	
	
		 List<Rectangle> squares = SquareCollection.getSquares(7,10,74,25);
		 for (int i = 0; i < squares.size(); i++) {
		     Rectangle square = squares.get(i);
		     if (square.getBounds().intersects(Game.ball.getBounds())) {
		         ydirection = -ydirection;
		         SquareCollection.removeSquare(square, squares);
		         System.out.println("Ball hit square at index with ball " + i);
		         
		         break;
		     }
		 }
		 
		 /*if (getBounds().intersects(SquareCollection.blocks).getBounds()) {
	            ydirection = -ydirection;
	            xdirection = 5;
	        }
		*/
		 
	}
	
		/* if (getBounds().intersects(SquareCollection.Rectangle.getBounds())) {
	            ydirection = -ydirection;
	            xdirection = -xdirection;
	        }
	
		 
		 
	}
*/
/*
	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.setColor(Color.CYAN);
		graphics.fillOval(getX(), getY(), 20, 20);
	
	}
	
	public Rectangle2D getBounds() {
		return new Rectangle2D.Double(getX(),getY(), 20, 20);
	}

}
*/
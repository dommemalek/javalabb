import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;



public class Ball extends Sprite{
	
	

	private int xdirection = 5;
	private int ydirection = 5;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
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
		 for (Rectangle block : SquareCollection.blocks) {
		     if (block.getBounds().intersects(Game.ball.getBounds())) {
		         ydirection = -ydirection;
		         
		         
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

	@Override
	public void draw(Graphics2D graphics) {
		// TODO Auto-generated method stub
		graphics.fillOval(getX(), getY(), 20, 20);
	}
	
	public Rectangle2D getBounds() {
		return new Rectangle2D.Double(getX(),getY(), 20, 20);
	}

}

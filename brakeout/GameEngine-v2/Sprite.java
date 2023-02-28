import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public abstract class Sprite {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	public int getX() { 
		return this.x; 
		}
	
	public int getY() { 
		return this.y; 
		}
	
	public int getWidth() { 
		return this.width; 
		}
	
	public int getHeight() { 
		return this.height; 
		}
	
	public void setX(int x) { 
		this.x = x; 
		};
		
	public void setY(int y) { 
		this.y = y; 
		};
		
	public void setWidth(int width) { 
		this.width = width; 
		};
		
	public void setHeight(int height) { 
		this.height = height; 
		};
		
	public Sprite(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	
	
	public Rectangle2D getBounds() {
		return new Rectangle2D.Double(getX(), getY(), getWidth(),getHeight());
	}


}



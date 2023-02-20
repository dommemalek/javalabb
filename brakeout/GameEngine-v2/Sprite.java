import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public abstract class Sprite {
	protected double x;
	protected double y;
	protected double width;
	protected double height;
	public double getX() { 
		return this.x; 
		}
	
	public double getY() { 
		return this.y; 
		}
	
	public double getWidth() { 
		return this.width; 
		}
	
	public double getHeight() { 
		return this.height; 
		}
	
	public void setX(double x) { 
		this.x = x; 
		};
		
	public void setY(double y) { 
		this.y = y; 
		};
		
	public void setWidth(double width) { 
		this.width = width; 
		};
		
	public void setHeight(double height) { 
		this.height = height; 
		};
		
	public Sprite(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	
	
	public Rectangle2D getBounds() {
		return new Rectangle2D.Double(getX(), getY(), getWidth(),getHeight());
	}


}



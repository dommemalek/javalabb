import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.awt.image.renderable.ParameterBlock;

public class SquareCollection extends Sprite {
    int rows = 5;
    int columns = 10;
    boolean start=true;
    public static final int BRICK_WIDTH = 70;
    public static final int BRICK_HEIGHT = 20;

    static List<Rectangle> blocks = new ArrayList<>();

    public SquareCollection(int x, int y) {
        super(x, y, BRICK_WIDTH, BRICK_HEIGHT);
    }

    
    
    
    
    
    
    public List<Rectangle> getBlocks(int rows, int columns) {
        blocks.clear();
        int space = 5;
        for (int i = this.getX() + 5; i < this.getX() + columns * BRICK_WIDTH + (columns - 1) * space; i += BRICK_WIDTH + space) {
            for (int j = this.getY(); j < this.getY() + rows * BRICK_HEIGHT + (rows - 1) * space; j += BRICK_HEIGHT + space) {
                blocks.add(new Rectangle(i, j, BRICK_WIDTH, BRICK_HEIGHT));
            }
        }
        return blocks;
    }
    
    
    

    @Override
    public void draw(Graphics2D graphics) {
    	
    	
    	if (start) {
    	getBlocks(rows, columns);
    	start = false;
    	}
    	
    	
    	
    	
    	
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.PINK};
        int colorIndex = 0;
        for (Rectangle block : blocks) {
        	
            graphics.setColor(colors[colorIndex % colors.length]);
            graphics.fill(block);
            
            colorIndex++;
            
            
        }
        
    }

   

    
    
    
    
    @Override
    public void update(Keyboard keyboard) {
        // TODO Auto-generated method stub
    	for (Rectangle block : blocks) {
		     if (block.getBounds().intersects(Game.ball.getBounds())) {
		    	 
		                  // blocks.remove(block);
		                   //getBlocks(rows, columns); // update the list of blocks
		                  
		             
		    	 
		     blocks.get(blocks.indexOf(block)); 
		     System.out.println(blocks.indexOf(block));
		     blocks.remove(block);
		    	 //int index = blocks.indexOf(block);
		        
		     //  blocks.remove(block);
		        
		        System.out.println(blocks.indexOf(block));
		                   break;
		     }
    	}
    }

    	
    
    
    
    
    
    
 

	public Rectangle2D getBounds() {
		return new Rectangle2D.Double(getX(),getY(), getWidth(), getHeight());
	}
    
    
    		}




	
	
	
	
	

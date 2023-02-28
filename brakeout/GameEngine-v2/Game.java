import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;


public class Game {
	
	private String messege = "Game Over";
	private Ball ball;
	private Player player;
	private Wall wallleft;
	private Wall wallright;
	private Wall walltop;
	private int points = 0;
	private int lives = 3;
	private Brick brick;
	private boolean INGAME = true;
	private List<Brick> bricks;
	private ArrayList<Integer> bricklives = new ArrayList<Integer>();
	private int index = 0;
	private int counter = 0;
	
	public Game(GameBoard board) {

		
		INIT_BOARD();
		

	}
	
	private void INIT_BOARD() {
		ball = new Ball(IWorld.INIT_BALLX, IWorld.INIT_BALLY, 20, 20);
		player = new Player(IWorld.INIT_PADDLEX, IWorld.INIT_PADDLEY, 100, 10);
		wallleft = new Wall(0,0,5,600);
		wallright = new Wall(795,0,5,600);
		walltop = new Wall(0,0,800,5);
		brick = new Brick(7,30,60,20);
		bricks = createBrickList();
		 
	

	}
	
	
	
	
	public void update(Keyboard keyboard) {
		
		 if (!INGAME) {
		        return;
		    }

		    ball.MOVE();
		    player.MOVE();
		    player.KEY(keyboard);
		    CHECK_COLISSION();

		    if (lives == 0) {
		        INGAME = false;
		    }
		
		
	}
	
	
	
	
	
	public void draw(Graphics2D graphics) {
		
		if(lives==0) {
			 graphics.setColor(Color.red);
			    graphics.setFont(new Font("Arial", Font.BOLD, 60));
			    graphics.drawString("GAME OVER", 200, 300);
			    graphics.setFont(new Font("Arial", Font.BOLD, 30));
			    graphics.drawString("Your points:" + points, 200, 400);
		 }

		 graphics.setColor(Color.magenta);
		    graphics.setFont(new Font("Arial", Font.BOLD, 17));
		    graphics.drawString("Points: " + points, 650, 25);
		    graphics.setFont(new Font("Arial", Font.BOLD, 17));
		    graphics.drawString("Lives: " + lives, 20, 25);
		
//___________________________________________________________________________________________________________points		
		graphics.setColor(Color.pink);	
	    graphics.drawOval(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
//___________________________________________________________________________________________________________ball	
	    graphics.setColor(Color.blue);
	    graphics.drawRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
//___________________________________________________________________________________________________________player	    
	    graphics.setColor(Color.red);
	    graphics.drawRect(wallleft.getX(), wallleft.getY(), wallleft.getWidth(), wallleft.getHeight());
	    graphics.drawRect(wallright.getX(), wallright.getY(), wallright.getWidth(), wallright.getHeight());
	    graphics.drawRect(walltop.getX(), walltop.getY(), walltop.getWidth(), walltop.getHeight());
	    
//________________________________________________________________________________________________________________________________________________________walls	    
	   
	   
	    index = 0;
	   

	 
	    for (Brick brick : bricks) {
	    	if(bricklives.get(index)==1) {
	    		graphics.setColor(Color.red);
	    	}
	    	else if(bricklives.get(index)==2) {
	    		graphics.setColor(Color.magenta);
	    	}
	    	else if(bricklives.get(index)==3) {
	    		graphics.setColor(Color.yellow);
	    	}
	         	     
	        graphics.drawRect(brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight());
	        index++;
	    }
	}
	
	    
	    
	    
	private List<Brick> createBrickList() {
	    List<Brick> bricks = new ArrayList<>();  
	    int space = 5;
	    int rows = 6;
	    int columns = 12;
	    bricks.clear();
		for(int i = this.brick.getX() + 5; i < this.brick.getX() + columns * this.brick.getWidth() + (columns - 1) * space; i += this.brick.getWidth() + space) {
			bricklives.add(2);
			for(int j = this.brick.getY(); j < this.brick.getY() + rows * this.brick.getHeight() + (rows - 1) * space; j += this.brick.getHeight() + space) {
				bricks.add(new Brick(i, j, this.brick.getWidth(), this.brick.getHeight()));
				bricklives.add(3);
				
				}
			}
			return bricks;
		}
//____________________________________________________________________________________________________________________________________________________________bricks	
	
	   
		
	
	
	
	private void CHECK_COLISSION() {
		
		int BALL_DX = 4;
		int BALL_YX = 4;
		
		if(ball.getBounds().intersects(wallleft.getBounds())){
			ball.setXDIR(BALL_DX);
		}
		if(ball.getBounds().intersects(wallright.getBounds())) {
			ball.setXDIR(-BALL_DX);
		}
		if(ball.getBounds().intersects(walltop.getBounds())) {
			ball.setYDIR(BALL_YX);
		}
//_______________________________________________________________________________________walls
		
		if(ball.getBounds().intersects(player.getBounds())) {
			ball.setYDIR(-BALL_YX);
		}
		 if (ball.getBounds().intersects(player.getBounds()) && Player.isLeftKeyDown()) {
			 ball.setYDIR(-BALL_YX);
			 ball.setXDIR(-BALL_DX);
	        }
		 if (ball.getBounds().intersects(player.getBounds()) && Player.isRightKeyDown()) {
			 ball.setYDIR(-BALL_YX);
			 ball.setXDIR(BALL_DX);
	        }
		 if (ball.getBounds().intersects(player.getBounds()) && !Player.isLeftKeyDown() && !Player.isRightKeyDown()) {
			 ball.setYDIR(-BALL_YX);
			 ball.setXDIR(0);
	        }
//_________________________________________________________________________________________paddle
	
		 index = 0;
		 for (Brick brick : bricks) {
		     if (brick.getBounds().intersects(ball.getBounds()) && ball.getYDIR()<0 ) {
		    	 ball.setYDIR(BALL_YX);
		    	 bricklives.set(index, bricklives.get(index)-1);
		    	 if(bricklives.get(index) == 0) {
		    	 bricks.remove(brick);
		    	 bricklives.remove(index);
		    	 points+=100;
		    	 
		    	 }
		    	 else if(bricklives.get(index)==2) {
		    		 points+=1;
		    	 }
		    	 else if(bricklives.get(index)==1) {
		    		 points+=10;
		    	 }
		         break;
		     }
		     else if(brick.getBounds().intersects(ball.getBounds()) && ball.getYDIR() >0 ) {
		    	 ball.setYDIR(-BALL_YX);
		    	 bricklives.set(index, bricklives.get(index)-1);
		    	 if(bricklives.get(index) == 0) {
		    	 bricks.remove(brick);
		    	 bricklives.remove(index);
		    	 points+=100;
		    	 }
		    	 else if(bricklives.get(index)==2) {
		    		 points+=1;
		    	 }
		    	 else if(bricklives.get(index)==1) {
		    		 points+=10;
		    	 }
		    	 break;
		     }
		     index++;
		 }
//_________________________________________________________________________________________bricks	
		 if(ball.getY() > IWorld.WORLD_HEIGHT) {
			
				lives--;
				ball.setX(IWorld.INIT_BALLX);
				ball.setY(IWorld.INIT_BALLY);
			}
	}
		
		 
	}


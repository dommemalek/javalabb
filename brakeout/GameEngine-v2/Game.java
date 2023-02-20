import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Game {
	
	private String messege = "Game Over";
	private Ball ball;
	private Player player;
	private Wall wallleft;
	private Wall wallright;
	private Wall walltop;
	
	private Brick brick;
	private boolean INGAME = true;

	
	public Game(GameBoard board) {

		INIT_BOARD();

	}
	
	private void INIT_BOARD() {
		ball = new Ball(IWorld.INIT_BALLX,IWorld.INIT_BALLY, 20, 20);
		player = new Player(IWorld.INIT_PADDLEX, 0, 70, 10);
		wallleft = new Wall(0,0,5,600);
		wallright = new Wall(795,0,10,600);
		walltop = new Wall(0,0,800,5);
		brick = new Brick(0,0,0,0);
	
		int bricks = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				brick = new Brick(10, 10, 10, 10);
				bricks++;
			}
		}
	
	
	}
	
	public void update(Keyboard keyboard) {
		
	}
	
	public void draw(Graphics2D graphics) {
		INIT_BOARD();
	}
	
		
	
	
	

}

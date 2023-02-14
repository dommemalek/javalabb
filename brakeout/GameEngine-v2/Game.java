import java.awt.Graphics2D;

public class Game {
	
	
	
	
	//ArrayList<int[]> intPairArrayList = new ArrayList<>();
	
	public static Player player;
	public static SquareCollection squarecollection;
	public static Ball ball;
	
	
	static Wall wallleft;
	static Wall wallright;
	static Wall walltop;
	public static Object square;
	
	
	
	public Game(GameBoard board) {
	
		player = new Player(440,580,20,20);
		squarecollection = new SquareCollection(20,20,20,20);
		ball = new Ball (440, 250, 20,20);
		wallleft = new Wall(0,0,5,600);
		wallright = new Wall(795,0,10,600);
		walltop = new Wall(0,0,800,5);
	
	
	}

	public void update(Keyboard keyboard) {
		player.update(keyboard);
	    squarecollection.update(keyboard);
		ball.update(keyboard);
		wallleft.update(keyboard);
		wallright.update(keyboard);
		walltop.update(keyboard);

		
	}
	

	public void draw(Graphics2D graphics) {

		player.draw(graphics);
		squarecollection.draw(graphics);
	    ball.draw(graphics);
		wallleft.draw(graphics);
		wallright.draw(graphics);
		walltop.draw(graphics);
		
	}
}

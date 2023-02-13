import java.awt.Color;
import java.awt.Graphics2D;

public class ColoredBox extends Sprite {
private Color color;
public ColoredBox(int x, int y, int width, int height, Color
color) {
super(x, y, width, height);
this.color = color;
}
@Override
public void update(Keyboard keyboard) {
	if(getY()> 600) {
		setY(20);
	}
	setY(getY()+3);
}
@Override
public void draw(Graphics2D graphics) {
	// TODO Auto-generated method stub
	graphics.setColor(color);
	graphics.fillRect(getX(),getY(), getWidth(), getHeight());
	
}
}

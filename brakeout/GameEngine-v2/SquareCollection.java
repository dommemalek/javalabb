import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JApplet;

import org.w3c.dom.css.Rect;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.renderable.ParameterBlock;

public class SquareCollection extends Sprite {

    private int points;

    public SquareCollection(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.points = 0;
    }

    public int getPoints() {
        return points;
    }

    public List<Rectangle> getSquares(int x , int y, int width, int height) {
        List<Rectangle> squares = new ArrayList<>();
        final int SPACE = 4;
        for (int i = 0; i < y; i++) { 
            for (int j = 0; j < x; j++) {
                squares.add(new Rectangle(x + SPACE + i * (width + SPACE), y + SPACE + j * (height + SPACE), width, height));
            }
        }
        return squares;
    }

    public void removeSquare(Rectangle square) {
        getSquares(8, 10, 74, 25).remove(square);
    }
    

    @Override
    public void draw(Graphics2D graphics) {

        List <Color> colors = Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.CYAN, Color.MAGENTA, Color.PINK);

        int colorindex = 0;

        for (Rectangle square : getSquares(8, 10, 74, 25)) {
            graphics.setColor(colors.get(colorindex));
            graphics.fill(square);
            colorindex++;
            if (colorindex == colors.size()) {
                colorindex = 0;
            }
        }
    }

    @Override
    public void update(Keyboard keyboard) {

    }

}






	
	
	
	

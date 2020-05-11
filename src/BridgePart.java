import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class BridgePart extends GameObject {

	public BridgePart(float x, float y, Shape shape) {
		super(x, y, shape);
	}

	@Override
	void draw(Graphics g) {
		g.setColor(Color.gray);
		g.fill(shape);
		shape.setLocation(x, y);
	}

	@Override
	void update(int delta, GameDirection direction) {
		if (direction == GameDirection.LEFT) {
			x += 0.2f;
		}
		if(direction == GameDirection.AHEAD) {
			y += 0.2f;
		}
		if(direction == GameDirection.RIGHT) {
			x -= 0.2f;
		}
		
	}

}

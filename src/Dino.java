import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public class Dino extends GameObject{
	private float movementSpeed = 0.1f;
	
	public Dino(float x, float y, Shape shape) {
		super(x,y,shape);
	}

	@Override
	void draw(Graphics g) {
		g.setColor(Color.red);
		g.fill(shape);
		shape.setLocation(x, y);
	}

	@Override
	void update(int delta) {
		y = y - movementSpeed;
	}

}

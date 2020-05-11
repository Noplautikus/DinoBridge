import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;

public abstract class GameObject {
	protected float x;
	protected float y;
	protected Shape shape;
	
	public  GameObject(float x , float y, Shape shape) {
		this.x = x;
		this.y = y;
		this.shape = shape;
	}
	
	abstract void draw(Graphics g); 
	abstract void update(int delta, GameDirection direction); 
}

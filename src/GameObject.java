import org.newdawn.slick.geom.Shape;

public abstract class GameObject {
	protected int x;
	protected int y;
	protected Shape shape;
	
	
	abstract void draw(); 
	abstract void update(); 
}

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class DinoBridge extends BasicGame {

	private Dino dino;
	private float dinoRadius = 10f;
	
	public DinoBridge() {
		super("DinoBridge");
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer container = new AppGameContainer(new DinoBridge());
		container.setDisplayMode(1200, 800, false);
		container.start();
	}
	@Override
	public void init(GameContainer container) throws SlickException {
		float xDinoPosition = container.getWidth() / 2 - dinoRadius;
		float yDinoPosition = container.getHeight() - 20 - dinoRadius * 2;
		dino = new Dino(xDinoPosition, yDinoPosition, new Circle(100, 100, dinoRadius));
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		dino.draw(g);
	}

	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		dino.update(delta);
	}
}

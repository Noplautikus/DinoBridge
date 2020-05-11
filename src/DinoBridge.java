import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class DinoBridge extends BasicGame {

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
		// TODO Auto-generated method stub
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
	}

	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
	}
}

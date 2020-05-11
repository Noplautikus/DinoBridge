import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class DinoBridge extends BasicGame {

	private Dino dino;
	private float dinoRadius = 10f;
	
	private ArrayList<BridgePart> initialBridge = new ArrayList<BridgePart>();
	private float bridgeWidth = 100f;
	private float bridgeHeight = 100f;
	
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
		float xBridgePosition = container.getWidth() / 2 - bridgeWidth / 2;
		float yBridgePosition = container.getHeight() - bridgeHeight;
		
		for(int i = 0; i < 10; i++) {
			initialBridge.add(new BridgePart(xBridgePosition, yBridgePosition, new Rectangle(100, 100, bridgeWidth, bridgeHeight)));
			yBridgePosition -= 100;
		}
		
		float xDinoPosition = container.getWidth() / 2 - dinoRadius;
		float yDinoPosition = container.getHeight() / 2 - dinoRadius;
		dino = new Dino(xDinoPosition, yDinoPosition, new Circle(100, 100, dinoRadius));
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		for(BridgePart bridgePart : initialBridge) {
			bridgePart.draw(g);
		}
		dino.draw(g);
	}

	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		for(BridgePart bridgePart : initialBridge) {
			bridgePart.update(delta);
		}
		dino.update(delta);
	}
}

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;

public class DinoBridge extends BasicGame {
	
	private GameDirection gameDirection = GameDirection.AHEAD;
	long timeStamp;

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
		timeStamp = container.getTime();
		initBridge(container);
		initDino(container);
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
			bridgePart.update(delta, gameDirection);
		}
		dino.update(delta, gameDirection);
		
		buildNewBridgePart(container);
		
		long currentTime = container.getTime();
		
		//getNewGameDirection(currentTime);
		System.out.println(initialBridge.size());
		
		for (int i = 0; i< initialBridge.size(); i++)
		{
			if (initialBridge.size() > 20)
			{
				initialBridge.remove(i);
			}
		}
	}

	private void getNewGameDirection(long currentTime) { // muss noch verbessert werden aktuell funktionieren die links und rechts nicht richtig weil sie nur aufgerufen werden können wenn die vorherige richtung oben war, am besten wird wenn die aktuelle richung linkt ist sowohl der befehl oben als auch rechts genutzt um die richtung wieder nach oben zu bewegen.
		if (currentTime - timeStamp > 1000) {
			int pick = new Random().nextInt(GameDirection.values().length);
			
			if(pick == 0 && gameDirection == GameDirection.AHEAD) {
				gameDirection = GameDirection.LEFT;
			}
			if(pick == 1 && gameDirection != GameDirection.AHEAD) {
				gameDirection = GameDirection.AHEAD;
			}
			if(pick == 2 && gameDirection == GameDirection.AHEAD) {
				gameDirection = GameDirection.RIGHT;
			}
			
			timeStamp = currentTime;
		}
	}

	private void buildNewBridgePart(GameContainer container) {
		Input input = container.getInput();
		if(input.isKeyPressed(Input.KEY_W)) {
			float newXPosition = getXPositionOfLastBridgePart();
			float newYPosition = getYPositionOfLastBridgePart() - bridgeHeight;
			initialBridge.add(new BridgePart(newXPosition, newYPosition, new Rectangle(100, 100, bridgeWidth, bridgeHeight)));
		};
	}

	private float getYPositionOfLastBridgePart() {
		return initialBridge.get(initialBridge.size() - 1).y;
	}

	private float getXPositionOfLastBridgePart() {
		return initialBridge.get(initialBridge.size() - 1).x;
	}
	
	private void initDino(GameContainer container) {
		float xDinoPosition = container.getWidth() / 2 - dinoRadius;
		float yDinoPosition = container.getHeight() / 2 - dinoRadius;
		dino = new Dino(xDinoPosition, yDinoPosition, new Circle(100, 100, dinoRadius));
	}

	private void initBridge(GameContainer container) {
		float xBridgePosition = container.getWidth() / 2 - bridgeWidth / 2;
		float yBridgePosition = container.getHeight() - bridgeHeight;
		
		for(int i = 0; i < 10; i++) {
			initialBridge.add(new BridgePart(xBridgePosition, yBridgePosition, new Rectangle(100, 100, bridgeWidth, bridgeHeight)));
			yBridgePosition -= 100;
		}
	}
}

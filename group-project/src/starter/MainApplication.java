package starter;

import java.awt.Font;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static final int BUTTON_HEIGHT = 120;
	public static final int BUTTON_WIDTH = 50;
	public static Font titleFont = new Font("Serif", Font.BOLD, 48);

	
	private int finalScore;
	private Credits credit;
	private Graphics graphics;
	private GameOver gameOver;
	private StartMenu start;
	private Stage stage;
	private Scoreboard scoreboard;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		credit= new Credits(this);
		graphics=new Graphics(this);
		gameOver= new GameOver(this);
		start= new StartMenu(this);
		stage = new Stage(this);
		scoreboard = new Scoreboard(this);
		switchToMenu();
	}
	
	public void switchToGraphics() {
		switchToScreen(graphics);
	}

	public void switchToMenu() {
		switchToScreen(start);
	}
	
	public void switchToGameOver() {
		switchToScreen(gameOver);
	}
	
	public void switchToCredits() {
		switchToScreen(credit);
	}
	
	public void switchToStage() {
		switchToScreen(stage);
	}
	
	public int getScore() {
		return finalScore;
	}
	
	public void setScore(int s) {
		finalScore=s;
	}
	
//	public void switchToNewStage() {
//		switchToScreen(stage);
//	}
}

package starter;

import acm.graphics.GLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class GameOver extends GraphicsPane {
	private MainApplication program;
	
	public static final int GO_X = 800/3;
	public static final int GO_Y = 600/2;
	
	private GLabel gameOver, enter, score,finalScore;
	
	public GameOver(MainApplication program) {
		this.program=program;
		
		gameOver= new GLabel("GAME OVER", GO_X, GO_Y);
		gameOver.setColor(Color.red);
		gameOver.setFont(new Font("Consolas",Font.BOLD, 50));
		
		enter= new GLabel("Press Enter to continue", GO_X, GO_Y+100);
		enter.setColor(Color.pink);
		enter.setFont(new Font("Consolas",Font.BOLD, 20));
		
		score= new GLabel(""+program.getScore(), GO_X+125, GO_Y+60);
		score.setColor(Color.cyan);
		score.setFont(new Font("Consolas",Font.PLAIN, 25));
		
		finalScore= new GLabel("Final Score: ", GO_X-50, GO_Y+60);
		finalScore.setColor(Color.cyan);
		finalScore.setFont(new Font("Consolas",Font.PLAIN, 25));
	}
	
	@Override
	public void showContents() {
		score.setLabel(""+program.getScore());
		program.setBackground(Color.black);
		program.add(gameOver);
		program.add(enter);
		program.add(score);
		program.add(finalScore);
	}

	@Override
	public void hideContents() {
		program.removeAll();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			program.setScore(0);
			program.switchToScoreboard();
			//switch to scoreboard screen after game over screen
		}
	}
}
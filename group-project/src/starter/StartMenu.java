package starter;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import acm.graphics.GLabel;

public class StartMenu extends GraphicsPane implements MouseListener{
    private MainApplication program;
	
	private GLabel title;
    private GButton start, credits, exit, scoreboard;

    StartMenu(MainApplication program) {
        this.program=program;
    	
        title = new GLabel("Galaga");
        title.setColor(Color.cyan);
        title.setFont(new Font("Consolas",Font.BOLD, 100));
        title.setLocation(220, 125);
        
        start = new GButton("Start",270, 200, 200, 50);
        scoreboard = new GButton("Scoreboard",270, 300, 200, 50);
        credits = new GButton("Credits", 270, 400, 200, 50);
        exit = new GButton("Exit", 270, 500, 200, 50);
    }
    
    @Override
	public void mousePressed(MouseEvent e) {
    	if(start.contains(e.getX(), e.getY())) {
           program.switchToGraphics();
        }
    	if(scoreboard.contains(e.getX(), e.getY())) {
    		program.switchToScoreboard();
    	}
        if(credits.contains(e.getX(), e.getY())) {
        	program.switchToCredits();
        }
        if(exit.contains(e.getX(), e.getY())){
        	System.exit(0);
        }
	}
    
	@Override
	public void showContents() {
		program.setBackground(Color.BLACK);
		program.add(title);
		program.add(start);
		program.add(scoreboard);
		program.add(credits);
		program.add(exit);
	}


	@Override
	public void hideContents() {
		program.removeAll();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

}
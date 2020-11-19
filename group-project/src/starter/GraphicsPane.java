package starter;


/* File: GraphicsPane.java
 * -----------------------
 * Like you did with your own graphics programs, simply
 * extend from GraphicsPane and implement
 * as little or as much of the mouse listeners that you need
 * for your own programs.  Notice however that in this situation
 * There is no access to the GraphicsProgram window.
 * Make sure to distinguish between your constructor
 * and using showContents and hideContents
 */

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class GraphicsPane implements Interfaceable {
	@Override
	public abstract void showContents();

	@Override
	public abstract void hideContents();

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}


	public void keyPressed(KeyEvent e) {
		//program.add(fighter.getFighterImage());
			int key = e.getKeyCode();
			System.out.println(key==KeyEvent.VK_A);
				if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
					//fighter.moveFighterLeft(FIGHTER_X, FIGHTER_Y);
					System.out.println("moveR");
				}
				if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
					//fighter.moveFighterRight(FIGHTER_X, FIGHTER_Y);
					System.out.println("moveL");
				}
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}

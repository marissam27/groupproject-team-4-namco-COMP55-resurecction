package starter;

import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRectangle;

public class Fighter extends GRectangle{
	public static final int IMAGE_SIZE = 45;
	public static final int FIGHTER_MID=(IMAGE_SIZE/2)-3;
	public static final int PROGRAM_WIDTH = 800;
	
	//private space position;				We are now inheriting GRectangle.
	double speed;
//	int lives;
	private ArrayList<GImage> lives;
	Bullet shoot;
	//add a GImage
	private GImage fighterImage;
	private GImage bulletImage;
	
	
//Getters
	public ArrayList<GImage> getLives() {
		return lives;
	}
	
	/*
	public space getPosition() {
		return position;
	}*/
	
	public GImage getFighterImage() {
		return fighterImage;
	}
	
	public Bullet getBullet() {
		return shoot;
	}
	
	//Setters
//	public void setFighterPosition(GImage i) {
//		double imageX = i.getX();
//		double imageY = i.getY();
//		this.setLocation(imageX, imageY);
//	}
	
	public void setFighterPosition(double x, double y) {
		this.setLocation(x,y);
		fighterImage.setLocation(x,y);
	}
	
	public void setLives(int lives) {
		this.lives = new ArrayList<GImage>(lives);
	}
	
	//Constructors
	Fighter(){
		//position = new space(0, 0);
		this.setLocation(0, 0);
		bulletImage= new GImage("fighter bullet.png");
		fighterImage = new GImage("Fighter.png", 0, 0);
		fighterImage.setLocation(0, 0);
		lives = new ArrayList<GImage>(3);
		for(int i=0;i<3;i++) {
			GImage life=new GImage("Fighter.png");
			life.setSize(IMAGE_SIZE, IMAGE_SIZE);
			lives.add(life);
		}
		shoot=new Bullet(0,0,-4,bulletImage);
	}
	
	Fighter(int x, int y, /*space p,*/ int l){
		//position = new space(x, y);
		//position = p;
		this.setLocation(x, y);
		bulletImage= new GImage("fighter bullet.png");
		fighterImage = new GImage("Fighter.png", x, y);
		lives = new ArrayList<GImage>(l);
		for(int i=0;i<l;i++) {
			GImage life=new GImage("Fighter.png");
			life.setSize(IMAGE_SIZE, IMAGE_SIZE);
			lives.add(life);
		}
		shoot=new Bullet(x,y,-4, bulletImage);
	}
	
	//Methods
	public void addLife() {
		lives.add(fighterImage);
	}
	
	public void loseLife() {
		lives.remove(lives.size()-1);
	}
	
	public boolean isLivesEmpty() {
		return lives.isEmpty();
	}
	
	public boolean isFighterHit(Red red) {
		if(this.intersects(red)) {
			System.out.print("Lives: "+lives.size());
			return true;
		}
		return false;
	}
	
	public void shoot(MainApplication program) {
			shoot.addBullet(this.getLocation().getX()+FIGHTER_MID, this.getLocation().getY(), program);
	}
	
	public void moveLeft() {
		
	}
	//how do I get this to interact 
//	public void moveFighter(KeyEvent e) {
//		char c = e.getKeyChar();
//		int key = e.getKeyCode();
//		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
//			fighterImage = new GImage("Fighter.png", FIGHTER_POSITION_X+3, FIGHTER_POSITION_X);
//		}
//		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
//			fighterImage = new GImage("Fighter.png", FIGHTER_POSITION_X-3, FIGHTER_POSITION_X);
//		}
//	}
	
	public void moveRight() {
		
	}
}

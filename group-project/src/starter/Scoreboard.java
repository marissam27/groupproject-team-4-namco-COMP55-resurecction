package starter;

import acm.graphics.GLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.util.Pair;

public class Scoreboard extends GraphicsPane {
	//variables
	private MainApplication program;
	private GLabel Highscore, score1, score2, score3, score4, score5, score6, score7, score8, score9, score10,
					getName, finalName, pressEscape;
	private String font = "Consolas";
	public static final int GO_X = 800/3;
	public static final int GO_Y = 600/2;
	
	private ArrayList<Pair<String, String>> top10scores = new ArrayList<Pair<String, String>>();
	private String filename = new String("TopScores.txt");
	private Integer newScoreSpot;
	private Boolean compared;
	
	//Methods
	//Create Scoreboard screen
	public Scoreboard(MainApplication program){
		this.program=program;
		
		initializeScoreboard();
		
		Highscore= new GLabel("Highscores", GO_X+20, GO_Y-200);
		Highscore.setColor(Color.white);
		Highscore.setFont(new Font(font,Font.BOLD, 35));
		
		score1= new GLabel("1 "+top10scores.get(0).getKey()+" "+top10scores.get(0).getValue(), GO_X-150, GO_Y-100);
		score1.setColor(Color.white);
		score1.setFont(new Font(font,Font.PLAIN, 25));
		
		score2= new GLabel("2 "+top10scores.get(1).getKey()+" "+top10scores.get(1).getValue(), GO_X-150, GO_Y-60);
		score2.setColor(Color.white);
		score2.setFont(new Font(font,Font.PLAIN, 25));
		
		score3= new GLabel("3 "+top10scores.get(2).getKey()+" "+top10scores.get(2).getValue(), GO_X-150, GO_Y-20);
		score3.setColor(Color.white);
		score3.setFont(new Font(font,Font.PLAIN, 25));
		
		score4= new GLabel("4 "+top10scores.get(3).getKey()+" "+top10scores.get(3).getValue(), GO_X-150, GO_Y+20);
		score4.setColor(Color.white);
		score4.setFont(new Font(font,Font.PLAIN, 25));
		
		score5= new GLabel("5 "+top10scores.get(4).getKey()+" "+top10scores.get(4).getValue(), GO_X-150, GO_Y+60);
		score5.setColor(Color.white);
		score5.setFont(new Font(font,Font.PLAIN, 25));
		
		score6= new GLabel(" 6 "+top10scores.get(5).getKey()+" "+top10scores.get(5).getValue(), GO_X+200, GO_Y-100);
		score6.setColor(Color.white);
		score6.setFont(new Font(font,Font.PLAIN, 25));
		
		score7= new GLabel(" 7 "+top10scores.get(6).getKey()+" "+top10scores.get(6).getValue(), GO_X+200, GO_Y-60);
		score7.setColor(Color.white);
		score7.setFont(new Font(font,Font.PLAIN, 25));
		
		score8= new GLabel(" 8 "+top10scores.get(7).getKey()+" "+top10scores.get(7).getValue(), GO_X+200, GO_Y-20);
		score8.setColor(Color.white);
		score8.setFont(new Font(font,Font.PLAIN, 25));
		
		score9= new GLabel(" 9 "+top10scores.get(8).getKey()+" "+top10scores.get(8).getValue(), GO_X+200, GO_Y+20);
		score9.setColor(Color.white);
		score9.setFont(new Font(font,Font.PLAIN, 25));
		
		score10= new GLabel("10 "+top10scores.get(9).getKey()+" "+top10scores.get(9).getValue(), GO_X+200, GO_Y+60);
		score10.setColor(Color.white);
		score10.setFont(new Font(font,Font.PLAIN, 25));
		
		getName= new GLabel("Type 3 letters for your name", GO_X-100, GO_Y+100);
		getName.setColor(Color.LIGHT_GRAY);
		getName.setFont(new Font(font,Font.PLAIN, 30));
		
		finalName = new GLabel("",GO_X+50,GO_Y+150);
		finalName.setColor(Color.LIGHT_GRAY);
		finalName.setFont(new Font(font,Font.PLAIN, 25));
		
		pressEscape = new GLabel("Press escape to go to main menu",GO_X-100,GO_Y+200);
		pressEscape.setColor(Color.gray);
		pressEscape.setFont(new Font(font,Font.PLAIN, 25));
	}
	
	@Override
	public void showContents() {
		program.setBackground(Color.black);
		program.add(Highscore);
		
		changeColor(score1,0);
		program.add(score1);
		
		changeColor(score2,1);
		program.add(score2);
		
		changeColor(score3,2);
		program.add(score3);
		
		changeColor(score4,3);
		program.add(score4);
		
		changeColor(score5,4);
		program.add(score5);
		
		changeColor(score6,5);
		program.add(score6);
		
		changeColor(score7,6);
		program.add(score7);
		
		changeColor(score8,7);
		program.add(score8);
		
		changeColor(score9,8);
		program.add(score9);
		
		changeColor(score10,9);
		program.add(score10);
		
		program.add(pressEscape);
		
		if(compared.booleanValue() == false && program.getScore() != 0) {
			compareScores(program.getScore());
		}
	}

	@Override
	public void hideContents() {
		showContents();
		compared = new Boolean(false);
		newScoreSpot = new Integer(-1);
		finalName.setLabel("");
		program.removeAll();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			program.setScore(0);
			program.switchToMenu();
		}
		else {
			getUserInput(e);
		}
	}
	
	//changes score font color where the new score was placed
	private void changeColor(GLabel label, Integer spot) {
		if(newScoreSpot == spot) {
			if(label.getColor() == Color.cyan) {
				label.setColor(Color.white);
			}
			else {
				label.setColor(Color.cyan);
			}
		}
	}
	
	//change all score labels when new score is added
	private void changeAllLabels() {
		score1.setLabel("1 "+top10scores.get(0).getKey()+" "+top10scores.get(0).getValue());
		score2.setLabel("2 "+top10scores.get(1).getKey()+" "+top10scores.get(1).getValue());
		score3.setLabel("3 "+top10scores.get(2).getKey()+" "+top10scores.get(2).getValue());
		score4.setLabel("4 "+top10scores.get(3).getKey()+" "+top10scores.get(3).getValue());
		score5.setLabel("5 "+top10scores.get(4).getKey()+" "+top10scores.get(4).getValue());
		score6.setLabel(" 6 "+top10scores.get(5).getKey()+" "+top10scores.get(5).getValue());
		score7.setLabel(" 7 "+top10scores.get(6).getKey()+" "+top10scores.get(6).getValue());
		score8.setLabel(" 8 "+top10scores.get(7).getKey()+" "+top10scores.get(7).getValue());
		score9.setLabel(" 9 "+top10scores.get(8).getKey()+" "+top10scores.get(8).getValue());
		score10.setLabel("10 "+top10scores.get(9).getKey()+" "+top10scores.get(9).getValue());
	}
	
	private void getUserInput(KeyEvent key) {
		switch(key.getKeyCode()) {
		case KeyEvent.VK_A:
		case KeyEvent.VK_B:
		case KeyEvent.VK_C:
		case KeyEvent.VK_D:
		case KeyEvent.VK_E:
		case KeyEvent.VK_F:
		case KeyEvent.VK_G:
		case KeyEvent.VK_H:
		case KeyEvent.VK_I:
		case KeyEvent.VK_J:
		case KeyEvent.VK_K:
		case KeyEvent.VK_L:
		case KeyEvent.VK_M:
		case KeyEvent.VK_N:
		case KeyEvent.VK_O:
		case KeyEvent.VK_P:
		case KeyEvent.VK_Q:
		case KeyEvent.VK_R:
		case KeyEvent.VK_S:
		case KeyEvent.VK_T:
		case KeyEvent.VK_U:
		case KeyEvent.VK_V:
		case KeyEvent.VK_W:
		case KeyEvent.VK_X:
		case KeyEvent.VK_Y:
		case KeyEvent.VK_Z:
			finalName.setLabel(finalName.getLabel()+key.getKeyChar());
			break;
		default:
			break;
		}
		
		program.add(finalName);
		
		if(finalName.getLabel().length() == 3) {
			program.remove(finalName);
			
			//add name to new score spot
			String tempScore = top10scores.get(newScoreSpot).getValue();
			top10scores.add(newScoreSpot, new Pair<>(finalName.getLabel(),tempScore));
			top10scores.remove(newScoreSpot+1);	
			
			changeAllLabels();
			program.remove(finalName);
			program.remove(getName);
			program.add(pressEscape);
			showContents();
		}
	}
	
	//Initialize arrayList with default values
	public void initializeScoreboard() {
		for(int i=0;i<10;i++) {
			top10scores.add(new Pair<>("---","000000"));
		}
		compared = new Boolean(false);
		newScoreSpot = new Integer(-1);
	}
	
	//Compare new score to top 10 scores to see if new score will be added to top 10
	public void compareScores(int newScore) {
		for(int i=0;i<10;i++) {
			if(newScore >= Integer.parseInt(top10scores.get(i).getValue())) {
				askUser();
				newScoreSpot = new Integer(i);
				top10scores.add(i, new Pair<>("---", String.valueOf(newScore)));
				changeAllLabels();
				top10scores.remove(10);
				newScoreSpot = i;
				program.setScore(0);
				break;
			}
		}
		compared = new Boolean(true);
	}
	
	//Asks user for name to use on scoreboard
	public void askUser() {
		program.remove(pressEscape);
		program.add(getName);
	}
	
	//Saves top 10 scores(arrayList data)
	public void saveScores() throws IOException {
		clearFile();
		
		PrintWriter out = new PrintWriter(filename);
		
		for(Pair<String, String> score : top10scores) {
			out.println(score.getKey()+" "+score.getValue());
		}
		out.close();
	}
	
	//Loads top 10 scores to arrayList
	public void loadScores() throws IOException {
		Scanner scan = new Scanner(filename);
		String name = new String("");
		String score = new String("");
		while(scan.hasNextLine()) {
    		String line= scan.next();
    		for(int i=0; i<line.length() ;i++) {
    			if(Character.isWhitespace(line.charAt(i))) {
    				
    				//checks rest of line from file for score and then adds name and score to arrayList
    				for(int j=i; j<line.length() ;j++) {
    					if(Character.isWhitespace(line.charAt(i))) {
    						top10scores.add(new Pair<>(name, score));
        				}
    					score += line.charAt(j);
    				}
    				break;//will this leave the for loop or just the if statement?
    			}
    			name += line.charAt(i);
    		}
    		score = new String();
    		name= new String();
    	}
		scan.close();
	}
	
	//Clears file that saves top 10 scores
	private void clearFile() throws IOException {
		FileWriter file = new FileWriter(filename, true);
		PrintWriter in = new PrintWriter(file);
		in.print("");
		in.close();
	}
}

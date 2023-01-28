package starter;

import java.awt.Graphics;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.util.Pair;

public class Scoreboard {
	//variables
	private MainApplication program;
	
	private ArrayList<Pair<String, Integer>> top10scores = new ArrayList<Pair<String, Integer>>();
	private String filename = new String("TopScores.txt");
	
	//Methods
	//Create Scoreboard screen
	public Scoreboard(MainApplication program){
		this.program=program;
		
	}
	
	//Initialize arrayList with default values
	public Scoreboard() {
		for(int i=0;i<10;i++) {
			top10scores.add(new Pair<>("---",000000));
		}
	}
	
	//Compare new score to top 10 scores to see if new score will be added to top 10
	public void compareScores(int newScore) {
		for(int i=0;i<10;i++) {
			if(newScore >= top10scores.get(i).getValue()) {
				String name = getUsername();
				top10scores.add(i, new Pair<>(name, newScore));
				top10scores.remove(10);
			}
		}
	}
	
	//Asks user for name to use on scoreboard
	public String getUsername() {
		String name = new String("");
		//ask user for name
		if (name.length() != 3) {
			//ask user for name again
		}
		return name;
	}
	
	//Saves top 10 scores(arrayList data)
	public void saveScores() throws IOException {
		clearFile();
		
		PrintWriter out = new PrintWriter(filename);
		
		for(Pair<String, Integer> score : top10scores) {
			out.println(score.getKey()+" "+score.getValue());
		}
		out.close();
	}
	
	//Loads top 10 scores to arrayList
	public void loadScores() throws IOException {
		Scanner scan = new Scanner(filename);
		String name = new String("");
		Integer score = 0;
		while(scan.hasNextLine()) {
    		String line= scan.next();
    		for(int i=0; i<line.length() ;i++) {
    			if(Character.isWhitespace(line.charAt(i))) {
    				
    				//checks rest of line from file for score and then adds name and score to arrayList
    				for(int j=i; j<line.length() ;j++) {
    					if(Character.isWhitespace(line.charAt(i))) {
    						top10scores.add(new Pair<String, Integer>(name, score));
        				}
    					score += line.charAt(j);
    				}
    				break;//will this leave the for loop or just the if statement?
    			}
    			name += line.charAt(i);
    		}
    		score = 0;
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

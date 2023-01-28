package starter;

import java.awt.Graphics;
import java.io.*;
import java.util.ArrayList;
import javafx.util.Pair;
//import java.io.PrintWriter;
//import java.io.IOException;

public class Scoreboard {
	//variables
	private ArrayList<Pair<String, Integer>> top10scores = new ArrayList<Pair<String, Integer>>();
	private String filename = new String("TopScores.txt");
	
	//Methods
	public Scoreboard() {
		for(int i=0;i<10;i++) {
			top10scores.add(new Pair<>("---",000000));
		}
	}
	
	public void compareScores(int newScore) {
		for(int i=0;i<10;i++) {
			if(newScore >= top10scores.get(i).getValue()) {
				String name = getUsername();
				top10scores.add(i, new Pair<>(name, newScore));
				top10scores.remove(10);
			}
		}
	}
	
	public String getUsername() {
		String name = new String("");
		//ask user for name
		if (name.length() != 3) {
			//ask user for name again
		}
		return name;
	}
	
	public void saveScores() throws IOException {
		clearFile();
		
		PrintWriter out = new PrintWriter(filename);
		
		for(Pair<String, Integer> score : top10scores) {
			out.println(score.getKey()+" "+score.getValue());
		}
		out.close();
	}
	
	public void loadScores() throws IOException {
		
		
		
	}
	
	private void clearFile() throws IOException {
		FileWriter file = new FileWriter(filename, true);
		PrintWriter in = new PrintWriter(file);
		in.print("");
		in.close();
	}
}

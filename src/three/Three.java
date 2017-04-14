package three;

import java.io.*;

import java.security.MessageDigest;
import java.lang.*;

/**
 * 
 * @author kelkun
 * @brief can create research three for a world
 *
 */
public class Three {
	
	//Variables
	private CharNode currentElt = null;
	private CharNode firstElt = null;
	private int nbLine = 0;
	private String path = "";

	public Three(String path){
		this.path = path;
		threeFile();
	}
	
	/**
	 * @brief read a txt file and create the three
	 */
	private void threeFile(){
		try{
			File fichier = new File(path);
			BufferedReader txt = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"));
			String line;
			//Une ligne équivaut à une entrée
			while ((line = txt.readLine()) != null){
				nbLine ++;
				System.out.println(line);
				createBranch(line);
			}
		}
		catch(Exception e){e.printStackTrace();}
	}
	
	/**
	 * @brief create branch for every new word
	 * @param line current line of the file
	 */
	private void createBranch(String line){
		boolean check = true;
		int k = 0;
		
		//check if there is a word in the three
		if (firstElt != null){
			//read all character
			while(check && k<line.length()){
				//check if it's the same character
				if(currentElt.getCurrent() == line.charAt(k) && currentElt.getChild() != null){
					currentElt = currentElt.getChild();
					k++;
				}
				//else decal to neighboor
				else if(currentElt.getCurrent() != line.charAt(k) && currentElt.getNeighboor() != null){
					currentElt = currentElt.getNeighboor();
				}
				//else create new neighboor
				else{
					currentElt.setNeighboor(new CharNode(line.charAt(k)));
					currentElt = currentElt.getNeighboor();
					k++;
					check = false;
				}
			}
			
			//after create new neighboor fill the rest of the branch
			for(int j = k; j < line.length(); ++j){
				currentElt.setChild(new CharNode(line.charAt(j)));
				currentElt = currentElt.getChild();
			}
		}
		//else (when it's the first word on the three)
		else{
			currentElt = new CharNode(line.charAt(0));
			firstElt = currentElt;
			for (int j = 1; j < line.length(); ++j){
				currentElt.setChild(new CharNode(line.charAt(j)));
				currentElt = currentElt.getChild();
			}
		}
		
		//write the marker "fin" can be replace for a String like the full word for example
		if(currentElt.getChild() == null){
			currentElt.setChild(new CharNode("fin"));
		}
		//in case of a word is shorter than another he place the end message in neighboor
		else{
			while(currentElt.getNeighboor() != null){
				currentElt = currentElt.getNeighboor();
			}
			currentElt.setNeighboor(new CharNode("fin"));
		}
		
		//RAZ of cursor
		currentElt = firstElt;
	}
	
	/**
	* @param String s : word to look for
	* @return String : return null if he don't find the word, return the String stock on the structure if he find (in our case "fin")
	* @brief check if the word is in the three
	**/
	public String findWord(String s){
		int k = 0;
		boolean check = true;
		currentElt = firstElt;

		//while break with return
		while(check){			
			if(k < s.length() && currentElt.getCurrent() == Character.toLowerCase(s.charAt(k))){
				currentElt = currentElt.getChild();
				k++;
			}
			else if(k < s.length() && currentElt.getCurrent() != Character.toLowerCase(s.charAt(k)) && currentElt.getNeighboor() != null){
				currentElt = currentElt.getNeighboor();
			}
			else if(k == s.length() && currentElt.getFinalString() != null){
				return currentElt.getFinalString();
			}
			else if(k == s.length() && currentElt.getFinalString() == null){
				while (currentElt.getFinalString() == null && currentElt.getNeighboor() != null){
					currentElt = currentElt.getNeighboor();
				}
				if(currentElt.getFinalString() != null)
					return currentElt.getFinalString();
				else
					return null;
			}
			else{
				return null;
			}
		}
		return null;
	}
}

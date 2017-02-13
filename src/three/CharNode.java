package three;

/**
 * 
 * @author kelkun
 * @brief node for a chain list
 * @detail a node is represant by a character, and he know is neighboor and is child
 * 
 */
public class CharNode {
	
	//Variables
	private boolean isInit = false;
	//Charactère courrant
	private char current;
	//Fils et frère du charactère courrant
	private CharNode child = null;
	private CharNode neighboor = null;
	//retourne le mot complet (pour les besoins d'un projet, possible de mettre un int dans le but d'une tokemisation)
	private String finalString = null;
	
	/**
	 * @brief constructor for a node
	 * @param c character of new node
	 */
	CharNode(char c){
		this.current = c;
	}
	
	/**
	 * @brief constructor for the last node of the list
	 * @param s
	 */
	CharNode(String s){
		this.finalString = s;
		this.current = '.';
	}

	/**
	 * @return the isInit
	 */
	public boolean isInit() {
		return isInit;
	}

	/**
	 * @param isInit the isInit to set
	 */
	public void setInit(boolean isInit) {
		this.isInit = isInit;
	}

	/**
	 * @return the child
	 */
	public CharNode getChild() {
		return child;
	}

	/**
	 * @return the finalString
	 */
	public String getFinalString() {
		return finalString;
	}

	/**
	 * @param finalString the finalString to set
	 */
	public void setFinalString(String finalString) {
		this.finalString = finalString;
	}

	/**
	 * @param child the child to set
	 */
	public void setChild(CharNode child) {
		this.child = child;
	}

	/**
	 * @return the neighboor
	 */
	public CharNode getNeighboor() {
		return neighboor;
	}

	/**
	 * @param neighboor the neighboor to set
	 */
	public void setNeighboor(CharNode neighboor) {
		this.neighboor = neighboor;
	}

	/**
	 * @return the current
	 */
	public char getCurrent() {
		return current;
	}
}

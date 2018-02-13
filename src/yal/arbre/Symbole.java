package yal.arbre;

public class Symbole {

	private int deplacement;
	
	public Symbole(int i){
		deplacement = i;
	}
	
	public int getDeplacement(){
		return deplacement;
	}

	public void setDeplacement() {
		deplacement = deplacement-4;
	}
}

package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {
    
    public ConstanteBool(String texte, int n) {
        super(texte, n) ;
    }

	@Override
	public boolean verifier() {
		return true;
		
	}

	@Override
	public String toMIPS() {
		StringBuilder rep = new StringBuilder();
		if(cste.equals("vrai")) {
			rep.append("li $v0, 1 \n");
		} else {
			rep.append("li $v0, 0 \n");
		}
		return rep.toString();
	}

	@Override
	public boolean estEntier() {
		return false;
	}

	@Override
	public boolean estBooleen() {
		// TODO Auto-generated method stub
		return false;
	}
}

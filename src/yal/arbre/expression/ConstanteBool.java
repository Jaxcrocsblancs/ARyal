package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

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
	public void verifier() {

	}

	@Override
	public String toMIPS() {
		StringBuilder res = new StringBuilder();
		if(this.cste.equals("vrai")){
			res.append("li $v0, 1\n");
		}
		else if(this.cste.equals("faux")) {
			res.append("li $v0, 0\n");
		}
		return res.toString();
	}

}

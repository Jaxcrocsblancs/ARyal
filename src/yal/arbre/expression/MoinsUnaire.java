package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class MoinsUnaire extends Unaire {
    
    public MoinsUnaire(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return "- " ;
    }

	@Override
	public void verifier() {
		if(!expression.estEntier()) {
			throw new AnalyseSemantiqueException(this.getNoLigne(),"l'expression doit etre entiere.");
		}
	}

	@Override
	public String toMIPS() { 
		StringBuilder res = new StringBuilder();
		res.append(expression.toMIPS());
		res.append("sub $v0, $zero, $v0\n");
		return res.toString();
	}
	
	public boolean estEntier() {
    	return true;
    }
    
    public boolean estBooleen() {
    	return false;
    }
}

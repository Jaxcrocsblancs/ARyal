package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class NonLogique extends Unaire {
    
    public NonLogique(Expression expr) {
        super(expr);
    }

    @Override
    public String operateur() {
        return " non " ;
    }

	@Override
	public void verifier() {
		if(!expression.estBooleen()){
			throw new AnalyseSemantiqueException(this.getNoLigne()," les deux opérandes doivent être booléenne");
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder res = new StringBuilder();	
		res.append(expression.toMIPS() + "\n");
		res.append("xori $v0, $v0, 1 \n");
		return res.toString();
	}

	public boolean estEntier() {
    	return false;
    }
    
    public boolean estBooleen() {
    	return true;
    }
}

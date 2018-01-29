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
		if(expression.getTypeCste() != "bool"){
			throw new AnalyseSemantiqueException("L'expression doit être de type Boolean");
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder res = new StringBuilder();	
		res.append(expression.toMIPS() + "\n");
		res.append("xori $v0, $v0, 1 \n");
		return res.toString();
	}

}

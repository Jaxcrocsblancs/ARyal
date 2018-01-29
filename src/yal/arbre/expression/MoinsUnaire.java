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
		if(!(expression.getTypeCste() == "int") ){
			throw new AnalyseSemantiqueException("l'expressions doit être un entier");
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder res = new StringBuilder();
		res.append("li $v0, 0 \n");
		res.append("sw $v0, ($sp) \n");
		res.append("addi $sp, $sp, -4 \n");
		res.append(expression.toMIPS()+ "\n");
		res.append("addi $sp, $sp, 4 \n");
		res.append("lw $t8, ($sp) \n");
		res.append("sub $v0, $t8, $v0 \n");
		res.append("sw $v0, ($sp) \n");
		return res.toString();
	}

}

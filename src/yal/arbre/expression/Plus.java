package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Plus extends BinaireArithmetique {

    public Plus(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " + " ;
    }

	@Override
	public String toMIPS() {
		StringBuilder res = new StringBuilder();
		res.append(gauche.toMIPS()+"\n");
		res.append("sw $v0, 0($sp) \n");
		res.append("add $sp, $sp, -4 \n");
		res.append(droite.toMIPS()+"\n");
		res.append("sw $v0, 0($sp) \n");
		res.append("add $sp, $sp, 4 \n");
		res.append("lw $t8, 0($sp) \n");
		res.append("add $v0, $t8, $v0\n ");
		return res.toString();
	}
}

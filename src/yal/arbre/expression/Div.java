package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;
import yal.exceptions.AnalyseSyntaxiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Div extends BinaireArithmetique {

    public Div(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " / ";
    }

	@Override
	public void verifier() {
		if(!(gauche.getTypeCste() == "int") || !(droite.getTypeCste() == "int")){
			throw new AnalyseSemantiqueException("les deux expressions doivents être des entiers");
		}
		else if(droite.toString().equals("0")) {
			throw new AnalyseSemantiqueException("l'expression de droite ne peut pas être 0");
		}
	}

	@Override
	public String toMIPS() {
		StringBuilder res = new StringBuilder();
		res.append(gauche.toMIPS()+ " \n");
		res.append("sw $v0, ($sp) \n");
		res.append("addi $sp, $sp, -4 \n");
		res.append(droite.toMIPS()+ " \n");
		res.append("addi $sp, $sp, 4 \n");
		res.append("lw $t8, ($sp) \n");
		res.append("div $v0, $t8, $v0 \n");
		res.append("sw $v0, ($sp) \n");
		return res.toString();
	}
    
}

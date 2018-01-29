package yal.arbre.expression;

import yal.arbre.ArbreAbstrait;
import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Superieur extends Comparaison {

    public Superieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " > ";
    }

	@Override
	public void verifier() {
		if(!(gauche.getTypeCste() == "int") || !(droite.getTypeCste() == "int")){
			throw new AnalyseSemantiqueException("les deux expressions doivents être des entiers");
		}
	}

	@Override
	public String toMIPS() {
		int no = ArbreAbstrait.getNoCondition();
		StringBuilder res = new StringBuilder();
		res.append(gauche.toMIPS()+ "\n");
		res.append("sw $v0, ($sp) \n");
		res.append("addi $sp, $sp, -4 \n");
		res.append(droite.toMIPS()+ "\n");
		res.append("addi $sp, $sp, 4 \n");
		res.append("lw $t8, ($sp) \n");
		res.append("sub $v0, $t8, $v0 \n");
		res.append("bgtz $v0, Sup"+no+ "\n");
		res.append("Inf"+no+": \n");
		res.append("li $v0, 0 \n");
		res.append("b Fin"+no+ "\n");
		res.append("Sup"+no+": \n");
		res.append("li $v0, 1 \n");
		res.append("b Fin"+no+ "\n");
		res.append("Fin"+no+": \n");
		res.append("sw $v0, ($sp) \n");
		return res.toString();
	}
    
}

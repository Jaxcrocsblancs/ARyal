package yal.arbre.expression;

import yal.arbre.Compteur;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Inferieur extends Comparaison {

    public Inferieur(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " < ";
    }

	@Override
	public String toMIPS() {
		int no = Compteur.getInstance().getNoCondi();
		StringBuilder res = new StringBuilder();
		res.append( gauche.toMIPS()+ "\n");
		res.append( "sw $v0, ($sp) \n");
		res.append( "addi $sp, $sp, -4 \n");
		res.append( droite.toMIPS()+ "\n");
		res.append("addi $sp, $sp, 4 \n");
		res.append( "lw $t8, ($sp) \n");
		res.append( "sub $v0, $t8, $v0 \n");
		res.append("bltz $v0, Inf"+no+ "\n");
		res.append( "Sup"+no+": \n");
		res.append("li $v0, 0 \n");
		res.append("b Fin"+no+"\n");
		res.append("Inf"+no+": \n");
		res.append("li $v0, 1 \n");
		res.append("b Fin"+no+ "\n");
		res.append("Fin"+no+": \n");
		res.append("sw $v0, ($sp) \n");
		return res.toString();
	}
}

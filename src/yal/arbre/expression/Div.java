package yal.arbre.expression;

import yal.arbre.Compteur;


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
	public boolean verifier() {
		Boolean rep = droite.verifier();
		if(gauche.verifier()==false){
			rep = false;
		}
		return rep;

		
	}

	@Override
	public String toMIPS() {
		int no = Compteur.getInstance().getNoCondi();
		StringBuilder res = new StringBuilder();
		res.append(gauche.toMIPS()+ " \n");
		res.append("sw $v0, ($sp) \n");
		res.append("addi $sp, $sp, -4 \n");
		res.append(droite.toMIPS()+ " \n");
		res.append("bnez $v0 , div" + no + "\n");
        res.append("erreur"+ no + " :\n");
        res.append("li $v0, 4\n");
        res.append("la $a0, err\n");
        res.append("j fincompil\n");
        res.append("div"+ no + " :\n" );
		res.append("addi $sp, $sp, 4 \n");
		res.append("lw $t8, ($sp) \n");
		res.append("div $v0, $t8, $v0 \n");
		res.append("sw $v0, ($sp) \n");
		return res.toString();
	}
}

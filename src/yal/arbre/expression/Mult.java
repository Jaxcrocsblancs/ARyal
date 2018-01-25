package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Mult extends BinaireArithmetique {

    public Mult(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
  
    @Override
    public String operateur() {
        return " * ";
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		StringBuilder res = new StringBuilder();
		res.append(gauche.toMIPS()+ "\n");
		res.append("sw $v0, ($sp) \n");
		res.append("addi $sp, $sp, -4 \n");
		res.append(droite.toMIPS()+ "\n");
		res.append("addi $sp, $sp, 4 \n");
		res.append("lw $t8, ($sp) \n");
		res.append("mult $v0, $t8 \n");
		res.append("mflo $v0 \n");
		res.append("sw $v0, ($sp) \n");
		return res.toString();
	}

}

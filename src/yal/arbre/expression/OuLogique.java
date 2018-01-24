package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class OuLogique extends BinaireLogique {

    public OuLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " ou " ;
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		StringBuilder res = new StringBuilder();
		res.append(gauche.toMIPS() + " \n");
		res.append("sw $v0, ($sp) \n");
		res.append("addi $sp, $sp, -4 \n");
		res.append(droite.toMIPS() + " \n");
		res.append("addi $sp, $sp, 4 \n");
		res.append("lw $t8, ($sp) \n");
		res.append("or $v0, $v0, $t8 \n");
		return null;
	}

}
package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Moins extends BinaireArithmetique {

    public Moins(Expression gauche, Expression droite) {
        super(gauche, droite);
    }

    @Override
    public String operateur() {
        return " - ";
    }

	@Override
	public String toMIPS() {
		StringBuilder res = new StringBuilder();
		res.append(gauche.toMIPS()+"\n");
		res.append("sw $v0, 0($sp) \n");
		res.append("sub $sp, $sp, -4 \n");
		res.append(droite.toMIPS()+"\n");
		res.append("sw $v0, 0($sp) \n");
		res.append("sub $sp, $sp, 4 \n");
		res.append("lw $t8, 0($sp) \n");
		res.append("sub $v0, $t8, $v0\n");
		return res.toString();
	}

}

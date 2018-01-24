package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteEntiere extends Constante {
    
    public ConstanteEntiere(String texte, int n) {
        super(texte, n) ;
    }

	@Override
	public void verifier() {

	}

	@Override
	public String toMIPS() {
		StringBuilder res = new StringBuilder();
		res.append("li $v0"+this.cste+"\n");
		return res.toString();
	}

}

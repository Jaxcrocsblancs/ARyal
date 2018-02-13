package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class EtLogique extends BinaireLogique {

    public EtLogique(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " et " ;
    }

	@Override
	public void verifier() {
		if(!gauche.estBooleen() || !droite.estBooleen()){
			throw new AnalyseSemantiqueException(this.getNoLigne()," les deux opérandes doivent être booléenne");
		}
		
	}

	@Override
	public String toMIPS() {
		StringBuilder res = new StringBuilder();
		res.append(gauche.toMIPS() + "\n");
		res.append("sw $v0, ($sp) \n");
		res.append("addi $sp, $sp, -4 \n");
		res.append(droite.toMIPS() + "\n");
		res.append("addi $sp, $sp, 4 \n");
		res.append("lw $t8, ($sp) \n");
		res.append("and $v0, $v0, $t8 \n");
		return res.toString();
	}
}

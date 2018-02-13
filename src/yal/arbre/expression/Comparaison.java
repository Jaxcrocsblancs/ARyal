package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Comparaison extends Binaire {
     
    protected Comparaison(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    
    public boolean estEntier() {
    	return false;
    }
    
    public boolean estBooleen() {
    	return true;
    }

	public void verifier() {
		if((gauche.estEntier() && !droite.estEntier()) || (droite.estEntier() && !gauche.estEntier())) {
			throw new AnalyseSemantiqueException(this.getNoLigne(), "les deux expressions doivent etre de meme type");
		}
	}
}

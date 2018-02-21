package yal.arbre.expression;

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

	public boolean verifier() {
		if((gauche.estEntier() && !droite.estEntier()) || (droite.estEntier() && !gauche.estEntier())) {
			printErreur("les deux expressions doivent etre de meme type");
			return false;
		}
		return true;
	}
}

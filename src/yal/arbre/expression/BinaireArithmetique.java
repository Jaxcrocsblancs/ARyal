package yal.arbre.expression;

import yal.exceptions.AnalyseSemantiqueException;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    public void verifier(){
    	droite.verifier();
		gauche.verifier();
    	if(!gauche.estEntier() || !droite.estEntier()){
			throw new AnalyseSemantiqueException(this.getNoLigne()," les deux opérandes doivent être entière");
		}
    }
   
    public boolean estEntier() {
    	return true;
    }
    
    public boolean estBooleen() {
    	return false;
    }
    
}

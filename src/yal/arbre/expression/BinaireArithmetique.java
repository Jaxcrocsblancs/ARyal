package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class BinaireArithmetique extends Binaire {

    protected BinaireArithmetique(Expression gauche, Expression droite) {
        super(gauche, droite) ;
    }
    
    public boolean verifier(){
    	droite.verifier();
		gauche.verifier();
    	if(!gauche.estEntier() || !droite.estEntier()){
    		printErreur(" les deux opérandes doivent être entière");
    		return false;
    	}
    	return true;
    }
   
    public boolean estEntier() {
    	return true;
    }
    
    public boolean estBooleen() {
    	return false;
    }
    
}

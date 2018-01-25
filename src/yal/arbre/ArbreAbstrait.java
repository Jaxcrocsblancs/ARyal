package yal.arbre;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {
    
    // numéro de ligne du début de l'instruction
    protected int noLigne ;
    protected static int noCondition;
    
    public static int getNoCondition() {
		return noCondition;
	}

	public static void setNoCondition() {
		ArbreAbstrait.noCondition += 1;
	}

	protected ArbreAbstrait(int no) {
        noLigne = no ;
    }
    
    public int getNoLigne() {
            return noLigne ;
    }

    public abstract void verifier() ; 
    public abstract String toMIPS() ; 

}

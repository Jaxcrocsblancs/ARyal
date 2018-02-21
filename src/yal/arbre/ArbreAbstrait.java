package yal.arbre;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class ArbreAbstrait {
    
    // numéro de ligne du début de l'instruction
    protected int noLigne ;

	protected ArbreAbstrait(int no) {
        noLigne = no ;
    }
    
    public int getNoLigne() {
            return noLigne ;
    }


	public abstract boolean verifier();
    
    public abstract String toMIPS();
    
    public void printErreur(String erreur){
    	System.out.println("ERREUR SEMANTIQUE :\n\tligne " + this.getNoLigne() + "\n\t : " + erreur );
    }
}

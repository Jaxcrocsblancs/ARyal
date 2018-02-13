package yal.arbre.expression;

import yal.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Expression extends ArbreAbstrait {
    
    protected Expression(int n) {
        super(n) ;
    }
    
    public abstract boolean estBooleen();
    
    public abstract boolean estEntier();   
    
    public String getType() {
    	String res = "";
    	if(this.estBooleen()) {
    		res = "booleen";
    	} else if (this.estEntier()) {
    		res = "entier";
    	}
    	return res;
    }

	public boolean estConstant() {
		return false;
	}
}

package yal.arbre.expression;

import yal.arbre.ArbreAbstrait;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Expression extends ArbreAbstrait {
	protected String typeCste;
    public String getTypeCste() {
		return typeCste;
	}
    
    protected Expression(int n) {
        super(n) ;
    }
}

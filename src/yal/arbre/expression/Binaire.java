package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Binaire extends Expression {
    
    protected Expression gauche ;
    protected Expression droite ;

    protected Binaire(Expression gauche, Expression droite) {
        super(gauche.getNoLigne());
        this.gauche = gauche;
        this.droite = droite;
    }
    
    public boolean verifier(){
    	return true;
    }
    public abstract String operateur() ;

    
    
    public String toString() {
        return "(" + gauche + operateur() + droite + ")" ;
    }
    

    

}

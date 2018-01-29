package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public abstract class Constante extends Expression {

    protected String cste ;

	protected Constante(String texte, int n) {
        super(n) ;
        cste = texte ;
        if(texte == "vrai" || texte == "faux"){
        	this.typeCste = "bool";
        }
        else if(estUnEntier(texte)){
        	this.typeCste = "int";
        }
    }
    
    private boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e){
			return false;
		}
 
		return true;
	}
    
   

    public String toString() {
        return cste ;
    }
 }

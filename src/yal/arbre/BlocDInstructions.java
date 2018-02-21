package yal.arbre;

import java.util.ArrayList;

/**
 * 3 déc. 2015
 *
 */

public class BlocDInstructions extends ArbreAbstrait {
    
    protected ArrayList<ArbreAbstrait> expr ;
    
    public BlocDInstructions(int n) {
        super(n) ;
        this.expr = new ArrayList<ArbreAbstrait>();
    }
    
    public void ajouter(ArbreAbstrait a) {
    	if(a != null){
    		expr.add(a);
    	}
    }
    
    
    @Override
    public String toString() {
        return expr.toString() ;
    }

	@Override
	public boolean verifier() {
		boolean rep = true;
		for(ArbreAbstrait a : this.expr) {
			if(a.verifier()==false){
				rep=false;
			}
		}
		return rep;
	}

	@Override
	public String toMIPS() {
		String res = "";
		for(int i = 0;i<expr.size();i++){
			res += expr.get(i).toMIPS();
		}
		return res;
	}

}

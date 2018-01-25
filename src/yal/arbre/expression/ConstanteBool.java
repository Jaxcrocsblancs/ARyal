package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class ConstanteBool extends Constante {
    
    public ConstanteBool(String texte, int n) {
        super(texte, n) ;
    }

	@Override
	public void verifier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toMIPS() {
		StringBuilder res = new StringBuilder();
		if(this.cste.equals("vrai")){
			System.out.println("LOLOLOLOLOLO");
			res.append("li $v0, 1\n");
		}
		else if(this.cste.equals("faux")) {
			System.out.println("zerazerzaerazerzaerzae");
			res.append("li $v0, 0\n");
		}
		else{
			System.out.println("MARCHE PAS");
		}
		return res.toString();
	}

}

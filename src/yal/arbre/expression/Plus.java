package yal.arbre.expression;

/**
 * 3 déc. 2015
 *
 * @author brigitte wrobel-dautcourt
 */

public class Plus extends BinaireArithmetique {

    public Plus(Expression gauche, Expression droite) {
        super(gauche, droite);
    }
    
    @Override
    public String operateur() {
        return " + " ;
    }

	@Override
	public void verifier() {
		
	}

	@Override
	public String toMIPS() {
		StringBuilder plus = new StringBuilder();
		if(droite.isConstante()){
			plus+= gauche.toMIPS()+ "\n";
			plus+= "move $t8, $v0"+ "\n";
			plus+= droite.toMIPS() +  "\n";
			plus+= "add $v0, $t8, $v0"+ "\n";
			plus+= "sw $v0, ($sp)"+ "\n";
		}else{
			plus+= gauche.toMIPS()+ "\n";
			plus+= "sw $v0, ($sp)"+ "\n";
			plus+= "addi $sp, $sp, -4"+ "\n";
			plus+= droite.toMIPS()+ "\n";
			plus+= "addi $sp, $sp, 4"+ "\n";
			plus+= "lw $t8, ($sp)"+ "\n";
			plus+= "add $v0, $t8, $v0"+ "\n";
			plus+= "sw $v0, ($sp)"+ "\n";
		}
		return plus;
		return null;
	}

}

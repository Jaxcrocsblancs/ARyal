package yal.arbre.instruction;

import yal.arbre.ArbreAbstrait;
import yal.arbre.expression.Variable;

public class LireExpression extends ArbreAbstrait{
	protected Variable variable;
	
	public LireExpression(Variable var, int no) {
		super(no);
		variable = var;
	}

	@Override
	public boolean verifier() {
		Boolean rep = variable.verifier();
		return rep;
	}

	@Override
	public String toMIPS() {
		StringBuilder rep = new StringBuilder();
		rep.append("li $v0 , 5 \n");
		rep.append("syscall \n");
		rep.append("sw $v0, " + variable.getDeplacement() + "($s7)\n");
		return rep.toString();
	}

}

package yal.arbre.instruction;

import yal.arbre.ArbreAbstrait;
import yal.arbre.expression.Expression;
import yal.arbre.expression.Variable;

public class Affectation extends ArbreAbstrait
{
	protected Variable variable;
	protected Expression expression;

	public Affectation(Variable var, Expression exp, int n)
	{
		super(n);
		variable = var;
		expression = exp;
	}
	
	public boolean verifier()
	{
		Boolean rep = variable.verifier();
		if(expression.verifier()==false){
			return false;
		}
		if (!((expression.estEntier() == variable.estEntier()) && (expression.estBooleen() == variable.estBooleen())))
		{
			printErreur("Impossible de faire l'affectation l'expression et la variable ne sont pas de même type");
			return false;
		}
		return rep;
	}

	public String toMIPS()
    {
    	StringBuilder rep = new StringBuilder();
    	rep.append(expression.toMIPS());
    	rep.append("sw $v0, " + variable.getDeplacement() + "($s7)\n");
    	return rep.toString();
    }
}

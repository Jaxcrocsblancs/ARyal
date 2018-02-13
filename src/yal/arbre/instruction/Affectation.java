package yal.arbre.instruction;

import yal.arbre.ArbreAbstrait;
import yal.arbre.expression.Expression;
import yal.arbre.expression.Variable;
import yal.exceptions.AnalyseSemantiqueException;

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
	
	public void verifier()
	{
		
		variable.verifier();
		expression.verifier();
		if (!((expression.estEntier() == variable.estEntier()) && (expression.estBooleen() == variable.estBooleen())))
		{
			System.out.println(!(expression.estEntier() && variable.estEntier()));
			System.out.println(!(expression.estBooleen() && variable.estBooleen()));
			throw new AnalyseSemantiqueException(this.getNoLigne(),"Impossible de faire l'affectation l'expression et la variable ne sont pas de même type");
		}
	}

	public String toMIPS()
    {
    	StringBuilder sb = new StringBuilder();
    	sb.append(expression.toMIPS());
    	sb.append("sw $v0, " + variable.getDeplacement().getDeplacement() + "($s7)\n");
    	return sb.toString();
    }
}

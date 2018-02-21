package yal.arbre.instruction;

import yal.arbre.Compteur;
import yal.arbre.expression.Expression;

public class EcrireExpression extends Ecrire
{
	private Expression expression;
	
	public EcrireExpression(int n, Expression exp)
	{
		super(n);
		expression = exp;
	}

	@Override
	public String toMIPS()
	{
		int no = Compteur.getInstance().getNoCondi();
		StringBuilder rep = new StringBuilder();
		rep.append(expression.toMIPS());
		if (expression.estEntier())
		{
			rep.append("move $a0, $v0\n");
			rep.append("li $v0 , 1\n");
		}
		else if(expression.estBooleen())
		{
			rep.append("beqz $v0, sinon" + no + "\n");
			rep.append("alors" + no + ":\n");
			rep.append("li $v0, 4\n");
			rep.append("la $a0, strV \n");
			rep.append("j fin" + no + " \n");
			rep.append("sinon" + no + ": \n");
			rep.append("li $v0, 4\n");
			rep.append("la $a0, strF \n");
			rep.append("fin" + no + ": \n");
		}
		rep.append("syscall\n");
		return rep.toString();
	}
	
	@Override
	public boolean verifier()
	{
		return expression.verifier();
	}
}

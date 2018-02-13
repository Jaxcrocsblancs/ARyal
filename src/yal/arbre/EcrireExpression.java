package yal.arbre;

import yal.arbre.expression.Expression;

public class EcrireExpression extends Ecrire
{
	protected Expression exp;
	
	public EcrireExpression(int n, Expression e)
	{
		super(n);
		exp = e;
	}

	@Override
	public String toMIPS()
	{
		int no = Compteur.getInstance().getNoCondi();
		StringBuilder rep = new StringBuilder();
		rep.append(exp.toMIPS());
		if (exp.estBooleen())
		{
			rep.append("beqz $v0, sinon" + no + "\n");
			rep.append("alors" + no + ":\n");
			rep.append("li $v0, 4\n");
			rep.append("la $a0, strVrai \n");
			rep.append("j fin" + no + " \n");
			rep.append("sinon" + no + ": \n");
			rep.append("li $v0, 4\n");
			rep.append("la $a0, strFaux \n");
			rep.append("fin" + no + ": \n");
		}
		else
		{
			rep.append("move $a0, $v0\n");
			rep.append("li $v0 , 1\n");
		}
		rep.append("syscall\n");
		return rep.toString();
	}
	
	@Override
	public void verifier()
	{
		exp.verifier();
	}
}

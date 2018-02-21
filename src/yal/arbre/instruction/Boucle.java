package yal.arbre.instruction;

import yal.arbre.ArbreAbstrait;
import yal.arbre.BlocDInstructions;
import yal.arbre.Compteur;
import yal.arbre.expression.Expression;

public class Boucle extends ArbreAbstrait{
	protected Expression expression;
	protected BlocDInstructions test;
	public Boucle(Expression e, BlocDInstructions l, int no)  {
		super(no);
		expression =e;
		test = l;
	}

	@Override
	public boolean verifier() {
		if(!expression.estBooleen()){
			return false;
		}
		return true;
	}

	@Override
	public String toMIPS() {
		System.out.println("boucle");
		int no = Compteur.getInstance().getNoCondi();
		StringBuilder rep = new StringBuilder();
		rep.append("tantque"+no+":\n");
		rep.append(expression.toMIPS()+"\n");
		rep.append("beqz $v0, fintantque"+no+"\n");
		rep.append("repeter"+no+":\n");
		rep.append(test.toMIPS());
		rep.append("j tantque"+no+"\n");
		rep.append("fintantque"+no+":\n");	

		return rep.toString();
	}

}

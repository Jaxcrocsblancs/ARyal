package yal.arbre.instruction;

import yal.arbre.ArbreAbstrait;
import yal.arbre.BlocDInstructions;
import yal.arbre.Compteur;
import yal.arbre.expression.Expression;

public class Condition extends ArbreAbstrait{
	protected Expression expression;
	protected BlocDInstructions si;
	protected BlocDInstructions sinon;
	
	public Condition(Expression e, BlocDInstructions l, BlocDInstructions ls, int no) {
		super(no);
		expression = e;
		si = l;
		sinon = ls;
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
		int no = Compteur.getInstance().getNoCondi();
		StringBuilder rep = new StringBuilder();
		rep.append("si"+no+":\n");
		rep.append(expression.toMIPS()+"\n");
		rep.append("beqz $v0, sinon"+no+"\n");
		rep.append("alors"+no+":\n");
		rep.append(si.toMIPS());
		rep.append("b finsi"+no+"\n");
		rep.append("sinon"+no+":\n");	
		if(sinon!=null){
			rep.append(sinon.toMIPS());
		}
		rep.append("finsi"+no+":\n");	
		return rep.toString();
	}
	

}

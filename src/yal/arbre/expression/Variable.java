package yal.arbre.expression;

import yal.arbre.Symbole;
import yal.arbre.TableDesSymboles;

/**
 * @author Fousse Ronan
 * @author Losson Brice
 * @author Collignon Valentin
 * @version 08 Février 2018
 */
public class Variable extends Expression
{
	private String identifiant;
	private Symbole deplacement;
	
	public Symbole getDeplacement() {
		return deplacement;
	}

	public Variable(int n, String s)
	{
		super(n);
		identifiant = s;
		deplacement = TableDesSymboles.getInstance().indentifer(identifiant);
	}

	public void verifier()
	{
		
	}

	public String toMIPS()
	{
		return "lw $v0, " + deplacement.getDeplacement() + "($s7)\n";
	}

	public boolean estBooleen() {
		return false;
	}

	public boolean estEntier() {
		return true;
	}
}

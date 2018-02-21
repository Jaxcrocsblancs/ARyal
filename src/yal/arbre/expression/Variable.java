package yal.arbre.expression;

import yal.arbre.TableDesSymboles;

public class Variable extends Expression
{
	private String identifiant;
	private int deplacement;
	
	public int getDeplacement() {
		return deplacement;
	}

	public Variable(int n, String s)
	{
		super(n);
		identifiant = s;
		deplacement = TableDesSymboles.getInstance().indentifer(identifiant);
		System.out.println("nom:"+s+" Deplacement: "+deplacement);
	}

	public boolean verifier()
	{
		return true;
	}

	public String toMIPS()
	{
		return "lw $v0, " + deplacement+ "($s7)\n";
	}

	public boolean estBooleen() {
		return false;
	}

	public boolean estEntier() {
		return true;
	}
}

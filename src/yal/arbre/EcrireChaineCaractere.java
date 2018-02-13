package yal.arbre;


public class EcrireChaineCaractere extends Ecrire
{
	protected String chaineCaractere;
	
	public EcrireChaineCaractere(int n, String c)
	{
		super(n);
		chaineCaractere = c;
	}
	
	@Override
	public String toMIPS()
	{
		int no = Compteur.getInstance().getNoCondi();
		StringBuilder rep = new StringBuilder();
		rep.append(".data\n");
		rep.append("str" + no + ": .asciiz " + chaineCaractere + "\n");
		rep.append(".text\n");
		rep.append("li $v0, 4\n");
		rep.append("la $a0, str" + no + "\n");
		rep.append("syscall\n");
		return rep.toString();
	}
	
	@Override
	public void verifier()
	{
	}
}

package yal.arbre.instruction;

import yal.arbre.Compteur;


public class EcrireChaineCaractere extends Ecrire
{
	private String chaineCaractere;
	
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
		String nChaine= "";
		nChaine+='"';
		for (int i=1; i<chaineCaractere.length()-1; i++){
			if(chaineCaractere.charAt(i)=='"'){
				nChaine+="\\";
				nChaine+="\"";
			}
			else{
				nChaine+=chaineCaractere.charAt(i);
			}
			
		}
		nChaine+='"';
		rep.append(".data\n");
		rep.append("str" + no + ": .asciiz " + nChaine.toString() + "\n");
		rep.append(".text\n");
		rep.append("li $v0, 4\n");
		rep.append("la $a0, str" + no + "\n");
		rep.append("syscall\n");
		return rep.toString();
	}
	
	@Override
	public boolean verifier()
	{
		return true;
	}
}

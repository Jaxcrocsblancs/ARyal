package yal.arbre;

import java.util.HashMap;
import yal.exceptions.AnalyseSyntaxiqueException;

public class TableDesSymboles
{
	private static TableDesSymboles instance = new TableDesSymboles();
	private HashMap<String, Integer> table;
	private Symbole sym;
	
	private TableDesSymboles()
	{
		table = new HashMap<>();
		sym = new Symbole(0);
	}
	
	public static TableDesSymboles getInstance()
	{
		return instance;
	}
	
	public void ajouter(String idf)
	{
		if (table.containsKey(idf))
		{
			throw new AnalyseSyntaxiqueException("La variable"+idf+"est déjà utilisée");
		}
		table.put(idf, sym.getDeplacement());
		sym.setDeplacement();
	}
	
	public Symbole indentifer(String entree)
	{
		return sym;
	}
	
	public int getSize()
	{
		return table.size();
	}
}

package yal.arbre;

import java.util.HashMap;
import yal.exceptions.AnalyseSyntaxiqueException;

public class TableDesSymboles
{
	private static TableDesSymboles instance = new TableDesSymboles();
	private HashMap<String, Integer> table;
	
	private TableDesSymboles()
	{
		table = new HashMap<>();
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
		table.put(idf, table.size()*(-4)-4);
	}
	
	public int indentifer(String entree)
	{
		return table.get(entree);
	}
	
	public int getSize()
	{
		return table.size();
	}
}

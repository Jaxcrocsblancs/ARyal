package yal.exceptions;

public class AnalyseSemantiqueException extends AnalyseException{

	public AnalyseSemantiqueException(String m) {
		 super("ERREUR SYNTAXIQUE :\n\t" + m) ;
	}

}

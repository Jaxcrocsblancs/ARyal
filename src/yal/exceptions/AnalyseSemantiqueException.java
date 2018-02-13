package yal.exceptions;

public class AnalyseSemantiqueException extends AnalyseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnalyseSemantiqueException(int ligne, String m) {
        super("ERREUR SEMANTIQUE :\n\tligne " + ligne + "\n\t : " + m) ;
    }

}

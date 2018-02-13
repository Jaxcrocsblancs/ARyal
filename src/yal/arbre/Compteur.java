package yal.arbre;

public class Compteur {

	protected int noCondi = 0;
	    
	/** Constructeur privé */
    private Compteur()
    {}
 
    /** Instance unique pré-initialisée */
    private static Compteur INSTANCE = new Compteur();
     
    /** Point d'accès pour l'instance unique du singleton */
    public static Compteur getInstance()
    {  
    	return INSTANCE;
    }
	
	public int getNoCondi() {
	    this.setNoCondi();
		return noCondi;
	}
	
	public void setNoCondi() {
		this.noCondi ++;
	}
	
	
}

package yal ;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import yal.analyse.AnalyseurLexical;
import yal.analyse.AnalyseurSyntaxique;
import yal.arbre.ArbreAbstrait;
import yal.exceptions.AnalyseException;

public class Yal {
    
    public Yal(String fichier) {
        try {
            AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(new AnalyseurLexical(new FileReader(fichier)));
            ArbreAbstrait arbre = (ArbreAbstrait) analyseur.parse().value;
            if(arbre.verifier()){
	        	try{
	        		String tfichier = fichier.replace(".yal","");
	    			FileWriter flot = new FileWriter(tfichier+".mips");
	    			BufferedWriter flotFilter = new BufferedWriter(flot);
	    			flotFilter.write(".data\n");
	    	        flotFilter.write("err: .asciiz \"ERREUR EXECUTION\"\n");
	    	        flotFilter.write("strV: .asciiz \" vrai\"\n");
	    	        flotFilter.write("strF: .asciiz \" faux\"\n");
	    	        flotFilter.write(".text\n");
	    	        flotFilter.write("main :\n");
	    			flotFilter.write(arbre.toMIPS());
	    			flotFilter.write("\nend : \n");
	    			flotFilter.write("move $v1, $v0 \n");
	    			flotFilter.write("li $v0, 10 \n");
	    			flotFilter.write("fincompil :\n");
	    			flotFilter.write("syscall \n");
	    			flotFilter.close();
	    			System.out.println("COMPILATION OK");
	    		}catch(IOException e){ System.out.println("erreur catch");}
            }
            else{
            	try{
	        		String tfichier = fichier.replace(".yal","");
	    			FileWriter flot = new FileWriter(tfichier+".mips");
	    			BufferedWriter flotFilter = new BufferedWriter(flot);
	    			flotFilter.write(".data\n");
	    	        flotFilter.write("err: .asciiz \"ERREUR EXECUTION\"\n");
	    	        flotFilter.write("strV: .asciiz \" vrai\"\n");
	    	        flotFilter.write("strF: .asciiz \" faux\"\n");
	    	        flotFilter.write(".text\n");
	    	        flotFilter.write("main :\n");
	    	        flotFilter.write("li $v0, 4\n");
	    	        flotFilter.write("la $a0, err\n");
	    	        flotFilter.write("j fincompil\n");
	    			flotFilter.write("\nend : \n");
	    			flotFilter.write("move $v1, $v0 \n");
	    			flotFilter.write("li $v0, 10 \n");
	    			flotFilter.write("fincompil :\n");
	    			flotFilter.write("syscall \n");
	    			flotFilter.close();
	    			System.out.println("COMPILATION RATE");
	    		}catch(IOException e){ System.out.println("erreur catch");}
            }
            
        } 
        catch (FileNotFoundException ex) {
            System.err.println("Fichier " + fichier + " inexistant") ;
        }
        catch (AnalyseException ex) {
            System.err.println(ex.getMessage());
        }
        catch (Exception ex) {
            Logger.getLogger(Yal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Nombre incorrect d'arguments") ;
            System.err.println("\tjava -jar yal.jar <fichierSource.yal>") ;
            System.exit(1) ;
        }
        new Yal(args[0]) ;
    }
    
}




/*** commande utile
 * java -jar /home/profil/calba5u/Espace-de-depot/projetToucan/java-cup-11a.jar -parser AnalyseurSyntaxique -symbols CodeLexicaux Grammaire.cup
 * java -jar /home/profil/calba5u/Espace-de-depot/projetToucan/jflex-1.6.1.jar AnalyseurLexical.jflex
 */


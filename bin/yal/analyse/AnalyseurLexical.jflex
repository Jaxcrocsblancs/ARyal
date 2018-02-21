package yal.analyse ;

import java_cup.runtime.*;
import yal.exceptions.AnalyseLexicaleException;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

commentaireSlashSlash = [/][/].*

csteE = [0-9]+
csteB = "vrai" | "faux"
finDeLigne = \r|\n
espace = {finDeLigne}  | [ \t\f]
idf = [a-zA-Z][a-zA-Z0-9]*
chaine = \"[.*\"\"]*.*\"

%%
{csteE}      	    	{ return symbol(CodesLexicaux.CONSTANTEINT, yytext()); }
{csteB}      	    	{ return symbol(CodesLexicaux.CONSTANTEBOOL, yytext()); }

"ecrire"				{ return symbol(CodesLexicaux.ECRIRE); }
"entier"				{ return symbol(CodesLexicaux.ENTIER); }
"lire"					{ return symbol(CodesLexicaux.LIRE); }

"tantque"				{ return symbol(CodesLexicaux.TANTQUE); }
"repeter"				{ return symbol(CodesLexicaux.REPETER); }
"fintantque"			{ return symbol(CodesLexicaux.FINTANTQUE); }

"si"					{ return symbol(CodesLexicaux.SI); }
"alors"					{ return symbol(CodesLexicaux.ALORS); }
"sinon"					{ return symbol(CodesLexicaux.SINON); }
"fsi" 					{ return symbol(CodesLexicaux.FSI); }

"programme"           	{ return symbol(CodesLexicaux.PROGRAMME); }
"debut"              	{ return symbol(CodesLexicaux.DEBUT); }
"fin"               	{ return symbol(CodesLexicaux.FIN); }

"="               	 	{ return symbol(CodesLexicaux.EGAL); }

";"						{ return symbol(CodesLexicaux.POINTVIRGULE); }
"+"               	 	{ return symbol(CodesLexicaux.PLUS); }
"-"                		{ return symbol(CodesLexicaux.MOINS); }
"*"                		{ return symbol(CodesLexicaux.MULT); }
"/"                		{ return symbol(CodesLexicaux.DIV); }

"=="               		{ return symbol(CodesLexicaux.EGALEGAL); }
"!="               		{ return symbol(CodesLexicaux.DIFF); }
"<"                		{ return symbol(CodesLexicaux.INF); }
">"                		{ return symbol(CodesLexicaux.SUP); }

"et"               		{ return symbol(CodesLexicaux.ET); }
"ou"                	{ return symbol(CodesLexicaux.OU); }
"non"              		{ return symbol(CodesLexicaux.NON); }

"("                		{ return symbol(CodesLexicaux.PAROUV); }
")"                		{ return symbol(CodesLexicaux.PARFER); }

{idf}					{ return symbol(CodesLexicaux.IDF, yytext()); }
{chaine}				{ return symbol(CodesLexicaux.CHAINECARACTERE, yytext()); }

{espace}                { }

 {commentaireSlashSlash} { }
 
.                       { throw new AnalyseLexicaleException(yyline, yycolumn, yytext()) ; }

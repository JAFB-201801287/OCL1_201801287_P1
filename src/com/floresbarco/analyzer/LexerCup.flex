package com.floresbarco.analyzer;
import java_cup.runtime.Symbol;

%%
/* INICIO */
/*----------------------------------------------------------------------------------------------------------------------------------*/
%public
%class LexerCup
%type java_cup.runtime.Symbol

// ANALIZADOR
%cup
// RETORNA CADENA
%full
// RETORNA LINEA
%line
// RETORNA COLUMNA
%char

/* CONSTANTES */
/*----------------------------------------------------------------------------------------------------------------------------------*/

// ACEPTA PALABRAS CON MAYUSCULAS Y MINUSCULAS
LETTER = [a-zA-Z_]

// ACEPTA NUMEROS ENTEROS
DIGIT = [0-9]

//  ACEPTA ESPACIOS Y SALTOS DE LINEA
SPACE = [ \t\r\n]+

/* CODIGO */
/*----------------------------------------------------------------------------------------------------------------------------------*/
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* ELEMENTOS IGNORADOS */
/*----------------------------------------------------------------------------------------------------------------------------------*/

// IGNORAR COMENTARIO MULTILINEA
("<!"[^"<!"|"!>"]*"!>") { /*Ignore*/ }

/* IGNORAR COMENTARIOS */
("//"(.)*) { /*Ignore*/ }

// IGNORAR ESPACIOS EN BLANCO Y SALTOS DE LINEA
{SPACE} { /*Ignore*/ }

/* DEFINIR LEXICO */
/*----------------------------------------------------------------------------------------------------------------------------------*/

("\\n") { return new Symbol(sym.LineBreak, yychar, yyline, yytext()); }

// PALABRA RESERVADA CONJ
("CONJ") { return new Symbol(sym.Conj, yychar, yyline, yytext()); }

/* COMILLAS */
("\\\""|"\\\”"|"\\\“") { return new Symbol(sym.QuotationMarks, yychar, yyline, yytext()); }

/* COMILLAS SIMPLES */
("\\\'"|"\\\‘"|"\\\’") { return new Symbol(sym.SingleQuotes, yychar, yyline, yytext()); }

/* PUNTO */
(".") { return new Symbol(sym.Dot, yychar, yyline, yytext()); }

/* SUMA */
("+") { return new Symbol(sym.Plus, yychar, yyline, yytext()); }

/* ASTERISCO */
("*") { return new Symbol(sym.Asterisk, yychar, yyline, yytext()); }

/* SIGNO DE INTERROGACION */
("?") { return new Symbol(sym.QuestionMarck, yychar, yyline, yytext()); }

/* BARRA VERTICAL */
("|") { return new Symbol(sym.VerticalBar, yychar, yyline, yytext()); }

/* GUION */
("-"|"~") { return new Symbol(sym.Dash, yychar, yyline, yytext()); }

/* COMA */
(",") { return new Symbol(sym.Comma, yychar, yyline, yytext()); }

/* PUNTO Y COMA */
(";") { return new Symbol(sym.Semicolon, yychar, yyline, yytext()); }

/* DOS PUNTOS */
(":") { return new Symbol(sym.Colon, yychar, yyline, yytext()); }

/* LLAVE DE INICIO */
("{") { return new Symbol(sym.CurlyBracket1, yychar, yyline, yytext()); }

/* LLAVE DE CIERRE */
("}") { return new Symbol(sym.CurlyBracket2, yychar, yyline, yytext()); }

/* FLECHA */
("->") { return new Symbol(sym.Arrow, yychar, yyline, yytext()); }

/* PORCENTAJE */
("%%") { return new Symbol(sym.DoublePercent, yychar, yyline, yytext()); }

// DIGITO
({LETTER}) { return new Symbol(sym.Letter, yychar, yyline, yytext()); }

// DIGITO
({DIGIT}) { return new Symbol(sym.Digit, yychar, yyline, yytext()); }

// CADENA DE TEXTO ENCERRADA POR COMILLAS O COMILLAS SIMPLES RUTA
( '([^\']*)'|‘([^\‘]*)’|\"([^\"]*)\"|“([^“]*)” ) { return new Symbol(sym.String, yychar, yyline, yytext()); }

/* CARACTER */
([!-\/]|[:-@]|[\[-\_]|[\{-\~]) { return new Symbol(sym.Character, yychar, yyline, yytext()); }


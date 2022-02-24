package com.floresbarco.analyzer;

import static com.floresbarco.analyzer.Tokens.*;

%%
%public
%class Lexer
%type Tokens

LETTER = [a-zA-Z_]
DIGIT = [0-9]
SPACE = [ ,\t,\r]+

%{
    public String lexeme;
%}
%%

/* Espacios en blanco */
{SPACE} { /*Ignore*/ }

/* COMENTARIO DE UNA LINEA */
("//"(.)*) { /*Ignore*/ }

/* COMENTARI MULTILINEA */
("<!"(.)*"!>") { /*Ignore*/ }

/* SALTO DE LINEA */
("\n") { return Line; }

/* COJUNTO */
("CONJ") { return Conj; }

/* COMILLAS */
("\"") { return QuotationMarks; }

/* COMILLAS SIMPLES */
("\'") { return SingleQuotes; }

/* PUNTO */
(".") { return Dot; }

/* SUMA */
("+") { return Plus; }

/* ASTERISCO */
("*") { return Asterisk; }

/* SIGNO DE INTERROGACION */
("?") { return QuestionMarck; }

/* BARRA VERTICAL */
("|") { return VerticalBar; }

/* GUION */
("-") { return Dash; }

/* COMA */
(",") { return Comma; }

/* PUNTO Y COMA */
(";") { return Semicolon; }

/* DOS PUNTOS */
(":") { return Colon; }

/* LLAVE DE INICIO */
("{") { return CurlyBracket1; }

/* LLAVE DE CIERRE */
("}") { return CurlyBracket2; }

/* FLECHA */
("->") { return Arrow; }

/* PORCENTAJE */
("%") { return Percent; }

/* IDENTIFICADOR */
({LETTER}+({LETTER}|{DIGIT})*) { return Identifier; }

/* ERROR DE ANALISIS */
(.) { return Character; }
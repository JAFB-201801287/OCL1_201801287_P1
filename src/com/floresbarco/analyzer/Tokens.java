package com.floresbarco.analyzer;

public enum Tokens {
    Line,
    LineBreak,
    /* PALABRAS RESERVADAS ---------------------------------------- */
    Conj, // PALABRA RESERVADA PARA CONJUNTOS

    /* SIMBOLOS --------------------------------------------------- */
    QuotationMarks, // COMILLAS (")
    QuotationMarks1, // COMILLAS (\")
    SingleQuotes, // COMILLAS SIMPLES (')
    SingleQuotes1, // COMILLAS SIMPLES (\')
    Dot, // PUNTO (.)
    Plus, // MAS (+)
    Asterisk, // ASTERISCO (*)
    QuestionMarck, // SIGNO DE INTERROGACION (?)
    VerticalBar, // BARRA VERTICA (|)
    Dash, // GUION (~)
    Comma, // COMA (,)
    Semicolon, // PUNTO Y COMA (;)
    Colon, // DOS PUNTOS (:)
    CurlyBracket1, // LLAVE DE INICIO ({)
    CurlyBracket2, // LLAVE DE CIERRE (})
    Arrow, // FLECHA (->)
    Percent, // PORCENTAJE (%)

    /* EXPRESIONES REGULARES --------------------------------------- */
    Letter,
    Digit,
    Identifier, // IDENTIFICADOR

    /* CARACTER ------------------------------------------- */
    Character,

    /* MANEJO DE ERRORES ------------------------------------------- */
    Error
}
package com.floresbarco.analyzer;

public enum Tokens {
    Line,
    /* PALABRAS RESERVADAS ---------------------------------------- */
    Conj, // PALABRA RESERVADA PARA CONJUNTOS

    /* SIMBOLOS --------------------------------------------------- */
    QuotationMarks, // COMILLAS (")
    SingleQuotes, // COMILLAS SIMPLES (')
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
    Identifier, // IDENTIFICADOR

    /* MANEJO DE ERRORES ------------------------------------------- */
    Character
}

package com.floresbarco.analyzer;

import java_cup.runtime.Symbol;

import java.io.StringReader;

public class SyntaxAnalyzer {

    public String analyzer(String text) {
        Syntax syntax = new Syntax(new LexerCup(new StringReader(text)));
        try {
            syntax.parse();
            return "FUNCIONA";
        } catch (Exception ex) {
            Symbol sym = syntax.getSymbol();

            if(sym != null) {
                return "FALLO";
            }

        }
        return "FALLO";
    }
}

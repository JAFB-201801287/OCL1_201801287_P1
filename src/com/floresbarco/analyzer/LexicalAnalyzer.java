package com.floresbarco.analyzer;

import com.floresbarco.controller.LexTableController;
import com.floresbarco.model.LexTable;

import java.io.IOException;
import java.io.StringReader;

public class LexicalAnalyzer {

    public LexicalAnalyzer() {
    }

    public void analyzer(String text) throws IOException {

        Lexer lexer = new Lexer(new StringReader(text));
        LexTable lexTable = null;
        Integer line = 1;
        LexTableController.getInstance().clear();

        while (true) {
            Tokens token = lexer.yylex();
            boolean flag = true;

            if (token == null) break;
            switch (token) {
                case Line:
                    line++;
                    flag = false;
                    break;
                case Conj:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "PALABRA RESERVADA: CONJUNTO");
                    break;
                case QuotationMarks:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "COMILLAS");
                    break;
                case SingleQuotes:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "COMILLAS SIMPLES");
                    break;
                case Dot:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "PUNTO");
                    break;
                case Plus:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "SIGNO DE MAS");
                    break;
                case Asterisk:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "SIGNO DE MULTIPLICACION");
                    break;
                case QuestionMarck:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "SIGNO DE INTERROGACION");
                    break;
                case VerticalBar:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "BARRA VERTICAL");
                    break;
                case Dash:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "GUION");
                    break;
                case Comma:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "COMA");
                    break;
                case Semicolon:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "PUNTO Y COMA");
                    break;
                case Colon:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "DOS PUNTOS");
                    break;
                case CurlyBracket1:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "LLAVE DE INICIO");
                    break;
                case CurlyBracket2:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "LLAVE DE CIERRE");
                    break;
                case Arrow:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "FLECHA");
                    break;
                case Percent:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "SIGNO DE PORCENTAJE");
                    break;
                case Identifier:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "IDENTIFICADOR");
                    break;
                case Character:
                    lexTable = new LexTable(line, 0, lexer.yytext(), "CARACTER");
                    break;
            }

            if (flag) {
                LexTableController.getInstance().add(lexTable);
            }
        }

    }
}

package com.floresbarco.model;

public class LexTable {
    Integer row;
    Integer column;
    String lexeme;
    String token;

    // CONSTRUCTOR
    public LexTable() {
        this.row = 0;
        this.column = 0;
        this.lexeme = "";
        this.token = "";
    }

    public LexTable(Integer row, Integer column, String lexeme, String token) {
        this.row = row;
        this.column = column;
        this.lexeme = lexeme;
        this.token = token;
    }

    // GETTERS AND SETTERS
    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

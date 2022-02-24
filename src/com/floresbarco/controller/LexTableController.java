package com.floresbarco.controller;

import com.floresbarco.model.LexTable;

import java.util.ArrayList;

public class LexTableController {
    private static LexTableController instance;
    private ArrayList<LexTable> lexTables;

    // CONSTRUCTOR
    public LexTableController() {
        this.lexTables = new ArrayList<LexTable>();
    }

    // SINGLETON
    public static synchronized LexTableController getInstance() {
        if(instance == null) {
            instance = new LexTableController();
        }
        return instance;
    }

    // GET
    public ArrayList<LexTable> get() {
        return this.lexTables;
    }

    public String[][] getArray() {
        Integer count = 0;
        String[][] temp = new String[lexTables.size()][3];
        for (LexTable lexTable : lexTables) {
            temp[count][0] = lexTable.getLexeme();
            temp[count][1] = lexTable.getToken();
            temp[count][2] = lexTable.getRow() + "";

            //System.out.println("TOKEN: " + lexTable.getToken() + " LEXEMA: " + lexTable.getLexeme());
            count++;
        }

        return temp;
    }

    // AGREGAR
    public void add(LexTable lexTable) {
        this.lexTables.add(lexTable);
    }

    // LIMPIAR
    public void clear() {
        this.lexTables = new ArrayList<LexTable>();
    }
}

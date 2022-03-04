package com.floresbarco.model;

import java.util.ArrayList;

public class Group {
    private Integer id;
    private String name;
    private String firstCharacter;
    private String secondCharacter;
    private ArrayList<String> list;

    // CONSTRUTORES
    public Group() {
        this.id = 0;
        this.name = "";
        this.firstCharacter = "";
        this.secondCharacter = "";
        this.list = null;
    }

    public Group(String name, String firstCharacter, String secondCharacter) {
        this.id = 0;
        this.name = name;
        this.firstCharacter = firstCharacter;
        this.secondCharacter = secondCharacter;
        this.list = null;
    }

    public Group(String name, ArrayList<String> list) {
        this.id = 0;
        this.name = name;
        this.firstCharacter = firstCharacter;
        this.secondCharacter = secondCharacter;
        this.list = list;
    }

    // GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstCharacter() {
        return firstCharacter;
    }

    public void setFirstCharacter(String firstCharacter) {
        this.firstCharacter = firstCharacter;
    }

    public String getSecondCharacter() {
        return secondCharacter;
    }

    public void setSecondCharacter(String secondCharacter) {
        this.secondCharacter = secondCharacter;
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }
}

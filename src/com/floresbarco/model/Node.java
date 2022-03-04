package com.floresbarco.model;

import java.util.ArrayList;

public class Node {
    private Integer id;
    private String element;
    private String conj;
    private Node before;
    private Node after;
    private boolean anulable;
    private Integer indentifier;
    private ArrayList<Integer> firstPos;
    private ArrayList<Integer> lastPos;

    public Node() {
        this.id = 0;
        this.element = "";
        this.conj = "";
        this.before = null;
        this.after = null;
        this.indentifier = 0;
        this.firstPos = new ArrayList<>();
        this.lastPos = new ArrayList<>();
    }

    public Node(Integer id, String element, String conj, Node before, Node after, Integer indentifier) {
        this.id = id;
        this.element = element;
        this.conj = conj;
        this.before = before;
        this.after = after;
        this.anulable = false;
        this.indentifier = indentifier;
        this.firstPos = new ArrayList<>();
        this.firstPos.add(indentifier);
        this.lastPos = new ArrayList<>();
        this.lastPos.add(indentifier);
    }

    public Node(Integer id, String element, String conj, Node before, Node after, String anulable) {
        this.id = id;
        this.element = element;
        this.conj = conj;
        this.before = before;
        this.after = after;
        this.anulable = false;
        this.indentifier = 0;
        this.firstPos = new ArrayList<>();
        this.lastPos = new ArrayList<>();
        switch (anulable) {
            case "*":
            case "?":
                this.anulable = true;
                this.firstPos.addAll(before.getFirstPos());
                this.lastPos.addAll(before.getLastPos());
                break;
            case "+":
                this.anulable = before.isAnulable();
                this.firstPos.addAll(before.getFirstPos());
                this.lastPos.addAll(before.getLastPos());
                break;
            case "|":
                this.anulable = (before.isAnulable() || after.isAnulable());
                this.firstPos.addAll(before.getFirstPos());
                this.firstPos.addAll(after.getFirstPos());
                this.lastPos.addAll(before.getLastPos());
                this.lastPos.addAll(after.getLastPos());
                break;
            case ".":
                this.anulable = (before.isAnulable() && after.isAnulable());

                this.firstPos.addAll(before.getFirstPos());
                if(before.isAnulable()) {
                    this.firstPos.addAll(before.getFirstPos());
                }

                if(after.isAnulable()) {
                    this.lastPos.addAll(before.getLastPos());
                }
                this.lastPos.addAll(after.getLastPos());

                break;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getConj() {
        return conj;
    }

    public void setConj(String conj) {
        this.conj = conj;
    }

    public Node getBefore() {
        return before;
    }

    public void setBefore(Node before) {
        this.before = before;
    }

    public Node getAfter() {
        return after;
    }

    public void setAfter(Node after) {
        this.after = after;
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }

    public Integer getIndentifier() {
        return indentifier;
    }

    public void setIndentifier(Integer indentifier) {
        this.indentifier = indentifier;
    }

    public ArrayList<Integer> getFirstPos() {
        return firstPos;
    }

    public void setFirstPos(ArrayList<Integer> firstPos) {
        this.firstPos = firstPos;
    }

    public ArrayList<Integer> getLastPos() {
        return lastPos;
    }

    public void setLastPos(ArrayList<Integer> lastPos) {
        this.lastPos = lastPos;
    }
}

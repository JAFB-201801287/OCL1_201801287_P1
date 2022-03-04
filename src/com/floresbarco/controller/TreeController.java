package com.floresbarco.controller;

import com.floresbarco.model.Group;
import com.floresbarco.model.Node;

import javax.swing.*;
import java.util.HashMap;

public class TreeController {
    private static TreeController instance;
    // EXPRESIONES REGULARES
    private HashMap<String, Node> expressions;
    // GRUPOS O CONJUNTOS DE EXPRESIONES REGULARES
    private HashMap<String, Group> groups;

    // CONSTRUCTOR
    public TreeController() {
        this.expressions = new HashMap<String, Node>();
        this.groups = new HashMap<String, Group>();
    }

    // SINGLETON
    public static synchronized TreeController getInstance() {
        if(instance == null) {
            instance = new TreeController();
        }
        return instance;
    }

    public void addExpression(String key, Node node) {
        this.expressions.put(key, node);
        System.out.println("KEY: " + key + ", " + node.getElement());
    }

    public void addGroup(String key, Group group) {
        this.groups.put(key, group);
        System.out.println("KEY: " + key + ", GRUPO:" + group);
    }

    public void automataTreeReport() {
        for (String key: expressions.keySet()) {
            String elements = "\nsubgraph cluster {\nlabel=\"" + key + "\"\n" + treeReport(expressions.get(key)) + "\n}";
            report(key, elements);
        }
    }

    private String treeReport(Node node) {
        String temp = "";
        if(node != null) {
            String xlabel = "";
            String firstPos = "";
            String lastPos = "";

            temp += "\t\"node" + node.getId() +"\" [\n" +
                    "\t\tlabel = \"" + node.getElement() + "\"\n";
            if (node.getIndentifier() != 0) {
                xlabel += "<FONT COLOR=\"darkgreen\" POINT-SIZE=\"6\">" + node.getIndentifier() + "; </FONT>";
            }
            if(node.isAnulable()) {
                xlabel += "<FONT COLOR=\"darkred\" POINT-SIZE=\"6\">A; </FONT>";
            } else {
                xlabel += "<FONT COLOR=\"darkred\" POINT-SIZE=\"6\">N; </FONT>";
            }

            Integer count = 0;
            for (Integer n: node.getFirstPos()) {
                if (count == 0) {
                    firstPos += n;
                } else {
                    firstPos += ("," + n);
                }
                count++;
            }

            count = 0;
            for (Integer n: node.getLastPos()) {
                if (count == 0) {
                    lastPos += n;
                } else {
                    lastPos += ("," + n);
                }
                count++;
            }

            xlabel += "<FONT COLOR=\"blue\" POINT-SIZE=\"6\">{" + firstPos + "}; </FONT>";
            xlabel += "<FONT COLOR=\"darkorange\" POINT-SIZE=\"6\">{" + lastPos + "}; </FONT>";

            temp += "\t\txlabel =<" + xlabel + ">\n";
            temp += "\t\tshape = \"circle\"\n" +
                    "\t];\n";

            if(node.getBefore() != null) {
                temp += "\t\"node" + node.getId() + "\" -> \"node" + node.getBefore().getId() + "\"\n";
                temp += treeReport(node.getBefore());
            }

            if(node.getAfter() != null) {
                temp += "\t\"node" + node.getId() + "\" -> \"node" + node.getAfter().getId() + "\"\n";
                temp += treeReport(node.getAfter());
            }
        }

        return temp;
    }

    public void report(String name, String elements) {
        String head = "digraph g {\n" +
                "\tgraph [\n" +
                "\t\trankdir = \"LR\"\n" +
                "\t];\n" +
                "\t\n" +
                "\tnode [\n" +
                "\t\tfontsize = \"16\"\n" +
                "\t\tshape = \"ellipse\"\n" +
                "\t];\n" +
                "\t\n" +
                "\tedge [\n" +
                "\t];\n\n" +
                elements + "\n" +
                "}";

        DocumentController.getInstance().documentWriting("Report_" + name + ".dot", head);
        DocumentController.getInstance().execGraphviz("Report_" + name + ".dot", "Report_" + name, "png");
        DocumentController.getInstance().execGraphviz("Report_" + name + ".dot", "Report_" + name, "pdf");
        DocumentController.getInstance().execGraphviz("Report_" + name + ".dot", "Report_" + name, "svg");
        //DocumentController.getInstance().openDocument("Report_" + name + ".png");
    }
}

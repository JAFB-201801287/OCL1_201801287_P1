package com.floresbarco.view;

import com.floresbarco.analyzer.*;
import com.floresbarco.controller.LexTableController;
import com.floresbarco.controller.TreeController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.StringReader;

public class App extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JLabel titleWindow;
    private JPanel editorPane;
    private JScrollPane editorScroll;
    private JTextPane editor;
    private JTabbedPane downTabPane;
    private JPanel consoleTab;
    private JScrollPane consoleScroll;
    private JTabbedPane topTabPane;
    private JButton automataButton;
    private JButton analyzerButton;
    private JTextPane console;
    private JSplitPane splitPane;
    private JPanel lexTab;
    private JTable lexTable;
    private JScrollPane lexTableScroll;
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5;
    private DefaultTableModel modelTable;

    public App(String title) {
        super(title);
        initComponents();
    }

    public static void main(String[] args) throws Exception {
        JFrame jFrame = new App("[OLC1] PROYECTO 1 - 201801287");
        jFrame.setExtendedState(jFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        //Generate generate = new Generate();
        //generate.generateFlex();
        //generate.generateCup();
    }

    private void initComponents() {

        initMenu();
        initTextEditor();
        initButtons();
        initTable();

        this.setLayout(null); // LAYAUT ABSOLUTO
        this.setBounds(10,10,1000,800); // TAMAÑO DE VENTANA
        //this.setTitle("[OLC1] PROYECTO 1 - 201801287"); // TITULO
        this.setResizable(true); // REDIMENSIONAR
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // CERRAR VENTANA
        this.setLocationRelativeTo(null); // PONE LA VENTANA EN EL CENTRO
        this.setContentPane(mainPanel);
        this.setVisible(true); // MUESTRA TODA LA VENTANA
    }

    private void initTable() {
        modelTable = new DefaultTableModel();
        modelTable.addColumn("LEXEMA");
        modelTable.addColumn("TOKEN");
        modelTable.addColumn("LINEA");
        for(String[] temp : LexTableController.getInstance().getArray()) {
            modelTable.addRow(temp);
            //System.out.println(temp[0] + " TOKEN:" + temp[1]);
        }
        lexTable.setModel(modelTable);
    }

    private void initTextEditor() {
        NumberLine editorLineNumber = new NumberLine(editor);
        editorScroll.setRowHeaderView(editorLineNumber);

        NumberLine consoleLineNumber = new NumberLine(console);
        consoleScroll.setRowHeaderView(consoleLineNumber);
    }

    private void initMenu() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu1 = new JMenu("Opciones");
        menuBar.add(menu1);

        menuItem1 = new JMenuItem("Nuevo Archivo");
        menuItem1.addActionListener(this);
        menu1.add(menuItem1);

        menuItem2 = new JMenuItem("Abrir archivo");
        menuItem2.addActionListener(this);
        menu1.add(menuItem2);

        menuItem3 = new JMenuItem("Guardar");
        menuItem3.addActionListener(this);
        menu1.add(menuItem3);

        menuItem4 = new JMenuItem("Guardar como");
        menuItem4.addActionListener(this);
        menu1.add(menuItem4);

        menuItem5 = new JMenuItem("Generar Autómatas");
        menuItem5.addActionListener(this);
        menu1.add(menuItem5);
    }

    private void initButtons() {
        automataButton.addActionListener(this);
        analyzerButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource() == menuItem1) {
                // NUEVO ARCHIVO
                System.out.println("NUEVO ARCHIVO");
            } else if(e.getSource() == menuItem2) {
                // ABRIR ARCHIVO
                System.out.println("ABRIR ARCHIVO");
            } else if(e.getSource() == menuItem3) {
                // GUARDAR
                System.out.println("GUARDAR");
            } else if(e.getSource() == menuItem4) {
                // GUARDAR COMO
                System.out.println("GUARDAR COMO");
            } else if(e.getSource() == menuItem5 || e.getSource() == automataButton) {
                // GENERAR AUTOMATAS
                System.out.println("GENERAR AUTOMATAS");
                TreeController.getInstance().automataTreeReport();
            } else if(e.getSource() == analyzerButton) {
                // ANALIZAR ENTRADA
                analyzerInput();
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    private void analyzerInput() throws IOException {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
        lexicalAnalyzer.analyzer(editor.getText());
        console.setText(syntaxAnalyzer.analyzer(editor.getText()));
        initTable();

    }

}

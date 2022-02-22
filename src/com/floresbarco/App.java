package com.floresbarco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private JLabel titleWindow;
    private JPanel editorPane;
    private JScrollPane textScroll;
    private JTextArea editor;
    private JTabbedPane downTabPane;
    private JPanel tab;
    private JTextArea console;
    private JScrollPane consoleScroll;
    private JTabbedPane topTabPane;
    private JButton GENERARAUTÓMATASButton;
    private JButton ANALIZARENTRADASButton;
    private JLabel editorTitle;
    private JLabel consoleTitle;
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5;

    public App(String title) {
        super(title);
        initComponents();
    }

    public static void main(String[] args) {
        JFrame jFrame = new App("[OLC1] PROYECTO 1 - 201801287");
        jFrame.setExtendedState(jFrame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {

        initMenu();

        editor.setMargin(new Insets(10,10,10,10));

        this.setLayout(null); // LAYAUT ABSOLUTO
        this.setBounds(10,10,1000,800); // TAMAÑO DE VENTANA
        //this.setTitle("[OLC1] PROYECTO 1 - 201801287"); // TITULO
        this.setResizable(true); // REDIMENSIONAR
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // CERRAR VENTANA
        this.setLocationRelativeTo(null); // PONE LA VENTANA EN EL CENTRO
        this.setContentPane(mainPanel);
        this.setVisible(true); // MUESTRA TODA LA VENTANA
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

    @Override
    public void actionPerformed(ActionEvent e) {
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
        } else if(e.getSource() == menuItem5) {
            // GENERAR AUTOMATAS
            System.out.println("GENERAR AUTOMATAS");
        }
    }
}

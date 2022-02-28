package com.floresbarco.analyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Generate {
    public void generateFlex() throws IOException, Exception{
        String ruta1 = "/home/jafb/IdeaProjects/OCL1_201801287_P1/src/com/floresbarco/analyzer/Lexer.flex";
        File archivo;

        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
    }

    public void generateCup() throws IOException, Exception {
        String address = "/home/jafb/IdeaProjects/OCL1_201801287_P1/src/com/floresbarco/analyzer/LexerCup.flex";
        String[] addressSyntax = {"-parser", "Syntax", "/home/jafb/IdeaProjects/OCL1_201801287_P1/src/com/floresbarco/analyzer/Syntax.cup"};
        File file;

        file = new File(address);
        JFlex.Main.generate(file);

        java_cup.Main.main(addressSyntax);

        Path addressSym = Paths.get("/home/jafb/IdeaProjects/OCL1_201801287_P1/src/com/floresbarco/analyzer/sym.java");
        if (Files.exists(addressSym)) {
            Files.delete(addressSym);
        }
        Files.move(
                Paths.get("/home/jafb/IdeaProjects/OCL1_201801287_P1/sym.java"),
                Paths.get("/home/jafb/IdeaProjects/OCL1_201801287_P1/src/com/floresbarco/analyzer/sym.java")
        );

        Path rutaSin = Paths.get("/home/jafb/IdeaProjects/OCL1_201801287_P1/src/com/floresbarco/analyzer/Syntax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("/home/jafb/IdeaProjects/OCL1_201801287_P1/Syntax.java"),
                Paths.get("/home/jafb/IdeaProjects/OCL1_201801287_P1/src/com/floresbarco/analyzer/Syntax.java")
        );

    }
}
